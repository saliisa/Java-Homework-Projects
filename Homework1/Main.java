package Homework1;
//package dev.m3s.programming2.homework1;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();

        Student student2 = new Student("Mouse", "Mickey");

        Student student3 = new Student("Mouse", "Minnie");

        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        student1.setBachelorCredits(120);
        student1.setMasterCredits(180);
        student1.setTitleOfMastersThesis("Masters thesis title");
        student1.setTitleOfBachelorsThesis("Bachelors thesis title");
        student1.setStartYear(2001);
        student1.setGraduationYear(2020); //2020
        //


        student2.setPersonId("221199-123A");
        student2.setBachelorCredits(65);
        student2.setMasterCredits(22);
        student2.setTitleOfBachelorsThesis("A new exciting purpose of life");

       



        ///
        student3.setPersonId("111111-334");
        student3.setBachelorCredits(215);
        student3.setMasterCredits(120);
        student3.setTitleOfBachelorsThesis("Dreaming of a white Christmas");
        student3.setTitleOfMastersThesis("Christmas - the most wonderful time of the year");
        student3.setStartYear(2018);
        student3.setGraduationYear(2022);


        System.out.println("Student 1 ----\n" + student1 + "\n");
        System.out.println("Student 2 -----\n" + student2 + "\n");
        System.out.println("Student 3 ----\n" + student3);


        /*Print the output when setting the person id “This is a string” to one of the students.
         Print the output when setting the person id “320187-1234” to one of the students.
         Print the output when setting the person id “11111111-3334” to one of the students.
         Print the output when setting the person id “121298-830A” to one of the students. */

         //Invalid Birthday
         //Invalid Birthday
         //Invalid Birthday
         //Incorrect check mark?


         
    }
    
}
