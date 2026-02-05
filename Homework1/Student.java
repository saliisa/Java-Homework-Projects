package Homework1;
//package dev.m3s.programming2.homework1;
import java.time.Year;
import java.util.Random;

public class Student {

    //Attributes
    private String firstName = "No name";
    private String lastName = "No name";
    private int id = 0;  //init??
    private double bachelorCredits = 0.0;  //init??
    private double masterCredits = 0.0;  //init??
    private String titleOfMastersThesis = "No title";
    private String titleOfBachelorsThesis = "No title";
    private int startYear = Year.now().getValue(); //is this correct??
    private int graduationYear = 0;  //init??
    private String birthDate = "Not available";


    //Constructors
    public Student(){
        //id will be set in here
        setId(id);
    }

    public Student(String lname, String fname){
        //id will also be set in here
      
        setId(id); 
        setFirstName(fname);
        setLastName(lname);
    }


    //Methods
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        if (firstName != null){
            this.firstName = firstName;
        }
    }

    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        if (lastName != null){
            this.lastName = lastName;
        }
    }

    public int getId(){
       return id;
    }

    public void setId(final int id){

        if(getRandomId() >= 1 && getRandomId() <= 100){
          this.id = getRandomId(); //correct functionality??
         
        }

    }

    public double getBachelorCredits(){
        return bachelorCredits;

    }

    public void setBachelorCredits (final double bachelorCredits){
      //if(bachelorCredits > 0.0 && bachelorCredits <= 300.0 ){
            this.bachelorCredits = bachelorCredits;
     //   }


    }

    public String bachelorCreditStatus(){

        double bachelorCr = getBachelorCredits();
        String result = null;
        double leftover = 0.0;

      //  double minBachelorCr = 180.0;

        if(bachelorCr > 0.0 && bachelorCr<= 300.0 ){
            if(bachelorCr >= 180.0 ){
                result = "All required bachelor credits completed (" + bachelorCredits + "/"  + 180.0 + ")";
                return  result;
            } else{
                leftover = 180.0  - bachelorCredits;
                result = "Missing bachelor credits " + leftover + " (" + bachelorCredits + "/"  + 180.0 + ")";
                return  result;
            }
        } else{
            return "Not a valid value"; //or would it be missing bachelor credits?? 
        }
    }

    public double getMasterCredits(){
        return masterCredits;
    }

    public void setMasterCredits (final double masterCredits){
        this.masterCredits = masterCredits;
    }

    public String masterCreditStatus() {
        double masterCr = getMasterCredits();
        String result = null;
        double leftover = 0.0;

        //double minMasterCr = 120.0;

        if(masterCr > 0.0 && masterCr<= 300.0 ){
            if(masterCr >= 120.0 ){
                result = "All required master credits completed (" + masterCredits + "/"  + 120.0 + ")";
                return  result;
            } else{
                leftover = 120.0 - masterCredits;
                result = "Missing master credits " + leftover + " (" + masterCredits + "/"  + 120.0 + ")";
                return  result;
            }
        } else{
            return "Not a valid value"; //or would it be missing master credits??
        }

    
    }




    


    public String getTitleOfMastersThesis(){
        return titleOfMastersThesis;
    }

    public void setTitleOfMastersThesis(String title){
        if(title != null){
            this.titleOfMastersThesis = title;
        }
    }


    public String getTitleOfBachelorsThesis(){
        return titleOfBachelorsThesis;
    }

    public void setTitleOfBachelorsThesis(String title){
        if(title != null){
            this.titleOfBachelorsThesis = title;
        }
    }


    public int getStartYear(){
        return startYear;
    }

    public void setStartYear(final int startYear){
        if (startYear > 2000 && startYear <= Year.now().getValue()){
            this.startYear = startYear;
        }

    }

    public int getGraduationYear(){
        return graduationYear;
    }

    public String setGraduationYear(final int graduationYear){
        //gYear can only be set if the student has:
            //a) completed all required credits ( bachelor + masters)
            //b) given year is within timefram from start of studies
            //  to this date (neither before the start if the studies 
            // nor in the future)  
        //Utilize canGraduate here 

        boolean ableToGraduate = canGraduate(); 

        //if(ableToGraduate == true ){
            if(ableToGraduate == true && (graduationYear >= startYear && graduationYear <= Year.now().getValue())){
                this.graduationYear = graduationYear;
                return "Ok";
            } else if (ableToGraduate == false && graduationYear <= Year.now().getValue()){
                //ISSUE here is that it can only be set if a) and b) are true
                this.graduationYear = graduationYear;
                return "Check required studies"; 
               
            } else{
                return "Check graduation year";
            }
            
        //}

    }


    public boolean hasGraduated(){
        //returns info whether student has grauduated or not ( based on graduation year)
        if(setGraduationYear(graduationYear).equals("Ok")){
            return true;
        } else{
            return false;
        }

    }

    private boolean canGraduate(){
        //checks amt of credits for bachelors and masters 
        // && titles of both theses cannot be default value i.e. (No title)
        double bachelorCr = getBachelorCredits();
        double masterCr = getMasterCredits();

        String bachelorThesisTitle = getTitleOfBachelorsThesis();
        String masterThesisTitle = getTitleOfMastersThesis();

        // FIX for better readability----------------------------------
        if((bachelorCr < 180.0 || masterCr < 120.0) || (bachelorThesisTitle.equals("No title") || masterThesisTitle.equals("No title"))){
            return false; 
        } else {  
            return true;
        } 

    }

    private String graduationStatus(){
        if(hasGraduated() == true){
            return "The student has graduated in " + graduationYear;
        }

        return "The student has not graduated, yet";
    }

    public int getStudyYears(){
        //int studiesLasted = graduationYear - startYear

        /*The method will check if the student has graduated or
            not and will return the number of years used for the
        studies.
        */

        int studiesLasted = 0;

        boolean hasgraduated = hasGraduated();
        int graduated = getGraduationYear();
        int started = getStartYear();

      
        if(hasgraduated == true || graduated > started ){ //definitely will have bugs but works for now
            studiesLasted = graduated - started;
            return studiesLasted;
        }

        return studiesLasted;

      //  graduationYear = getGraduationYear();
      /*  if(hasGraduated() == true){
            studiesLasted = graduationYear - startYear;
            return studiesLasted;
       } else if(hasGraduated() == false && graduationYear == startYear ){
            studiesLasted = 0;
            return studiesLasted; 
       } else{
           graduationYear = getGraduationYear();
            studiesLasted = graduationYear - startYear;
            return studiesLasted; 
       }*/
       
       /*else if(hasGraduated() == false && (graduationYear != startYear || graduationYear  < startYear)){
           graduationYear = getGraduationYear();
            studiesLasted = graduationYear - startYear;
            return studiesLasted; 
       } else if(hasGraduated() == false && graduationYear == startYear ){
            return studiesLasted; 
       }*/

       
    
    }


    private String printStudyYears(){
        int yearsOfStudy = getStudyYears();

        if(hasGraduated() == true){
            return "studies lasted for " + yearsOfStudy + " years";
        } else{
            return "studies have lasted for " + yearsOfStudy + " years";
        }

    }



    private int getRandomId(){
        Random random = new Random();

        int randomNum = random.nextInt(100)+1;

       // this.id = randomNum;

        return randomNum;


    }

    @Override
    public String toString(){
        //ID & Status fix
        return "Student ID: " + id + 
        "\t\t \nFirstName: " + firstName + 
        ", LastName: " + lastName +
        "\nDate of birth: " + birthDate + 
        "\nStatus: " + graduationStatus() + "\n" +  //fix? //hasgraduated boolean
        "StartYear: " + startYear +  " (" + printStudyYears() + ")" + 
        "\nBachelorCredits: " + bachelorCredits + " ==> " + bachelorCreditStatus() + "\n" +  //fix
        "TitleOfBachelorThesis: " + titleOfBachelorsThesis +
        "\nMasterCredits: " + masterCredits  + " ==> "+ masterCreditStatus() + "\n" +  //fix 
        "TitleOfMastersThesis: "  + titleOfMastersThesis + "\n\n" +
        "Can graduate?: " + canGraduate() + "\n" +
        "GraduationYear: " + graduationYear + "\n" +
        "SetGraduationYear: " + setGraduationYear(graduationYear)
        
        ;

        //still more to print;
    }


    //setPersonId







    
}


