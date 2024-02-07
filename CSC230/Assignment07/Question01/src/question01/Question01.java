package question01;

/**
 * a user can access main() from the Question01 class
 * @author willhutcheon
 */
public class Question01 {

    /**
     * a user can create and initialize objects within the main() function
     */
    public static void main(String[] args) {
        // creating and initializing some objects from the classes within the package
        Person Will = new Person("Will", 24);
        System.out.println(Will.toString());
        System.out.println("The persons name: " + Will.getName());
        System.out.println("The persons age: " + Will.getAge());
        System.out.println();
        Student student = new Student("Will", 25, "880806324", 3.62);
        System.out.println(student.toString());
        System.out.println("The students name: " + student.getName());
        System.out.println("The students age: " + student.getAge());
        System.out.println("The students ID: " + student.getId());
        System.out.println("The students GPA: " + student.getGpa());
        System.out.println();
        Teacher teacher = new Teacher("CA", 30, "Computer Science", 130000.00);
        System.out.println(teacher.toString());
        System.out.println("The teachers name: " + teacher.getName());
        System.out.println("The teachers age: " + teacher.getAge());
        System.out.println("The teachers subject: " + teacher.getSubject());
        System.out.println("The teachers salary: " + teacher.getSalary());
        System.out.println();        
        CollegeStudent collegeStudent = new CollegeStudent("Will", 24, "880806455", 4.0, "Computer Science", 2);
        System.out.println(collegeStudent.toString());
        System.out.println("The college students name: " + collegeStudent.getName());
        System.out.println("The college students age: " + collegeStudent.getAge());
        System.out.println("The college students ID: " + collegeStudent.getId());
        System.out.println("The college students GPA: " + collegeStudent.getGpa());
        System.out.println("The college students major: " + collegeStudent.getMajor());
        System.out.println("The college students year: " + collegeStudent.getYear());
        System.out.println();
    }
    
}
