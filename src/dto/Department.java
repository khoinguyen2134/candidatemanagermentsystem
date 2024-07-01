/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;



/**
 *
 * @author ACER
 */
public class Department implements Comparable<Department>{
    private String departmentId;
    private String departmentName;
    private int numberOfMembers;

    
    
    public Department() {
    }

    public Department(String departmentId) {
        this.departmentId = departmentId;
    }
    
    

    public Department(String departmentId, String departmentName, int numberOfMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfMembers = numberOfMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    @Override
    public boolean equals(Object obj) {
        Department department = (Department) obj;
        return this.departmentId.equals(department.getDepartmentId());
    }

    @Override
    public int compareTo(Department o) {
        return this.departmentName.compareTo(o.departmentName);
    }
    
    
    
}
