/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import utils.Utils;

/**
 *
 * @author ACER
 */
public class Intern extends Candidate{
    private String majors;
    private String semester;
    private String universityName;

    public Intern(String majors, String semester, String universityName, String candidateId, String firstName, String lastName, String gender, String dateOfBirth, String email, String phone, int candidateType) {
        super(candidateId, firstName, lastName, gender, dateOfBirth, email, phone, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
    
    

    public Intern() {
    }

    public Intern(String majors, String semester, String universityName) {
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "majors=" + majors + ", semester=" + semester + ", universityName=" + universityName;
    }

    @Override
    public void update(String firstName, String lastName, String gender, String dateOfBirth, String email, String phone) {
        super.update(firstName, lastName, gender, dateOfBirth, email, phone);
        this.majors = Utils.getString("Update majors: ", this.majors);
        this.semester = Utils.getString("Update semester: ", this.semester);
        this.universityName = Utils.getString("Update university: ", this.universityName);
    }

    
    
    
    
}
