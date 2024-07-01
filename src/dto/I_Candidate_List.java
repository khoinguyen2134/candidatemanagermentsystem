/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author ACER
 */
public interface I_Candidate_List {
    boolean add();
    boolean update(String id);
    boolean delete(String id);
    boolean checkExist(String id);
    boolean enterGradeForCandidate(String candidateId, String departmentId);
    void displayCandidate();
    void display(String candidateId, List<Department> departmentList);
    void sortByFirstName();
}
