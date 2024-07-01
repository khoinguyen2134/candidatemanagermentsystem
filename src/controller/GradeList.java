/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Grade;
import dto.I_Grade_List;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author ACER
 */
public class GradeList extends ArrayList<Grade> implements I_Grade_List{

    @Override
    public Grade getGradeForDepartment(String departmentId) {
        Grade result = null;
        try {
            for (Grade grade : this) {
                if (grade.getDepartmentId().equals(departmentId)) {
                    result = grade;
                }
            }
        } catch (Exception e) {
            Utils.display("Error!!!" + e.getMessage());
        }

        return result;
    }
    
    
    
    @Override
    public void setGradeForDepartment(Grade newGrade) {
        boolean check = false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getDepartmentId().equals(newGrade.getDepartmentId())) {
                this.set(i, newGrade);
                check = true;
                break;
            }

        }
        if (!check) {
            this.add(newGrade);
        }
        
    }

    
    
}
