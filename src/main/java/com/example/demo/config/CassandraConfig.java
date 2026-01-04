package com.example.demo.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;

import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.session.DefaultSessionFactory;

import java.net.InetSocketAddress;

@Configuration
public class CassandraConfig {

    @Value("${spring.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.keyspace-name}")
    private String keyspace;

    @Value("${spring.cassandra.local-datacenter}")
    private String datacenter;
    @Bean
    public CqlSession session() {
        return CqlSession.builder()
                .addContactPoint(new InetSocketAddress(contactPoints, port))
                .withLocalDatacenter(datacenter)
                .withKeyspace(keyspace)  // your keyspace
                .build();
    }
    @Bean
    public CassandraTemplate cassandraTemplate(@Autowired  CqlSession session){
        return new CassandraTemplate(session) ;
    }
}
