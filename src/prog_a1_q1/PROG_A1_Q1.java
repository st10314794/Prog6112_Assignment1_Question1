/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog_a1_q1;

import java.util.Scanner;

/**
 *
 * @author Mik
 */
public class PROG_A1_Q1 {

    final static Scanner sc = new Scanner(System.in);
    final static Student stud = new Student();

    public static void main(String[] args) {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*********************************");
        launchMenu();
    }//endmain

    public static void launchMenu() {
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String launch = sc.nextLine();

            if (launch.equals("1")) {
                mainMenu();
            } else {
                System.out.println("Thank you for using this program.");
                System.exit(0);
            }//endif
        }//endwhile
    }//endlaunchmenu

    public static void mainMenu() {

        System.out.println("Please select one of the following menu items:\n"
                + "(1) Capture a new student.\n"
                + "(2) Search for a new student\n"
                + "(3) Delete a student \n"
                + "(4) Update student information\n"
                + "(5) Print student report\n"
                + "(6) Exit Application");

        String menuChoice = sc.nextLine();

        switch (menuChoice) {
            case "1":
                stud.enterDetails();
                break;
            case "2":
                stud.SearchStudent();
                break;
            case "3":
                stud.DeleteStudent();
                break;
            case "4":
                stud.updateInformation();
                break;
            case "5":
                stud.StudentReport();
                break;
            case "6":
                stud.ExitStudentApplication();
                break;
            default:
                System.out.println("Please choose between 1 to 5");
                mainMenu();

        }
    }//endmainmenu

}//endclass
