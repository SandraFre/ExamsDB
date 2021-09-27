package lt.codeacademy.service;

import lt.codeacademy.entity.Student;
import lt.codeacademy.repository.StudentRepository;

import java.util.Scanner;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(){
        studentRepository = new StudentRepository();
    }

    public void createStudent(Scanner sc){
        System.out.println("----Student info----");
        System.out.println("Enter student name:");
        String name = sc.nextLine();
        System.out.println("Enter student surname:");
        String surname = sc.nextLine();

        Student student = new Student(name, surname);

        studentRepository.createNewStudent(student);

        if (student.getId()!=null) {
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " created successfully");
            System.out.println("Student id: " + student.getId());
        } else {
            System.out.println("Student was not created");
        }
    }

    public void getStudents(){
        studentRepository.getStudents().forEach(System.out::println);
    }

    public Student getStudentById(Scanner sc){
        System.out.println("Enter student id:");
        Long id = sc.nextLong();
        Student student = studentRepository.getStudent(id);
        if (student==null){
            System.out.println("Student does not exist");
            return null;
        }
        return student;
    }

    public void updateStudentInfoById(Scanner sc){
        System.out.println("Enter id of student you want to update:");
        Long id = sc.nextLong();
        Student student = studentRepository.getStudent(id);
        if (student==null){
            System.out.println("Student does not exist");
            return;
        }
        System.out.println("----Updated info----");
        System.out.println("Student name:");
        String name = sc.next();
        System.out.println("Student surname:");
        String surname = sc.next();

        student.setFirstName(name);
        student.setLastName(surname);

        studentRepository.updateStudent(student);
    }

    public void delete(){
//        studentRepository.deleteStudentById();
    }
}
