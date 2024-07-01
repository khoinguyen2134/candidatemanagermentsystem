/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import dto.Candidate;
import dto.Department;
import dto.Experience;
import dto.Fresher;
import dto.I_Candidate_List;
import dto.Intern;
import java.util.Collections;
import java.util.List;
import utils.Utils;

/**
 *
 * @author ACER
 */
public class CandidateList extends ArrayList<Candidate> implements I_Candidate_List{

    @Override
    public boolean add() {
        boolean result = false;
        boolean check = true;
        String id = "";
        String dateOfBirth = "";
        do {
            try {
                do {
                    id = Utils.getString("Input ID: ");
                    if (this.contains(new Experience(id))) {
                        Utils.display("Duplicate ID");
                    } else {
                        check = false;
                    }
                } while (check);
                String firstName = Utils.getString("Input firstname: ");
                String lastName = Utils.getString("Input lastname: ");
                String gender = Utils.getString("Input gender: ");
                do {
                    dateOfBirth = Utils.getString("Input date of birth: ");
                    check = Utils.isValidDate(dateOfBirth);
                    if (!check) {
                        Utils.display("Invalid date. Enter day with format (dd-mm-yyyy)!!!");
                    }
                } while (!check);
                
                String email = inputEmail("Input email: ");
                String phone = inputPhone("Input phone: ");
                Utils.display("Select your candidate type: ");
                Utils.display("1. Experience.");
                Utils.display("2. Fresher.");
                Utils.display("3. Intern.");
                int choice = Utils.getInt("Select your choice: ", 1, 3);
                Candidate candidate = null;
                switch (choice) {
                    case 1:
                        int expInYear = Utils.getInt("Input year of experience: ", 1, 100);
                        String proSkill = Utils.getString("Input professional skill: ");
                        candidate = new Experience(expInYear, proSkill, id, firstName, lastName, gender, dateOfBirth, email, phone, choice);
                        break;
                    case 2:
                        String graduationYear = Utils.getString("Input graduation year: ");
                        String rank = Utils.getString("Input rank: ");
                        String education = Utils.getString("Input education: ");
                        candidate = new Fresher(graduationYear, graduationYear, education, id, firstName, lastName, gender, dateOfBirth, email, phone, choice);
                        break;
                    case 3:
                        String majors = Utils.getString("Input majors: ");
                        String semester = Utils.getString("Input semester: ");
                        String university = Utils.getString("Input university: ");
                        candidate = new Intern(majors, semester, university, id, firstName, lastName, gender, dateOfBirth, email, phone, choice);
                        
                break;

                }
                this.add(candidate);
                check = false;
            } catch (Exception e) {
                Utils.display("Error!!!" + e.getMessage());
            }
        } while (check);
        result = true;
        return result;
    }
    
    
    
    
    
    private String inputPhone(String welcome) {
        String phone = "";
        boolean checkLoop = true;
        do {
            phone = Utils.getString(welcome);
            if (phone.length() < 10 || phone.length() > 12) {
                Utils.display("Length must be in [10, 12]");
            } else {
                try {
                    Long phoneNumber = Long.parseLong(phone);
                    if (phoneNumber >= 0) {
                        checkLoop = false;
                    } else {
                        Utils.display("Input positive number only!!!");
                    }
                     
                } catch (Exception e) {
                    Utils.display("Input number only!!!");
                }
            }
        } while (checkLoop);
        return phone;
    }
    
    private String inputEmail(String welcome) {
        String email = "";
        boolean checkLoop = true;
        do {
            email = Utils.getString(welcome);
            if (!(email.contains("@") && email.contains("."))) {
                Utils.display("Must be @ and .");
            } else {
                checkLoop = false;
            }
        } while (checkLoop);
        return email;
    }

