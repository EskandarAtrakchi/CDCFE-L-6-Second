package sac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class CollegeApp {
	
	static String toInt;
	static int toString;
	static Scanner input = new Scanner(System.in);
	
	public static void inputValidation() {//start method 

		while ( ! toInt.matches("\\d+") ) {//start while loop 
			System.out.println("Not Allowed, numbers only!");
			
			toInt = input.next();//take user input as a String 
		}//end while loop 
	}//end method 
	
	public static void printStudentsTableToFile(ArrayList<Student> students, String fileName) {
		
	    Path path = Paths.get("C:\\Users\\escan\\Desktop\\gonote.txt"); // create Path object for the output file
	    String table = "+------------+-----+--------+\n"
	                 + "|    Name    | ID  |  Class |\n"
	                 + "+------------+-----+--------+\n";
	    
	    for (Student student : students) {
	    	
	        table += String.format("| %-10s | %3d | %-6s |\n",
	                               student.getName(), student.getId(), student.getClass());
	        
	    }
	    
	    table += "+------------+-----+--------+\n";
	    
	    try {
	    	
	        Files.write(path, table.getBytes()); // write the table to the output file
	        System.out.println("Successfully printed the student table to gonote");
	        
	    } 
	    
	    catch (IOException e) {
	    	
	        System.err.println("Error writing to file " + fileName);
	        e.printStackTrace();
	        
	    }
	}


    public static void main(String[] args) {

        ArrayList < Student > students = new ArrayList < Student > ( );
        

        while (true) {

            System.out.println("Select an option:");
            System.out.println("1. Quit");
            System.out.println("2. Show all full time students");
            System.out.println("3. Show all mature students");
            System.out.println("4. Add a new full time student");
            System.out.println("5. Add a new mature student");
            System.out.println("6. Remove an existing contact");
            System.out.println("7. Sort all students alphabetically");
            System.out.println("8. Print out student list to a text file");

            String choice = input.next();

                if (choice.equalsIgnoreCase("1")) {

                    // Quit
                	System.out.println("Good-Bye");
                	input.close();
                    System.exit(0);

                } else if (choice.equalsIgnoreCase("2")) {

                    // Show all full time students
                	System.out.println("\t\tShow all full time students\n");
                	System.out.println("Name\t\tID");

                    for (Student student : students) {

                        if (student instanceof FulltimeStudent) {
                        	
                            System.out.println(student.getName() +"\t\t"+ student.getId()+"\n");
                        }
                    }

                } 
                
                else if (choice.equalsIgnoreCase("3")) {
                	
                	System.out.println("\t\tShow all mature students\n");
                	
                	System.out.println("Name\t\tID");

                    // Show all mature students

                    for (Student student : students) {

                        if (student instanceof MatureStudent) {
                        	
                            System.out.println(student.getName() + "\t\t" + student.getId());
                        }
                    }
                } 

                else if (choice.equalsIgnoreCase("4")) {

                	// Add a new full time student
                    System.out.print("Enter student name: ");
                    String name = input.next();
                    System.out.print("Enter student id: ");
                    toInt = input.next();
                    inputValidation();
                    int tostring = Integer.parseInt(toInt);
                    int id = tostring;
                    System.out.print("Is the student full-time? (true/false): ");
                    String fullTime = input.next();

                    boolean idExists = false;

                    for (Student student : students) {

                        if (student.getId() == id) {

                            idExists = true;
                            break;

                        }
                    }

                    if (!idExists) {

                        FulltimeStudent newStudent = new FulltimeStudent(name, id, fullTime);
                        students.add(newStudent);
                        System.out.println("Student added successfully.");
                    } 
                    
                    else {

                        System.out.println("Error: student with ID " + id + " already exists.");

                    }
                } 

                else if (choice.equalsIgnoreCase("5")) {

                    // Add a new mature student
                	System.out.print("Enter student age: ");
                	int age = input.nextInt();
                	while(true) {
                		if (age >= 23) {
                			input.nextLine();
                			
                			System.out.print("Enter student name: ");
                            String name = input.nextLine();
                            System.out.print("Enter student id: ");
                            toInt = input.nextLine();
                            inputValidation();
                            int toString = Integer.parseInt(toInt);//parse int to String 
                            int id = toString;
                            
                            boolean idExists = false;

                            for (Student student : students) {

                                if (student.getId() == id) {

                                    idExists = true;
                                    break;

                                }
                            }

                            if (!idExists) {

                                MatureStudent newStudent = new MatureStudent(name, id, age);
                                students.add(newStudent);
                                System.out.println("Student added successfully.");

                            } 
                            
                            else {

                                System.out.println("Error: student with ID " + id + " already exists.");

                            }
                            break;
                		}
                		else {
                			System.out.println("Too young! couldn't be added!");
                			break;
                		}
                	}
                    
                }

                else if (choice.equalsIgnoreCase("6")) {

                    // Remove an existing contact
                    System.out.print("Enter student id: ");
                    int id = input.nextInt();
                    input.nextLine();
                    boolean found = false;

                    for (Student student : students) {

                        if (student.getId() == id) {

                            students.remove(student);
                            found = true;
                            break;

                        }
                    }

                    if (!found) {

                        System.out.println("Student not found.");

                    } 
                    
                    else {

                        System.out.println("Student removed successfully.");

                    }
                } 
                
                else if (choice.equalsIgnoreCase("7")) {

                    // Sort all students alphabetically
                    /**
                     * students.sort((student1, student2) -> 
                     * student1.getName().compareTo(student2.getName()));
                     */

                     //Lambda expression to compare 
                     
                	 students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

                	 for (Student student : students) {

                		    System.out.println(student.getName());

                		}
                	 
                } 

                else if (choice.equalsIgnoreCase("8")) {

                	printStudentsTableToFile(students, "C:\\Users\\escan\\Desktop\\gonote.txt");

                }
                
                else {

                    System.out.println("Invalid choice. Please select a valid option.");

                }
            }
        }
    }