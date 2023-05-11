import java.util.LinkedList;

public class Teacher {
    private String name;
    private double salary; // should be something like 70_000.00
    private LinkedList<Student> students = new LinkedList<>();


    public Teacher(String name, double salary, LinkedList<Student> students){
        this.name = name;
        this.salary = salary;
        this.students = students;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public String toString(){
        return name;
    }

}
