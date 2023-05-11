import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Control {
    private LinkedList<Student> studentsList = new LinkedList<>();
    private LinkedList<Teacher> teacherList = new LinkedList<>();
    private LinkedList<School> schoolsList = new LinkedList<>();
    private HashMap schools = new HashMap();
    private Scanner input = new Scanner(System.in);

    public void runProgram(){
        setInitialStudents();
        setInitialTeachers();
        setInitialSchools();
        System.out.println("Hello. Enter 1 to get NHCC School stuff. Enter anything else to exit.");
        int res = input.nextInt();
        if (res == 1){
            System.out.println(schools.get(schoolsList.get(0)));
        } else {
            System.out.println("Goodbye.");
        }
    }

    private void setInitialStudents(){
        // Initial students to begin with
        Student s1 = new Student("Groot");
        Student s2 = new Student("Gamora");
        Student s3 = new Student("Star-Lord");
        Student s4 = new Student("Drax The Destroyer");
        Student s5 = new Student("Rocket Racoon");
        Student s6 = new Student("Nebula");
        Student s7 = new Student("Spider-Man");
        Student s8 = new Student("Captain America");
        Student s9 = new Student("Iron Man");
        Student s10 = new Student("John Cena"); // the greatest superhero xd
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);
        studentsList.add(s5);
        studentsList.add(s6);
        studentsList.add(s7);
        studentsList.add(s8);
        studentsList.add(s9);
        studentsList.add(s10);
    }

    private void setInitialTeachers(){
        Teacher t1 = new Teacher("All-Might", 90_000.00, studentsList);
        Teacher t2 = new Teacher("Son Goku", 90_000.00, studentsList);
        Teacher t3 = new Teacher("Ichigo Kurosaki", 80_000.00, studentsList);
        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);

    }

    private void setInitialSchools(){
        School NHCC = new School("North Hennepin Community College", teacherList, studentsList, 0.00);
        schoolsList.add(NHCC);
        schools.put(NHCC, teacherList);
    }

}
