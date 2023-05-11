import java.util.LinkedList;

public class School {
    private String name;
    private double revenue;
    private LinkedList<Teacher> teachers = new LinkedList<>();
    private LinkedList<Student> students = new LinkedList<>();
    private double expenses;

    public School(String name, LinkedList<Teacher> teachers, LinkedList<Student> students, double revenue){
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.revenue = revenue;
    }

    public void setName(){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExpenses(double money){
        expenses = money;
    }

    public double getExpenses(){
        return expenses;
    }

    public void setRevenue(double money){
        revenue = money;
    }

    public double getRevenue(){
        return revenue;
    }

    public String toString(){
        return name;
    }

    public LinkedList<Teacher> getTeachers(){
        return teachers;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
}
