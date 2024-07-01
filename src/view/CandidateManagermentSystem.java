/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CandidateList;
import controller.DepartmentList;
import controller.Menu;
import dto.Candidate;
import dto.Department;
import dto.I_Candidate_List;
import dto.I_Department_List;
import dto.I_Menu;
import java.util.Collections;
import java.util.List;
import utils.Utils;

/**
 *
 * @author ACER
 */
public class CandidateManagermentSystem {
    public static void main(String[] args) {
        boolean checkLoop = true;
        boolean subCheckLoop = true;
        boolean check = false;
        boolean subCheck = false;
        boolean confirm = false;
        boolean checkCandidateId = false;
        boolean checkDepartmentId = false;
        int choice = 0;
        int subChoice = 0;
        int countInputIdNotExist = 0;
        String candidateId = "";
        String departmentId = "";
        I_Department_List department_List = new DepartmentList();
        I_Candidate_List candidate_List = new CandidateList();
        I_Menu menu = new Menu();
        menu.addItem("1. Add new Candidate.");
        menu.addItem("2. Update Candidate.");
        menu.addItem("3. Sort by first name.");
        menu.addItem("4. Display.");
        I_Menu subMenuOfCandidate = new Menu();
        subMenuOfCandidate.addItem("2.1 Update Candidate.");
        subMenuOfCandidate.addItem("2.2 Delete Candidate.");
        I_Menu subMenuOfDepartment = new Menu();
        subMenuOfDepartment.addItem("4.1 Update Department");
        subMenuOfDepartment.addItem("4.2 Delete Department");
        do {
            menu.showMenu();
            choice = menu.getChoice();
            countInputIdNotExist = 0;
            subCheckLoop = true;
            switch (choice) {
                case 1:
                    do {
                        check = candidate_List.add();
                        menu.checkTrueFalse(check);
                        confirm = Utils.confirmYesNo("Do you want to continue add candidate? (Y/N)");
                    } while (confirm);                 
                    break;
                case 2:
                    do {
                        candidateId = Utils.getString("Input candidate ID: ");
                        check = candidate_List.checkExist(candidateId);
                        if (countInputIdNotExist == 5) {
                            subCheckLoop = false;
                        }
                        if (check) {
                            do {
                                subMenuOfCandidate.showMenu();
                                subChoice = subMenuOfCandidate.getChoice();
                                switch (subChoice) {
                                    case 1:
                                        subCheck = candidate_List.update(candidateId);
                                        subMenuOfCandidate.checkTrueFalse(subCheck);
                                        subCheckLoop = Utils.confirmYesNo("Do you want to back to the update menu? (Y/N)");                                       
                                        break;
                                    case 2:
                                        subCheck = candidate_List.delete(candidateId);
                                        subMenuOfCandidate.checkTrueFalse(subCheck);
                                        subCheckLoop = Utils.confirmYesNo("Do you want to back to the update menu? (Y/N)");
                                        break;
                                }
                            } while (subCheckLoop);
                        } else {
                            countInputIdNotExist++;
                        }
                    } while (subCheckLoop);
                    break;
                case 3:
//                    do {
//                        check = department_List.add();
//                        menu.checkTrueFalse(check);
//                        confirm = Utils.confirmYesNo("Do you want to continue add department? (Y/N)");
//                    } while (confirm);
                    candidate_List.sortByFirstName();
                    break;
                case 4:
//                    do {
//                        departmentId = Utils.getString("Input department ID: ");
//                        check = department_List.checkExist(departmentId);
//                        if (countInputIdNotExist == 5) {
//                            subCheckLoop = false;
//                        }
//                        if (check) {
//                            do {
//                                subMenuOfDepartment.showMenu();
//                                subChoice = subMenuOfDepartment.getChoice();
//                                switch (subChoice) {
//                                    case 1:
//                                        subCheck = department_List.update(departmentId);
//                                        subMenuOfDepartment.checkTrueFalse(subCheck);
//                                        subCheckLoop = Utils.confirmYesNo("Do you want to back to the update menu? (Y/N)");
//                                        break;
//                                    case 2:
//                                        subCheck = department_List.delete(departmentId);
//                                        subMenuOfDepartment.checkTrueFalse(subCheck);
//                                        subCheckLoop = Utils.confirmYesNo("Do you want to back to the update menu? (Y/N)");
//                                        if (!subCheckLoop) {
//                                            subCheckLoop = false;
//                                        }
//                                        break;
//                                }
//                            } while (subCheckLoop);
//                        } else {
//                            countInputIdNotExist++;
//                        }
//                    } while (subCheckLoop);
                    candidate_List.displayCandidate();
                    break;
                case 5:
//                    do {
//                        candidateId = "";
//                        departmentId = "";
//                        do {
//                            candidateId = Utils.getString("Input candidate ID: ");
//                            checkCandidateId = candidate_List.checkExist(candidateId);
//                            if (countInputIdNotExist == 5) {
//                                subCheckLoop = false;
//                                break;
//                            }
//                            countInputIdNotExist++;
//                        } while (!checkCandidateId);
//                        countInputIdNotExist = 0;
//                        if (checkCandidateId) {
//                            do {
//                                departmentId = Utils.getString("Input department ID: ");
//                                checkDepartmentId = department_List.checkExist(departmentId);
//                                if (countInputIdNotExist == 5) {
//                                    subCheckLoop = false;
//                                    break;
//                                }
//                                countInputIdNotExist++;
//                            } while (!checkDepartmentId);
//                        }
//                        
//                        if (checkCandidateId == true && checkDepartmentId == true) {
//                            subCheck = candidate_List.enterGradeForCandidate(candidateId, departmentId);
//                            if (subCheck) {
//                                subCheckLoop = false;
//                            }
//                        }
//                         
//                    } while(subCheckLoop);
                    
                    break;
//                case 6:
//                    do {
//                        candidateId = "";
//                        do {
//                            candidateId = Utils.getString("Input candidate ID: ");
//                            checkCandidateId = candidate_List.checkExist(candidateId);
//                            if (countInputIdNotExist == 5) {
//                                subCheckLoop = false;
//                                break;
//                            }
//                            countInputIdNotExist++;
//                        } while (!checkCandidateId);
//                        department_List.sortByName();
//                        candidate_List.display(candidateId, (List<Department>) department_List);
//                        subCheckLoop = false;
//                        
//                    } while (subCheckLoop);
//                    break;
//                case 7:
//                    do {
//                        departmentId = "";
//                        do {
//                            departmentId = Utils.getString("Input candidate ID: ");
//                            checkDepartmentId = department_List.checkExist(departmentId);
//                            if (countInputIdNotExist == 5) {
//                                subCheckLoop = false;
//                                break;
//                            }
//                            countInputIdNotExist++;
//                        } while (!checkDepartmentId);
//                        department_List.display(departmentId,(List<Candidate>) candidate_List);
//                    } while (subCheckLoop);
//                    break;    
//                case 8:
//                    checkLoop = Utils.confirmYesNo("Do you want to quit? (Y/N)");
//                    break;
            }
            
            
            
            
            
            
        } while (checkLoop);
        
        
        
    }
}
