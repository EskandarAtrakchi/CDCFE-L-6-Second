package sac;

class MatureStudent extends Student {//start class 

    //declare variable private int 
    private int age;

    public MatureStudent(String name, int id, int age) {//start constructor 

        super(name, id);//super takes two parameters 
        this.age = age;//this variable equals this parameter 

    }//end constructor 

    public int getAge() {//start get method 

        return age;//return age

    }//end get 

    public void setAge(int age) {//start set 

        this.age = age;//set age 

    }//end set 
    
    static boolean delayedText = true;

    public static void Slow1() throws InterruptedException {

        delayedOutput("""
            Thank you for using College App that developed by Eskandar Atrakchi\nThe program is shutting down now\nGood-Bye
            """);

    }

    public static void delayedOutput(String mes) throws InterruptedException {
    	
        if (delayedText) {
        	
            for (int i = 0; i < mes.length(); i++) {
            	
                System.out.print(mes.charAt(i));
                Thread.sleep(50);
                
            }
            
            System.out.println();
            
        } 
        
        else {
        	
            System.out.println(mes);
            
        }
    }
    
}//end class 