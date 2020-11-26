/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author gioca
 */
public class Site {
    
    private String branchOfficies;
    private String area;

    public Site(String branchOfficies, String area) {
        this.branchOfficies = branchOfficies;
        this.area = area;
    }

    public String getBranchOfficies() {
        return branchOfficies;
    }

    public String getArea() {
        return area;
    }

    public void setBranchOfficies(String branchOfficies) {
        this.branchOfficies = branchOfficies;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
    
}
