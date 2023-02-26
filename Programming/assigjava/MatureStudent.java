package sac;//package location 

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
}//end class 