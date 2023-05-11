public class Student {
    String name;
    double money = 500_000.00; // rich students ik;

    public Student(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
