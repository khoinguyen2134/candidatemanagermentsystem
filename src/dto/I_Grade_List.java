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
public interface I_Grade_List {
    Grade getGradeForDepartment(String departmentId);
    void setGradeForDepartment(Grade newGrade);
}
