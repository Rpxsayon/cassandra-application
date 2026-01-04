package com.example.demo.service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @Autowired
    private CqlSession cqlSession;


    public Optional<Student> insertStudentWithCQL(Student student) {
        String cql = "INSERT INTO student (student_id, name, age, email, account_balance) " +
                "VALUES (?, ?, ?, ?, ?)";

      return Optional.of(cassandraTemplate.getCqlOperations()
                .execute(cql,
                        student.getStudentId(),
                        student.getStudentName(),
                        student.getStudentAge(),
                        student.getStudentEmail(),
                        student.getAccountBalance()))
              .filter(Boolean::booleanValue)
              .map(value -> student)
              .or(() -> {
                  System.out.println("value not able to insert .....");
                  return Optional.empty() ;
              }) ;
    }

    public Optional<List<Student>> getAllStudents() {
        String cql = "SELECT * FROM student";
        return Optional.ofNullable(cassandraTemplate.select(cql, Student.class));
    }


}