    @Override
    public boolean update(String id) {
        boolean check = false;
        int index = 0;
        if (this.contains(new Experience(id))) {
            index = this.indexOf(new Experience(id));
            Candidate candidate = this.get(index);
            String newFirstName = Utils.getString("Update firstname: ", candidate.getFirstName());
            String newLastName = Utils.getString("Update lastname: ", candidate.getLastName());
            String newGender = Utils.getString("Update gender: ", candidate.getGender());
            String newDateOfBirth = Utils.updateDate("Update date of birth: ", candidate.getDateOfBirth());
            String newEmail = Utils.getString("Update email: ", candidate.getEmail());
            String newPhone = Utils.getString("Update phone: ", candidate.getPhone());
            candidate.update(newFirstName, newLastName, newGender, newDateOfBirth, newEmail, newPhone);
            this.set(index, candidate);
            check = true;
        } else {
            Utils.display("Not found candidate!!!");
        }
        return check;
    }

    @Override
    public boolean delete(String id) {
        boolean check = false;
        try {
            int index = 0;
            if (this.contains(new Experience(id))) {
                index = this.indexOf(new Experience(id));
                if (Utils.confirmYesNo("Do you want to delete? (Y/N)")) {
                    this.remove(index);
                    check = true;
                } else {
                    Utils.display("You chose no delete department --> " + id + " <--");
                    check = true;
                }
            } else {
                check = false;
            }

        } catch (Exception e) {
            Utils.display("Error!!!" + e.getMessage());
        }

        return check;
    }

    @Override
    public void displayCandidate() {
        for (Candidate candidate : this) {
            Utils.display(candidate.toString());
        }
    }
    
    @Override
    public void sortByFirstName() {
        Collections.sort(this);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    @Override
    public boolean checkExist(String id) {
        boolean result = false;
        if (this.contains(new Experience(id))) {
            result = true;
        } else {
            Utils.display("Candidate does not exist");
        }
        return result;
    }
    
    
//    @Override
//    public void display(String candidateId, List<Department> departmentList) {
//        if (this.contains(new Experience(candidateId))) {
//            int indexOfCandidate = this.indexOf(new Experience(candidateId));
//
//            Candidate candidate = this.get(indexOfCandidate);
//            Utils.display("Candidate ID: " + candidate.getCandidateId());
//            Utils.display("Candidate name: " + candidate.getFirstName() + " " + candidate.getLastName());
//            Utils.display("| ++ No ++ | +++++++ Department name ++++++++ | ++ Average mark ++ | ++ Status ++ |");
//            int index = 1;
//            for (Grade grade : candidate.getGradeList()) {
//                for (Department department : departmentList) {
//                    if (department.getDepartmentId().equals(grade.getDepartmentId())) {
//                        double averageMark = (grade.getKnowledge() * 0.3) + (grade.getSkill() * 0.3) + (grade.getExperience() * 0.4);
//                        String status = (averageMark > 8.0) ? "Suitable" : "Not Suitable";
//                        Utils.display("      " + index + "     " + department.getDepartmentName() + "       " + averageMark + "          " + status);
//                        index++;
//                        break;
//                    }
//                }
//            }
//
//        } else {
//            Utils.display("Candidate does not exist!!!");
//        }
//    }

    
    


    

    @Override
    public boolean enterGradeForCandidate(String candidateId, String departmentId) {
        boolean result = false;
//        try {
//            if (this.contains(new Experience(candidateId))) {
//
//                int indexOfCandidate = this.indexOf(new Experience(candidateId));
//                Candidate candidate = this.get(indexOfCandidate);
//                Grade gradeExist = candidate.getGradeForDepartment(departmentId);
//                
//                
//                if (gradeExist != null) {
//                    if (!Utils.confirmYesNo("Candidates have already graded this Department. Do youwant to overwrite it or not?")) {
//                        result = true;
//                    }
//                } else {
//                    double knowledge = Utils.getDouble("Input knowledge: ", 0, 10);
//                    double skill = Utils.getDouble("Input skill: ", 0, 10);
//                    double experence = Utils.getDouble("Input experence: ", 0, 10);
//                    gradeExist = new Grade(knowledge, skill, experence, departmentId, candidateId);
//                }
//                
//                candidate.setGradeForDepartment(gradeExist);
//                Utils.display("Successfully added grade for candidate: " + candidateId);
//                result = true;
//            } else {
//                Utils.display("Candidate does not exist!!!");
//            }
//        } catch (Exception e) {
//            Utils.display("Error!!" + e.getMessage());
//        }

        return result;
    }

    @Override
    public void display(String candidateId, List<Department> departmentList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
