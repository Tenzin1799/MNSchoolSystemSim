public class Student {
    String name;
    double money = 500_000.00; // rich students ik;
    double tuition = 15_000.00;

    public Student(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTuition(Double tuition){
        this.tuition = tuition;
    }

    public double getTuition(){
        return tuition;
    }

    public String toString(){
        return name;
    }

}
