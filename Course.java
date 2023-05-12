public class Course {
    private String name;
    private String code;
    private double grade;

    public Course(String name, String code, double grade) {
        this.name = name;
        this.code = code;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getGrade() {
        return grade;
    }
}
