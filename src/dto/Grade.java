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
public class Grade {
    
    private double knowledge;
    private double  skill;
    private double experience;
    private String departmentId;
    private String candidateId;
    
    public Grade() {
    }

    public Grade(double knowledge, double skill, double experence, String departmentId, String candidateId) {
        this.knowledge = knowledge;
        this.skill = skill;
        this.experience = experence;
        this.departmentId = departmentId;
        this.candidateId = candidateId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
    
    

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
 
    

    public double getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(double knowledge) {
        this.knowledge = knowledge;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    

    
    
    
    
}
