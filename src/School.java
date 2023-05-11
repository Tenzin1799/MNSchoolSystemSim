import java.util.LinkedList;

public class School {
    private String name;
    private double moneyInSchool;
    private LinkedList<Teacher> teachers = new LinkedList<>();
    private LinkedList<Student> students = new LinkedList<>();
    private double expenses;

    public School(String name, LinkedList<Teacher> teachers, LinkedList<Student> students, double moneyInSchool){
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.moneyInSchool = moneyInSchool;
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

    public String toString(){
        return name;
    }

    public LinkedList<Teacher> getTeachers(){
        return teachers;
    }
}
