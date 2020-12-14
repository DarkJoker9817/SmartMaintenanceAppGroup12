drop table if exists "user" cascade;
drop table if exists sys_admin cascade;
drop table if exists maintainer cascade;
drop table if exists site cascade;
drop table if exists competence cascade;
drop table if exists material cascade;
drop table if exists maintenance_procedure cascade;
drop table if exists maintenance_type cascade;
drop table if exists activity cascade;
drop table if exists assigned_activity cascade;
drop function if exists insert_competencies cascade;

create table "user"(
	username text primary key,
	password text not null,
	role text not null
);

create table sys_admin (
	username text primary key,
	password text not null
);

create table maintainer(
	username text primary key,
	availability int[][],
	competencies text[]
);

create table assigned_activity(
	maintainer_username text,
	assigned_activity_id integer,
	assigned_activity_day text,
	assigned_activity_hour integer,
	foreign key(maintainer_username) references maintainer(username) on delete cascade on update cascade,
	primary key(maintainer_username,assigned_activity_id)
);

create table site(
	area text primary key,
	branch_officies text
);

create table competence(
	name_competence text
);

create table material(
	name_material text
);

create table maintenance_type(
	name_type text
);

create table activity(
	id int primary key,
	materials text[],
	week int not null,
	site text,
	maintenance_type text,
	activity_type text not null,
	description text not null,
	estimated_time int not null,
	interruptible bool not null,
	workspace_notes text,
	maintenance_procedure text,
	competencies text[],
	assigned boolean default false
);

create function insert_competencies() returns trigger as $insert_competencies$
	begin
		update activity 
				set competencies ='{PAV Certification,Electrical Maintenance,Knowledge of cable types,Xyz-type robot knowledge,Knowledge of VHDL}' 
				where id = new.id;
		return new;
	end;
$insert_competencies$ language plpgsql;

create trigger insert_activity
	after insert on activity
	for each row execute procedure insert_competencies();

insert into sys_admin(username, password) values ('admin','admin'); 

insert into "user"(username,password,role) 
									values('Pippo','abc','Maintainer'),
										   ('Pluto','def','Maintainer'),
										   ('Paperino','sdf','Planner');
										 
-------------------- Setup table Maintainer ---------------------------------------

insert into maintainer(username,competencies) values('Pippo','{}'),
										            ('Paperino','{}'),
										            ('Topolino','{}');
update maintainer set competencies = array_append(competencies,'PAV Certification') where username = 'Paperino';
update maintainer set competencies = array_append(competencies,'Electrical Maintenance') where username = 'Paperino';
update maintainer set competencies = array_append(competencies,'PAV Certification') where username = 'Pippo';
update maintainer set competencies = array_append(competencies,'Electrical Maintenance') where username = 'Pippo';
update maintainer set competencies = array_append(competencies,'Knowledge of cable types') where username = 'Pippo';
update maintainer set competencies = array_append(competencies,'Electrical Maintenance') where username = 'Topolino';
update maintainer set competencies = array_append(competencies,'PAV Certification') where username = 'Topolino';
update maintainer set competencies = array_append(competencies,'Knowledge of cable types') where username = 'Topolino';
update maintainer set competencies = array_append(competencies,'Xyz-type robot knowledge') where username = 'Topolino';

update maintainer set availability = '{{60,60,60,60,60,60,60},
											{60,60,60,60,60,60,60},
											{60,60,60,60,60,60,60},
											{60,60,60,60,60,60,60},
											{60,60,60,60,60,60,60},
											{60,60,60,60,60,60,60},
											{60,60,60,60,60,60,60}}';


------------------------------------------------------------------------------------

------ Initial setup for table Material and Site -----------------------------------

insert into material(name_material) values('Martello'),('Viti'),('Cacciavite'),('Tubo');
insert into site(area,branch_officies) values('Fisciano','Molding'),('Nusco','Carpentry'),('Morra','Painting');

------------------------------------------------------------------------------------
select * from sys_admin;
select * from "user";
select * from material;
select * from site;
select * from maintainer;
select * from activity;
select * from assigned_activity;

delete from "user";
delete from activity;
delete from assigned_activity;
delete from maintainer;
