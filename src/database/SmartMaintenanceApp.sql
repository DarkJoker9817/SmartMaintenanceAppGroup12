drop table if exists "user" cascade;
drop table if exists sys_admin cascade;
drop table if exists maintainer cascade;
drop table if exists site cascade;
drop table if exists competence cascade;
drop table if exists material cascade;
drop table if exists maintenance_procedure cascade;
drop table if exists maintenance_type cascade;
drop table if exists activity cascade;
drop function if exists insert_maintainer cascade;

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
	availability text[][],
	competencies text[],
	assigned_activity_id integer[],
	foreign key(username) references "user"(username) on delete cascade on update cascade
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
	id serial,
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
	competencies text[]
);

create function insert_maintainer() returns trigger as $insert_maintainer$
	begin
		if new.role = 'Maintainer' then
			insert into maintainer(username) values(new.username);
		end if;
		return new;
	end;
$insert_maintainer$ language plpgsql;

create trigger check_user
	after insert on "user"
	for each row execute procedure insert_maintainer();

insert into sys_admin(username, password) values ('admin','admin'); 

insert into "user"(username,password,role) 
					values('Pippo','abc','Maintainer'),
					      ('Pluto','def','Maintainer'),
					      ('Paperino','sdf','Planner');
										  
insert into maintainer(username) values('Pippo');
insert into material(name_material) values('Martello'),('Viti'),('Cacciavite'),('Tubo');
insert into site(area,branch_officies) values('Fisciano','Molding'),('Nusco','Carpentry'),('Morra','Painting');

select * from sys_admin;
select * from "user";
select * from material;
select * from site;
select * from maintainer;
select * from activity;

delete from "user";
delete from activity;
delete from maintainer;
delete from "user" where username = 'Pippo';

update "user" set username = 'Luigi' where id = 1;
