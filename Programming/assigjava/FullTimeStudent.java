package sad;

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
    
    static boolean delayedText = true;

    public static void Slow() throws InterruptedException {

        delayedOutput("""
            Welcome to College App \nDeveloped by Eskandar Atrakchi\nPlease select one of the following options below:
            """);

    }

    public static void delayedOutput(String mes) throws InterruptedException {
        if (delayedText) {
            for (int i = 0; i < mes.length(); i++) {
                System.out.print(mes.charAt(i));
                Thread.sleep(50);
            }
            System.out.println();
        } else {
            System.out.println(mes);
        }
    }

}//end the class 