package sac;

class Student {//start class 

    private String name;//declare private variable as a String 
    private int id;//declare private variable as an int 

    public Student(String name, int id) {//start a consrtuctor 

        this.name = name;//this variable equals this parameter 
        this.id = id;//this variable equals this parameter 

    }//end  consrtuctor 

    public String getName() {//start get 

        return name;//return name 

    }//end get 

    public void setName(String name) {//start set 

        this.name = name;//set name 

    }//end set 

    public int getId() {//start get 

        return id;//return id 

    }//end get 

    public void setId(int id) {//start set 

        this.id = id;//set id

    }//end set 
}//end class 