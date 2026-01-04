//package com.example.demo.run;
//
//
//import com.example.demo.entity.Student;
//import com.example.demo.service.StudentService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//@Component
//public class AppRunner implements CommandLineRunner {
//
//    private final StudentService studentService;
//
//    public AppRunner(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Student student = new Student() ;
//        student.setStudentId(1);
//        student.setStudentName("Sayon Biswas");
//        student.setStudentAge(28);
//        student.setStudentEmail("sayon@example.com");
//        student.setAccountBalance(BigDecimal.valueOf(100000.00));
//        studentService.insertStudentWithCQL(student);
//
//        System.out.println("AppRunner finished execution.");
//    }
//}
//
