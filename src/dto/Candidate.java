/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import controller.GradeList;
import java.util.Date;
import java.util.List;
import utils.Utils;

/**
 *
 * @author ACER
 */
public abstract class Candidate implements Comparable<Candidate>{
    protected String candidateId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phone;
    private int candidateType;

    
    
    
    public Candidate() {
    }

    

    public Candidate(String candidateId, String firstName, String lastName, String gender, String dateOfBirth, String email, String phone, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.candidateType = candidateType;

    }




    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }
    
    

    @Override
    public String toString() {
        return "ID = " + candidateId + ", firstName = " + firstName + ", lastName = " + lastName + ", gender = " + gender + ", dateOfBirth = " + dateOfBirth + ", email = " + email + ", phone = " + phone + ", candidateType = " + candidateType;
    }

    @Override
    public boolean equals(Object obj) {
        Candidate candidate = (Candidate) obj;
        return this.candidateId.equals(candidate.getCandidateId());
    }
    
    public void update(String firstName, String lastName, String gender, String dateOfBirth, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public int compareTo(Candidate o) {
        return this.firstName.compareTo(o.getFirstName());
        
    }
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public Grade getGradeForDepartment(String departmentId) {
//        return this.gradeList.getGradeForDepartment(departmentId);
//    }
//    
//    public void setGradeForDepartment(Grade grade) {
//        this.gradeList.setGradeForDepartment(grade);
//    }
    

    
}
