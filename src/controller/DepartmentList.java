/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Candidate;
import dto.Department;
import dto.Grade;
import dto.I_Department_List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.Utils;

/**
 *
 * @author ACER
 */
public class DepartmentList extends ArrayList<Department> implements I_Department_List{

    @Override
    public boolean add() {
        boolean result = false;
        boolean check = true;
        String id = "";
        do {
            do {
                id = Utils.getString("Input department ID: ");
                if (this.contains(new Department(id))) {
                    Utils.display("Duplicate department ID!!!");
                    check = true;
                } else {
                    check = false;
                }
            } while (check);
            String departmentName = Utils.getString("Input department name: ");
            int numberOfMembers = Utils.getInt("Input number of members: ", 1, 100);
            this.add(new Department(departmentName, departmentName, numberOfMembers));
            check = false;
            result = true;

        } while (check);
        return result;
    }

    @Override
    public boolean update(String id) {
        boolean result = false;
        if (this.contains(new Department(id))) {
            int index = this.indexOf(new Department(id));
            Department department = this.get(index);
            String newDepartmentName = Utils.getString("Update department name: ", this.get(index).getDepartmentName());
            int newNumberOfMembers = Utils.getInt("Update number of members: ", 1, 100, this.get(index).getNumberOfMembers());
            department = new Department(newDepartmentName, newDepartmentName, newNumberOfMembers);
            this.set(index, department);
            result = true;
        } else {
            Utils.display("Department does not exist");
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try {
            if (this.contains(new Department(id))) {
                int index = this.indexOf(new Department(id));
                if (Utils.confirmYesNo("Do you want to delete department with ID? (Y/N)")) {
                    this.remove(index);
                    result = true;
                } else {
                    Utils.display("You chose no delete department --> " + id + " <--");
                    result = true;
                }
                
            } else {
                result = false;
            }
        }catch (Exception e) {
            Utils.display("Error!!!" + e.getMessage());
        }
        
        
        return result;
    }

    @Override
    public boolean checkExist(String id) {
        boolean result = false;

            if (this.contains(new Department(id))) {
                result = true;
            } else {
                Utils.display("Department does not exist");
            }
        
        
        return result;
    }

    @Override
    public void sortByName() {
        Collections.sort(this);
    }

//    @Override
//    public void display(String departmentId, List<Candidate> candidateList) {
//        if (this.contains(new Department(departmentId))) {
//            int indexOfDepartment = this.indexOf(new Department(departmentId));
//            Department department = this.get(indexOfDepartment);
//            if (department != null) {
//                Utils.display("Department ID: " + department.getDepartmentId());
//                Utils.display("Department name: " + department.getDepartmentName());
//                Utils.display("| ++ Candidate ID ++ | ++Candidate name ++ | ++ Average mark ++ | ++ Status ++ |");
//                Grade grade = null;
//                for (Candidate candidate : candidateList) {
//                    for (Grade g : candidate.getGradeList()) {
//                        if (g.getDepartmentId().equals(departmentId)) {
//                            grade = g;
//                            break;
//                        }
//                    }
//                    if (grade != null) {
//                        String candidateId = candidate.getCandidateId();
//                        String candidateFirstName = candidate.getFirstName();
//                        String candidateLastName = candidate.getLastName();
//                        double averageMark = (grade.getKnowledge() * 0.3) + (grade.getSkill() * 0.3) + (grade.getExperience() * 0.4);
//                        String status = (averageMark > 8.0) ? "Suitable" : "Not Suitable";
//                        Utils.display("      " + candidateId + "     " + candidateFirstName + " " + candidateLastName + "       " + averageMark + "          " + status);
//                    }
//                }
//            }
//
//        } else {
//            Utils.display("Department does not exist");
//        }
//
//
//    }

    @Override
    public void display(String departmentId, List<Candidate> candidateList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
