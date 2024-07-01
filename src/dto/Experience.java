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
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience(int expInYear, String proSkill, String candidateId, String firstName, String lastName, String gender, String dateOfBirth, String email, String phone, int candidateType) {
        super(candidateId, firstName, lastName, gender, dateOfBirth, email, phone, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    
    public Experience(String id) {
        this.candidateId = id;
    }

    public Experience(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience() {
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + "expInYear=" + expInYear + ", proSkill=" + proSkill;
    }

    @Override
    public void update(String firstName, String lastName, String gender, String dateOfBirth, String email, String phone) {
        super.update(firstName, lastName, gender, dateOfBirth, email, phone);
        this.expInYear = Utils.getInt("Update experience year: ", 1, 100, this.expInYear);
        this.proSkill = Utils.getString("Update professional skill: ", this.proSkill);
    }

    
    
    
    
}
