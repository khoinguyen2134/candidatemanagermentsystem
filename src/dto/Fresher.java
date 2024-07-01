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
public class Fresher extends Candidate{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String graduationDate, String graduationRank, String education, String candidateId, String firstName, String lastName, String gender, String dateOfBirth, String email, String phone, int candidateType) {
        super(candidateId, firstName, lastName, gender, dateOfBirth, email, phone, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    
    

    public Fresher() {
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + "graduationDate=" + graduationDate + ", graduationRank=" + graduationRank + ", education=" + education;
    }

    @Override
    public void update(String firstName, String lastName, String gender, String dateOfBirth, String email, String phone) {
        super.update(firstName, lastName, gender, dateOfBirth, email, phone);
        this.graduationDate = Utils.getString("Update graduation date: ", this.graduationDate);
        this.graduationRank = Utils.getString("Update graduation rank: ", this.graduationRank);
        this.education = Utils.getString("Update education: ", this.education);
    }

    
    
    
    
}
