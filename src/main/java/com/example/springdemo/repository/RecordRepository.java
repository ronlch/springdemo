package com.example.springdemo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.model.Record;

public interface RecordRepository extends CrudRepository<Record, Integer> {

    // Ref: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    
    List<Record> findByName(String name);
    List<Record> findByCreator(String creator);
    List<Record> findByNameAndCreator(String name, String creator);
}
