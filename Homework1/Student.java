package Homework1;
//package dev.m3s.programming2.homework1;
import java.time.Year;
import java.util.Random;
import java.lang.Math;

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

    public void setBachelorCredits (final double bachelorCredits){ //check again
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
        return randomNum;
    }

   


    //setPersonId

    public String setPersonId(final String personID){
        //a) checks the personID has been given the correct way (use the method checkPersonIDNumber) and if done so,
        //b) will form the given personID to the format dd.mm.yyyy and ensures the values in that date are correct (use the method checkBirthdate) and if so,
        //c) will check the chracter in the original, given personID was correct (use method checkValidCharacter here) 

        //If all is ok, --> method will set the birthdate (check the format and returns "Ok");
        //If personID NOT 11 characters && century character is NOT one of the valid ones ('+', '-' ,or 'A') --> return "Invalid birthday!"
        //If days, months or year in the ID is NOT correct (note leap year), based on return value of checkBirthdate --> method will return "Invalid birthday!"
        //If the last character in ID (check mark) is NOT correct, based on return value of method checkValidCharacter --> method returns "Incorrect check mark!"

        boolean checkingID = checkPersonIDNumber(personID);
        String date = null;
        String day = null;
        String month = null;
        String year= null;
      //  char [] personIDArray = personID.toCharArray();
        String centChar = null;

       if(checkingID == true){

        //personID = 221199-123A --> 22.11.1999
            //form birthdate in form dd.mm.yyyy
            //use substring
            //checkBirthdate function
            //year based on century char values -->19th cent = +; 20th cent = -; 21st cent = A

            day = personID.substring(0,2);
            month = personID.substring(2,4);
            centChar = personID.substring(6,7);
            year = personID.substring(4,6);

            if(centChar.equals("+")){
                year = "18" + year;
            } else if (centChar.equals("-")){
                year = "19" + year;
            } else if(centChar.equals("A")){
                year = "20" + year;
            } else{ }

            date = day + "." + month + "." + year ;

          
           
            if(checkBirthdate(date) == true){ 
                if(checkValidCharacter(personID)== true){
                    this.birthDate = date;
                    return "Ok";
                }
     
            }
            return "Invalid birthday!";

        }
       
       return "Invalid birthday!";

    }



    private boolean checkPersonIDNumber(final String personID){
        //receives social security num as an input string and checks 
        // the given string has 11 characters and that the 
        // "century character" in the string is a valid one (i.e. '+', '-', or 'A')

        //
        //array?
        //StringBuilder .substring?
        char [] personIDArray = personID.toCharArray();

        if(personIDArray.length == 11 ){
            if (personIDArray[6] == '+' || personIDArray[6] == '-' || personIDArray[6] == 'A'){
                // do i need to check if the century character corresponds to the year born? 
                // --> 19th cent = +; 20th cent = -; 21st cent = A
                return true;
            }
        }

        return false;
           
    }

    private boolean checkLeapYear(int year){ 

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
           return true;
        }

        return false;
    } 



    private boolean checkValidCharacter(final String personID){
        //control character for ID code calculation

        //e.g. 131052-308T -->
        //131052308 / 31 = 4227493.8064516129032258064516129
        // the 0.8064516129032258064516129 * 31 = 24.9999999999999999999999999
        // the number is rounded to 25 == T

        /*Note – here, in this method, the value “221199-123A”
        can be set to be a valid test value (although not a valid
        value in real life). */



       /* if(personID.equals("221199-123A")){
            return true;
        }*/ 

        char controlChar = 0;
        String numbers = null;
        int idNumbers = 0;

        int resultInt = 0;

       // numbers = personID.replaceAll("\\D", "");  //takes all numbers even the controlChar if it is a num

       numbers = personID.substring(0,6) + personID.substring(7,10);
       System.out.println(numbers);

        //controlChar = personID.substring(10, 11);
        controlChar = personID.charAt(personID.length()-1);
        System.out.println(controlChar);

        idNumbers = Integer.parseInt(numbers);
        System.out.println(idNumbers);
        

        //doing calculation:
        double divideCalculation = 0.0;
        double remainder = 0.0;
        double resultDouble = 0.0;
        double resultRounded = 0.0;


        divideCalculation = (idNumbers * 1.0) / 31.0;
        System.out.println(divideCalculation);

        remainder =  divideCalculation - (int)divideCalculation;
        System.out.println("r:" + remainder);


        resultDouble = (remainder * 31.0); //math.round here instead
        System.out.println(resultDouble);

        resultRounded = Math.round(resultDouble);
        System.out.println(resultRounded);


        resultInt = (int)resultRounded;
        System.out.println(resultInt);
       System.out.println("\n");
        //array?

        char [] characterControl = {
            '0','1','2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F','H','J','K',
            'L','M','N','P','R','S','T','U','V',
            'W','X','Y'       
        };


        for(int i = 0; i < characterControl.length; i++){
          if(i == resultInt){ 
                if(controlChar == characterControl[i]){
                    System.out.println("in:");
                    System.out.print(controlChar + ",");
                    System.out.println(characterControl[i]);
                    System.out.println("\n");
                    return true;
                }
               
            }

        }


        return false;

    }


    private boolean checkBirthdate(final String date){ //checks if values in birthdate are correct
        //method receive birthdate in the format dd.mm.yyyy
        //splits day, month, year from given string 

  
        int day = 0;
        int month = 0; 
        int year = 0;
        
        day = Integer.parseInt(date.substring(0,2));
       month =  Integer.parseInt(date.substring(3,5));
        year =  Integer.parseInt(date.substring(6,10));

        if(year > 0){ //also not more than current year?
            if(month > 0 &&  month <= 12){
                if (day > 0 &&  day <= 31) {

                    if(month == 2){
                        if(checkLeapYear(year) == true && day == 29){
                            return true;
                        } else if(day < 29){
                            return true;
                        }else{
                            return false;
                        }
                        
                    }
                    
                    if((month == 4 || month == 6 || month == 9 || month == 11) && day < 31){
                        return true;
                    }

                    return true;

                    
                }

            }
            
        }

        return false;
    }





 @Override
    public String toString(){
        //ID & Status fix
        return "Student ID: " + id + 
        "\t\t \nFirstName: " + firstName + 
        ", LastName: " + lastName +
        "\nDate of birth: " + birthDate  +  //set from id number ?
        "\nStatus: \"" + graduationStatus() + "\"\n" +  //fix? 
        "StartYear: " + startYear +  " (" + printStudyYears() + ")" + 
        "\nBachelorCredits: " + bachelorCredits + " ==> " + bachelorCreditStatus() + "\n" +  //fix
        "TitleOfBachelorThesis: " + titleOfBachelorsThesis +
        "\nMasterCredits: " + masterCredits  + " ==> "+ masterCreditStatus() + "\n" +  //fix 
        "TitleOfMastersThesis: "  + titleOfMastersThesis + "\n\n" +
        "Can graduate?: " + canGraduate() + "\n" +
        "GraduationYear: " + graduationYear + "\n" +
        "SetGraduationYear: " + setGraduationYear(graduationYear) + "\n\n" + "\n" +



        //"Valid birthdate?: " + checkBirthdate(birthDate) + "\n" + //causing issue

        "---------------------------------------------------------------------------"




        



        
        ;

        //still more to print;
    }






    
}


