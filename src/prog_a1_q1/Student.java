/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_a1_q1;

import java.util.ArrayList;
import java.util.Scanner;
import static prog_a1_q1.PROG_A1_Q1.launchMenu;

/**
 *
 * @author Mik
 */
public class Student {

    final static Scanner sc = new Scanner(System.in);
    //ArrayLists
    private ArrayList<String> studentID = new ArrayList<>();
    private ArrayList<String> studentName = new ArrayList<>();
    private ArrayList<Integer> studentAge = new ArrayList<>();
    private ArrayList<String> studentEmail = new ArrayList<>();
    private ArrayList<String> studentCourse = new ArrayList<>();

    //Variables
    private String studID;
    private int studAge;
    private String studName;
    private String studEmail;
    private String studCourse;

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public int getStudAge() {
        return studAge;
    }

    public void setStudAge(int studAge) {
        this.studAge = studAge;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getStudCourse() {
        return studCourse;
    }

    public void setStudCourse(String studCourse) {
        this.studCourse = studCourse;
    }

    public void setStudentName(ArrayList<String> studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(ArrayList<Integer> studentAge) {
        this.studentAge = studentAge;
    }

    public void setStudentEmail(ArrayList<String> studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentCourse(ArrayList<String> studentCourse) {
        this.studentCourse = studentCourse;
    }

    public void setStudentID(ArrayList<String> studentID) {
        this.studentID = studentID;
    }

    public ArrayList<String> getStudentID() {
        return studentID;
    }

    public ArrayList<String> getStudentName() {
        return studentName;
    }

    public ArrayList<Integer> getStudentAge() {
        return studentAge;
    }

    public ArrayList<String> getStudentEmail() {
        return studentEmail;
    }

    public ArrayList<String> getStudentCourse() {
        return studentCourse;
    }

    //method to enter student details
    public void enterDetails() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("************************");

        while (true) {
            System.out.println("Enter the Student ID:");
            String id = sc.next();
            //Checks if ID has been used
            if (studentID.contains(id)) {
                System.out.println("This ID has already been used. Please enter a new ID.");
            } else {
                //If not in use sets as student ID and exits loop
                setStudID(id);
                break;
            }
        }//endwhile

        System.out.println("Enter the student name:");
        String name = sc.next();

        boolean isInputValid = false;
        boolean isAgeValid = false;

        System.out.println("Enter the student age:");
        while (isAgeValid == false) {
            String strAge = sc.next();
            //calls method which check of the string has characters 
            isInputValid = studentAgeValidChar(strAge);
            //if letters are found it displays an error message and continutes to the next iteration of the loop
            if (isInputValid == false) {
                System.out.println("Age must not contain characters");
                System.out.println("Please re-enter age:");
                continue;
            }
            //calls method that checks if age is 16 and above
            isAgeValid = studentAgeValid();
            if (isAgeValid == false) {
                System.out.println("Age must be 16 or above.");
                System.out.println("Please re-enter age:");
            }
        }//endwhile

        System.out.println("Enter the student email:");
        String email = sc.next();

        System.out.println("Enter the student course:");
        String course = sc.next();

        //set values
        setStudName(name);
        setStudEmail(email);
        setStudCourse(course);

        //calling method to save to arraylists
        SaveStudent();

    }//endmethods

    //checks that age has no characters
    public boolean studentAgeValidChar(String strAge) {
        boolean noChars = true;
        try {
            //Tries to parse string to integer
            setStudAge(Integer.parseInt(strAge));
        } catch (NumberFormatException e) {
            noChars = false;
        }
        return noChars;
    }

    //check that age is 16 or above
    public boolean studentAgeValid() {
        boolean validAge = false;
        if (getStudAge() >= 16) {
            validAge = true;
        }
        return validAge;
    }//end

    //saves the student details to arrays
    public void SaveStudent() {
        studentID.add(getStudID());
        studentName.add(getStudName());
        studentAge.add(getStudAge());
        studentEmail.add(getStudEmail());
        studentCourse.add(getStudCourse());

        System.out.println("Your details have been successfully saved.");
    }//end

    public void SearchStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student id to search:");
        String ID = scanner.next();
        System.out.println("--------------------------------------------");
        boolean isFound = studentID.contains(ID);
        int index = studentID.indexOf(ID);
        if (isFound == true) {
            System.out.println("STUDENT ID :" + studentID.get(index));
            System.out.println("STUDENT NAME :" + studentName.get(index));
            System.out.println("STUDENT AGE :" + studentAge.get(index));
            System.out.println("STUDENT EMAIL :" + studentEmail.get(index));
            System.out.println("STUDENT COURSE :" + studentCourse.get(index));
        } else {
            System.out.println("Student with Student ID: " + ID + " was not found");
        }//endif
        System.out.println("--------------------------------------------");

    }

    public void updateInformation() {
        boolean doneUpdate = false;

        while (doneUpdate == false) {
            System.out.println("Enter the ID of the student you wish to update or (0) to exit:");
            String updateID = sc.next();

            if (updateID.equals("0")) {
                doneUpdate = true;
            } else {
                boolean isFound = studentID.contains(updateID);
                int index = studentID.indexOf(updateID);

                if (isFound == true) {
                    System.out.println("Current Student Information\n"
                            + "---------------------------------------------------");
                    System.out.println("STUDENT ID: " + studentID.get(index));
                    System.out.println("STUDENT NAME: " + studentName.get(index));
                    System.out.println("STUDENT AGE: " + studentAge.get(index));
                    System.out.println("STUDENT EMAIL: " + studentEmail.get(index));
                    System.out.println("STUDENT COURSE: " + studentCourse.get(index));
                    System.out.println("---------------------------------------------------");
                    //calling method to update fields
                    updateField(index);
                } else {
                    System.out.println("The ID you entered was not found. Do you wish to enter again? "
                            + "Yes(Y) or any other key to exit");
                    String reEnter = sc.next();
                    //if user enters anything other than y or yes exit the loop
                    if (!reEnter.equalsIgnoreCase("y") && !reEnter.equalsIgnoreCase("yes")) {
                        break;
                    }
                }//endInnerIF

            }//endOuterIf
        }//endwhile
    }

    public void updateField(int index) {
        while (true) {
            System.out.println("Please enter the field you wish to update: \n"
                    + "1) ID\n"
                    + "2) Name\n"
                    + "3) Age\n"
                    + "4) Email\n"
                    + "5) Course\n"
                    + "6) Exit");

            String updateField = sc.next();
            if (updateField.equals("6")) {
                break;
            }//endif

            switch (updateField) {
                case "1":
                    System.out.println("Enter the new student ID");
                    String updateIDField = sc.next();
                    if (studentID.contains(updateIDField)) {
                        System.out.println("This ID has already been used. Please input another ID.\n");
                        continue;
                    }//endif
                    studentID.set(index, updateIDField);
                    break;
                case "2":
                    System.out.println("Enter the new student Name");
                    String updateNameField = sc.next();
                    studentName.set(index, updateNameField);
                    break;
                case "3":
                    System.out.println("Enter the new student Age");
                    String newAge = sc.next();
                    boolean validInput = studentAgeValidChar(newAge);
                    if (validInput == true) {
                        boolean validAge = studentAgeValid();
                        if (validAge == true) {
                            studentAge.set(index, studAge);
                        } else {
                            System.out.println("Age is invalid. Please try again.");
                        }
                    } else {
                        System.out.println("Age is invalid. Please try again.");
                    }
                    break;
                case "4":
                    System.out.println("Enter the new student Email");
                    String updateEmailField = sc.next();
                    studentEmail.set(index, updateEmailField);
                    break;
                case "5":
                    System.out.println("Enter the new student Course");
                    String updateCourseField = sc.next();
                    studentCourse.set(index, updateCourseField);
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }//endswitch
        }//endwhile

    }

    //displays all student details
    public void StudentReport() {
        if (studentID.isEmpty()) {
            System.out.println("You have not entered any student details yet.");
            launchMenu();
        }
        for (int i = 0; i < studentID.size(); i++) {
            System.out.println("STUDENT " + i);
            System.out.println("--------------------------------");
            System.out.println("STUDENT ID: " + studentID.get(i)
                    + "\nSTUDENT NAME: " + studentName.get(i)
                    + "\nSTUDENT AGE: " + studentAge.get(i)
                    + "\nSTUDENT EMAIL: " + studentEmail.get(i)
                    + "\nSTUDENT COURSE: " + studentCourse.get(i));
            System.out.println("--------------------------------");

        }//endfor
    }

    //removes a student
    public void DeleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID to delete:");
        String delID = scanner.next();

        boolean foundID = studentID.contains(delID);

        if (foundID == true) {
            System.out.println("Are you sure you wish to delete student " + delID + " from the system>> Yes(y) to delete.");
            String del = scanner.next();
            if (del.equalsIgnoreCase("y") || del.equalsIgnoreCase("yes")) {
                int delIndex = studentID.indexOf(delID);
                studentID.remove(delIndex);
                studentName.remove(delIndex);
                studentAge.remove(delIndex);
                studentEmail.remove(delIndex);
                studentCourse.remove(delIndex);

                System.out.println("Student with ID: " + delID + " has been successfully removed.");
            }//endinnerif
        } else {
            System.out.println("The student with ID: " + delID + " was not found.");

        }//endif

    }

    //exits application
    public void ExitStudentApplication() {
        System.out.println("Thank you for using this application.");
        System.exit(0);
    }//end

}//endclass
