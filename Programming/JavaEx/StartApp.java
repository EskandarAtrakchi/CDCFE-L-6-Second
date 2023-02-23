import java.util.ArrayList;

public class StartApp {
    public static void main(String[] args) {
        // create some applications
        Application application1 = new Application("Java Programming", 1001);
        Application application2 = new Application("Web Development", 1002);

        // create some students
        Student student1 = new Student("johndoe@example.com", "John Doe", 123, application1);
        Student student2 = new Student("janedoe@example.com", "Jane Doe", 456, application2);

        // create an ArrayList to hold the students
        ArrayList<Student> students = new ArrayList<Student>();

        // add the students to the ArrayList
        students.add(student1);
        students.add(student2);

        // print out the information of all the students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
