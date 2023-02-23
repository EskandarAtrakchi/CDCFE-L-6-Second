public class Application {
    private String courseName;
    private int id;

    public Application(String courseName, int id) {
        this.courseName = courseName;
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Application{" +
                "courseName='" + courseName + '\'' +
                ", id=" + id +
                '}';
    }
}
