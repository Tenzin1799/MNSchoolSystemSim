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
        String res;
        do {
            System.out.println("____________ MAIN MENU ____________");
            System.out.println("SCHOOLS:");
            for (School school : schoolsList){
                System.out.println(school.getName());
            }
            System.out.println("____________");
            System.out.println("Enter \"-1\" to exit program.");
            System.out.println("Enter \"1\" to choose a specific school.");
            System.out.println("Enter \"2\" to create a new school.");
            res = input.nextLine();
            switch (res) {
                case "-1" -> {
                    System.out.println("...");
                    System.out.println("Goodbye.");
                }
                case "1" -> {
                    System.out.println("...\n\n");
                    chooseSchool();
                }
                case "3" -> System.out.println("...\n\n");

                // createSchool();
                default -> {
                    System.out.println("...\n\n");
                    System.out.println("Input not allowed. Try again.\n\n");
                }
            }
        } while (!res.equals("-1"));
    }



    private void chooseSchool(){
        String res;
        do {
            System.out.println("____________ CHOOSE SCHOOL ____________");
            System.out.println("Enter \"-1\" to go back to main menu.");
            for (School school : schoolsList) {
                int j = 1;
                System.out.println("Enter \"" + j + "\" to enter " + school.getName() +
                        "'s database.\n____________");
                j++;
            }
            res = input.nextLine();
            try{
                int resNum = Integer.parseInt(res);
                if (resNum <= schoolsList.size() && resNum > 0){
                    System.out.println("...\n\n");
                    schoolChosen(resNum);
                } else if (resNum == -1){
                    System.out.println("...\n\n");
                } else {
                    System.out.println("...\n\n");
                    System.out.println("Try again.");
                }
            } catch (Exception exception){
                System.out.println("...\n\n");
                System.out.println("Try again.");
            }
        } while (!res.equals("-1"));
    }

    private void schoolChosen(int school){
        String res;
        int schoolIndex = school-1;
        do {
            System.out.println("____________ " + schoolsList.get(schoolIndex).getName() + "____________");
            System.out.println("Enter \"-1\" to go back to the \"Choose School\" menu.");
            System.out.println("Enter \"1\" to get list of teachers at this school.");
            System.out.println("Enter \"2\" to edit a teacher's salary.");
            System.out.println("Enter \"3\" to view the school's upcoming expenses.");
            System.out.println("Enter \"4\" to get a list of all students at this school.");
            System.out.println("Enter \"5\" to view student tuition fee.");
            System.out.println("Enter \"6\" to view the school's revenue.");
            res = input.nextLine();
            switch (res) {
                case "-1" -> System.out.println("...\n\n");
                case "1" -> {
                    System.out.println("...\n\n");
                    System.out.println("Teacher's names:");
                    System.out.println(schools.get(schoolsList.get(schoolIndex)) + "\n\n");
                }
                case "2" -> {
                    System.out.println("...\n\n");
                    chooseTeacher(schoolIndex);
                }
                case "3" -> System.out.printf("$%,.2f\n\n\n", schoolsList.get(schoolIndex).getExpenses());
                case "4" -> {
                    System.out.println("...\n\n");
                    System.out.println("Student's names:");
                    System.out.println(schoolsList.get(schoolIndex).getStudents() + "\n\n");
                }
                case "5" -> {
                    System.out.println("...\n\n");
                    System.out.printf("$%,.2f\n\n\n", studentsList.get(0).getTuition());
                }
                // Nothing on the assignment
                // said I needed to implement a way to add new students or edit their tuition.
                case "6" -> {
                    System.out.println("...\n\n");
                    System.out.printf("$%,.2f\n\n\n", schoolsList.get(schoolIndex).getRevenue());
                }
                default -> {
                    System.out.println("...\n\n");
                    System.out.println("Try again.");
                }
            }
        } while (!res.equals("-1"));
    }

    private void chooseTeacher(int school){
        String res;
        do {
            System.out.println("____________ Choose Teacher ____________");
            System.out.println("Enter \"-1\" to return to School menu.");
            int j = 1;
            for (Teacher teacher : teacherList) {
                System.out.println("Enter " + j + " to choose " +
                        teacher.getName() + ".");
                j++;
            }
            res = input.nextLine();
            try{
                int resNum = Integer.parseInt(res);
                if (resNum <= teacherList.size() && resNum > 0){
                    System.out.println("...\n\n");
                    teacherChosen(resNum, school);
                } else if (resNum == -1){
                    System.out.println("...\n\n");
                } else {
                    System.out.println("...\n\n");
                    System.out.println("Try again.");
                }
            } catch (Exception exception){
                System.out.println("...\n\n");
                System.out.println("Try again.");
            }
        } while (!res.equals("-1"));
    }

    private void teacherChosen(int teacher, int school){
        String res;
        int teacherIndex = teacher-1;
        do {
            System.out.println("____________ " + teacherList.get(teacherIndex) + "____________");
            System.out.println("Enter \"-1\" to return to \"Choose Teacher\" menu.");
            System.out.println("Enter \"1\" to view " + teacherList.get(teacherIndex) + "'s salary.");
            System.out.println("Enter \"2\" to edit " + teacherList.get(teacherIndex) + "'s salary.");
            res = input.nextLine();
            switch (res) {
                case "-1" -> System.out.println("...\n\n");
                case "1" -> {
                    System.out.println("...\n\n");
                    System.out.println(teacherList.get(teacherIndex) + "'s salary:");
                    System.out.printf("$%,.2f \n\n\n", teacherList.get(teacherIndex).getSalary());
                }
                case "2" -> {
                    System.out.println("...\n\n");
                    editSalary(teacherIndex, school);
                }
                default -> {
                    System.out.println("\n\n");
                    System.out.println("Try again.");
                }
            }
        } while(!res.equals("-1"));
    }

    private void editSalary(int teacher, int school){
        String newSalary;
        do {
            System.out.println("Enter \"-1\" to return to Teacher menu.");
            System.out.println("Please enter a new salary for " + teacherList.get(teacher) +":");
            newSalary = input.nextLine();
            try {
                if (newSalary.equals("-1")){
                    System.out.println("...\n\n");
                } else {
                    double salaryNum = Double.parseDouble(newSalary.replace(",", ""));
                    schoolsList.get(school).setExpenses(
                            schoolsList.get(school).getExpenses() - teacherList.get(teacher).getSalary()
                    ); // this subtracts expenses from previous salary
                    teacherList.get(teacher).setSalary(salaryNum);
                    schoolsList.get(school).setExpenses(
                            schoolsList.get(school).getExpenses() + teacherList.get(teacher).getSalary()
                    ); // this adds expenses from new salary
                    System.out.println("Salary has been edited.\n\n");
                }
            } catch (Exception e){
                System.out.println("Sorry, couldn't process that.\n\n");
            }
        } while(!newSalary.equals("-1"));


    }


    /// Methods below set initial students, school, and teachers so user has something to work off of.
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
        // Initial teachers to begin with
        // All teachers are in charge of every student. Meaning if you are enrolled in a school, you are in every
        // teacher's class.
        Teacher t1 = new Teacher("All-Might", 90_000.00, studentsList);
        Teacher t2 = new Teacher("Son Goku", 90_000.00, studentsList);
        Teacher t3 = new Teacher("Ichigo Kurosaki", 80_000.00, studentsList);
        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);

    }

    private void setInitialSchools(){
        // Initial schools to begin with
        School NHCC = new School("North Hennepin Community College", teacherList, studentsList, 0.00);
        schoolsList.add(NHCC);
        schools.put(NHCC, teacherList);
        double expenses = 0;
        for (int i = 0; i < teacherList.size(); i++){
            expenses += schoolsList.get(0).getTeachers().get(i).getSalary();
        }
        schoolsList.get(0).setExpenses(expenses);
        double revenue = 0;
        for (int i = 0; i < studentsList.size(); i++){
            revenue += schoolsList.get(0).getStudents().get(i).tuition;
        }
        schoolsList.get(0).setRevenue(revenue);
    }

    /*
     Was unable to finish in time, but this is what I got done.
     */
}
