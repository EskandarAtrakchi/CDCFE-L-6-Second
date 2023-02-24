package sac;

class FulltimeStudent extends Student {
    private String fullTime;

    public FulltimeStudent(String name, int id, String fullTime) {
        super(name, id);
        this.fullTime = fullTime;
    }

    public String isFullTime() {
        return fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }
}