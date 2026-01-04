package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("student")
public class Student {

    @PrimaryKey
    private int studentId;
    @Column("name")
    private String studentName;
    @Column("age")
    private int studentAge;
    @Column("email")
    private String studentEmail;

    @Column("account_balance")
    private BigDecimal accountBalance;

}


