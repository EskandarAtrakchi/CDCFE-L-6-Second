package sac;//package location 

class FulltimeStudent extends Student {//start class 

    //declare a private String variable 
    private String fullTime;

    //start a constructor 
    public FulltimeStudent(String name, int id, String fullTime) {
        super(name, id); // super that takes two parameters 
        //this variable equals this parameter 
        this.fullTime = fullTime;

    }//end constructor 

    public String isFullTime() {//start return method 

        return fullTime;//value returned 

    }//end method 

    public void setFullTime(String fullTime) {//start method 

        this.fullTime = fullTime;//the variable equals the parameter 

    }//end the method 

}//end the class 