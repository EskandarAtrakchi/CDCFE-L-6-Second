package sad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//The class "CollegeApp" is defined here.
class CollegeApp {
	
	// Two static variables "toInt" and "toString" are defined here as a String and an integer respectively.
	// A static variable named "input" is also defined here as a Scanner object that takes input from the standard input stream.

	static String toInt;
	static int toString;
	static Scanner input = new Scanner(System.in);
	
	// This method named "inputValidation" is defined here.
	public static void inputValidation() {//start method 

		// A while loop is started here with a condition that the variable "toInt" does not match a regular expression pattern that matches one or two digits.
		
		while ( ! toInt.matches("\\d{1,2}") ) {//start while loop 
			
			// A message is printed on the console asking the user to enter a valid input.
			
			System.out.println("Numbers only and make sure they are two digits!");
			// The method takes input from the user as a String and assigns it to the variable "toInt".
			toInt = input.next();//take user input as a String 
			
		}//end while loop 
	}//end method 
	
	// This method named "inputValidationFotTheID" is defined here.
	public static void inputValidationFotTheID() {
			
		// A while loop is started here with a condition that the variable "toInt" does not match a regular expression pattern that matches one to three digits.
	    
     while (!toInt.matches("\\d{1,3}")) {
     	
     	// A message is printed on the console asking the user to enter a valid ID.
         
         System.out.println("Enter a valid ID (up to 3 digits): ");
         // The method takes input from the user as a String and assigns it to the variable "toInt".
         toInt = input.next();
         
     }//end loop
 }//end method 
	
	// This method named "inputValidationString" is defined here.
	
	public static void inputValidationString() {
		
		// A while loop is started here with a condition that the variable "toInt" does not match a regular expression pattern that matches one to seven letters.
	    
     while (!toInt.matches("[a-zA-Z]{1,7}")) {
     	
     	// A message is printed on the console asking the user to enter a valid name.
         
         System.out.println("Enter a valid name (up to 7 letters): ");
         
         // The method takes input from the user as a String and assigns it to the variable "toInt".
         
         toInt = input.next();
         
     }//end loop
 }//end method 
	
	// This method prints a table of student information to a file
	// The table includes student names, IDs, class status, age, and whether they are full-time or not
	// It takes an ArrayList of Student objects and a file name as input
	public static void printStudentsTableToFile(ArrayList<Student> students, String fileName) {

		// Create a Path object for the output file
	    Path path = Paths.get("C:\\Users\\escan\\Desktop\\gonote.txt");
	    // Define the table format as a String
	    String table = "+------------+-----+--------+-----+-----------+\n"
	                 + "|    Name    | ID  |  Class | Age | Full-Time |\n"
	                 + "+------------+-----+--------+-----+-----------+\n";
	 // Loop through each student in the ArrayList and add their information to the table string
	    for (Student student : students) {

	        if (student instanceof FulltimeStudent) {
	        	
	        	// If the student is a FulltimeStudent, cast to that type and add their information to the table
	            FulltimeStudent fulltimeStudent = (FulltimeStudent) student;
	            table += String.format("| %-10s | %3d | %-6s | %3s | %9s |\n",
	                                   fulltimeStudent.getName(), fulltimeStudent.getId(),
	                                   "Not MS", "23<", fulltimeStudent.isFullTime());
	        
	        }//end if 
	        
	        else if (student instanceof MatureStudent) {
	        	
	        	// If the student is a MatureStudent, cast to that type and add their information to the table
	            MatureStudent matureStudent = (MatureStudent) student;
	            table += String.format("| %-10s | %3d | %-6s | %3d | %9s |\n",
	                                   matureStudent.getName(), matureStudent.getId(),
	                                   "MS", matureStudent.getAge(),
	                                   "true");
	            
	        }//end else if 
	    }//end for loop 

	    // Add the closing line to the table string
	    table += "+------------+-----+--------+-----+-----------+\n";

	    //start try and catch 
	    try {
	    	
	    	// Write the table string to the output file
	        Files.write(path, table.getBytes()); // write the table to the output file
	        System.out.println("Successfully printed the student table to gonote");

	    }//end try 
	    
	    catch (IOException e) {

	    	// Handle any IOException that occurs during the writing process
	        System.err.println("Error writing to file " + fileName);
	        e.printStackTrace();

	    }//end catch 
	}//end method 


	//start the main method 

 public static void main(String[] args) throws InterruptedException {
	 
	 FulltimeStudent.Slow();
	 
 	//declare arraylist here 
     ArrayList < Student > students = new ArrayList < Student > ( );
     

     //start while loop 
     while (true) {

     	//show the options for the user 
    	 System.out.println("====================================================");
         System.out.println("1. Quit");
         System.out.println("2. Show all full time students");
         System.out.println("3. Show all mature students");
         System.out.println("4. Add a new full time student");
         System.out.println("5. Add a new mature student");
         System.out.println("6. Remove an existing contact");
         System.out.println("7. Sort all students alphabetically");
         System.out.println("8. Print out student list to a text file");
         System.out.println("====================================================");

         //declare a variable called choice to hold the user input and keeps comparing in the if statements 
         String choice = input.next();

         	//start first if statement 
             if (choice.equalsIgnoreCase("1")) {

                 // show Quit
             	MatureStudent.Slow1();
             	//close the scanner input 
             	input.close();
             	//exit 
                 System.exit(0);

             }//end if 
             
             //start second if statement 
             else if (choice.equalsIgnoreCase("2")) {

                 // Show all full time students
             	System.out.println("\t\tShow all full time students\n");
             	System.out.println("Name\t\tID");

             	//running a for loop to show all the students 
                 for (Student student : students) {

                 	//start if statement when the student is instanceof FullStudent class 
                 	//this will come back with true/false statement 
                     if (student instanceof FulltimeStudent) {
                     	
                     	//if true then print 
                         System.out.println(student.getName() +"\t\t"+ student.getId()+"\n");
                         
                     }//end if 
                 }//end for loop 
             }//end else if 
             
             //start third if statement 
             else if (choice.equalsIgnoreCase("3")) {
             	
             	System.out.println("\t\tShow all mature students\n");
             	
             	System.out.println("Name\t\tID");

                 // Show all mature students

             	//start for loop 
                 for (Student student : students) {

                 	//same as the above 
                     if (student instanceof MatureStudent) {
                     	
                     	//printing the results if the student come with result (true) that instanceof MatureStudent 
                         System.out.println(student.getName() + "\t\t" + student.getId());
                         
                     }//end if 
                 }//end for loop 
             }//end else if 

             //start fourth if statement 
             else if (choice.equalsIgnoreCase("4")) {

             	// Add a new full time student
                 System.out.print("Enter student name: ");
                 toInt = input.next();//assign the global variable to the user input 
                 inputValidationString();//calling the method 
                 String name = toInt;//declare a string variable and assign it to the global variable
                 System.out.print("Enter student id: ");
                 toInt = input.next();//assign the globale variable to the user input 
                 inputValidationFotTheID();//calling the method 
                 int tostring = Integer.parseInt(toInt);//parsing the user input 
                 int id = tostring;//declaring an int variable and assigning it to the global variable 
                 System.out.print("Is the student full-time? (true/false): ");
                 toInt = input.next();//assigning global variable to the user input 
                 String fullTime = "N/A";//declaring a String variable and giving it a temporary value 
                 
                 //start wile loop 
                 while(true) {
                 	
                 	//start if statement 
                 	if (toInt.equalsIgnoreCase("true")) {
                 		
                 		//assign the value of the global variable to fullTime variable 
                 		fullTime = toInt;
                 		//break the loop 
                 		break;
                 		
                 	}//end if 
                     
                 	//start second if statement 
                     else if (toInt.equalsIgnoreCase("false")) {
                     	
                     	//assign the value of the global variable to fullTime variable 
                     	fullTime = toInt;
                     	//break the loop 
                     	break;
                     	
                     }//end else if 
                 	
                 	//start else 
                     else {
                     	
                     	//print the following for the user 
                     	System.out.println("Please enter either ((true)) or ((false))");
                         //assigning global variable to the user input 
                     	toInt = input.next();
                     	
                     	//start a while loopn 
                     	while(true) {
                     		
                     		//start if statement 
                     		if (toInt.equalsIgnoreCase("true") || toInt.equalsIgnoreCase("false")) {
                     	
                     			//break the loop 
                     			break;
                     			
                     		}//end if 
                     		
                     		//start esle 
                     		else {
                     			
                     			//print the following for the user 
                     			System.out.println("You are entering wrong data.");
                     			//assigning the users input to the golbal variable 
                     			toInt = input.next();
                     			
                     		}//end else 
                     	}//end while loop
                     }//end else
                 }//end while loop 
                 
                 //declare a boolean variable and set it to false 
                 boolean idExists = false;

                 //start for loop 
                 for (Student student : students) {

                 	//start if statement 
                     if (student.getId() == id) {

                     	//changing the value of the boolean variable 
                         idExists = true;
                         //break the loop 
                         break;

                     }//end if statement 
                 }//end the for loop 

                 //start if statement 
                 if (!idExists) {

                 	//create object 
                     FulltimeStudent newStudent = new FulltimeStudent(name, id, fullTime);
                     //adding the parameters through the constructor 
                     students.add(newStudent);
                     //printing
                     System.out.println("Student added successfully.");
                     
                 }//end if 
                 
                 //start esle 
                 else {

                 	//print
                     System.out.println("Error: student with ID " + id + " already exists.");

                 }//end else 
             }//end else if 

             //start fifth if statement 
             else if (choice.equalsIgnoreCase("5")) {

             	//start while loop 
             	while(true) {
             		
	                    // Add a new mature student
	                	System.out.print("Enter student age: ");
	                	toInt = input.next();//assigning the user's input to the global variable 
	                	inputValidation();//calling the method 
	                	int tostringAge = Integer.parseInt(toInt);//parsing the user's input 
	                	int age = tostringAge;//assigning the parsed variable to an int declared variable 
	                	
	                	//start while loop 
	                	while(true) {
	                		
	                		//start if statement 
	                		if (23 <= age && age <= 99) {
	                			
	                			input.nextLine();//use input 
	                			System.out.print("Enter student name: ");
	                            toInt = input.nextLine();//assigning the user's input to the global variable 
	                            inputValidationString();//calling the method 
	                            String name = toInt;//assigning global variable to the user input 
	                            System.out.print("Enter student id: ");
	                            toInt = input.nextLine();//assigning the user's input to the global variable 
	                            inputValidationFotTheID();//calling the method 
	                            int toString = Integer.parseInt(toInt);//parse int to String 
	                            int id = toString;//assigning the parsed variable to an int declared variable 
	                            
	                            //declare a boolean variable 
	                            boolean idExists = false;
	
	                            //start for loop
	                            for (Student student : students) {
	
	                            	//start if statement 
	                                if (student.getId() == id) {
	
	                                	//changing the value of the boolean variable 
	                                    idExists = true;
	                                    //stop the loop here 
	                                    break;
	
	                                }//end if 
	                            }//end for 
	
	                            //start if statement 
	                            if (!idExists) {
	
	                            	//create object 
	                                MatureStudent newStudent = new MatureStudent(name, id, age);
	                                //adding the parameters through the constructor 
	                                students.add(newStudent);
	                                //print
	                                System.out.println("Student added successfully.");
	                                //stop the loop here 
	                                break;
	
	                            }//end if statement 
	                            
	                            //start else 
	                            else {
	
	                                System.out.println("Error: student with ID " + id + " already exists.");
	
	                            }//end else 
	                            
	                		}//end if 
	                		
	                		//start else 
	                		else {
	                			
	                			//print
	                			System.out.println("Make sure only two digits and should be 23 years or above.");
	                			//stop the loop here 
		                		break;
		                		
	                		}//end else 
	                	}//end while loop here 
	                	
	                	//stop the loop here 
	                	break;

             	}//end the while loop here 
             }//end else if here 

             //start else if 
             else if (choice.equalsIgnoreCase("6")) {

                 // Remove an existing contact
                 System.out.print("Enter student id: ");
                 int id = input.nextInt();//taking user input and assign it to an int variable 
                 input.nextLine();//input 
                 //boolean variable assigned to false 
                 boolean found = false;

                 //start for loop
                 for (Student student : students) {

                 	//start if statement 
                     if (student.getId() == id) {

                     	//removing from the arraylist 
                         students.remove(student);
                         //change the value of the variable to true 
                         found = true;
                         //stop the loop 
                         break;

                     }//end if 
                 }//end for loop

                 //start if 
                 if (!found) {

                 	//print
                     System.out.println("Student not found.");

                 }//end if 
                 
                 //start else 
                 else {

                     System.out.println("Student removed successfully.");

                 }//end else 
             }//end else if  
             
             //start else if 
             else if (choice.equalsIgnoreCase("7")) {

                 // Sort all students alphabetically
                 /**
                  * students.sort((student1, student2) -> 
                  * student1.getName().compareTo(student2.getName()));
                  */

                  //Lambda expression to compare 
             	 students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

             	 //start for loop 
             	 for (Student student : students) {

             		    System.out.println(student.getName());

         		}//end for loop 
             }//end else if 

             //start else if 
             else if (choice.equalsIgnoreCase("8")) {
             	
             	//calling a method 
             	printStudentsTableToFile(students, "C:\\Users\\escan\\Desktop\\gonote.txt");

             }//end else if 
             
             //start else 
             else {

                 System.out.println("Invalid choice. Please select a valid option.");

             }//end else 
         }//end while loop 
     }//end main method 
 }//end class 