package com.example.springdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.Record;
import com.example.springdemo.repository.RecordRepository;

@RestController
public class _5_RecordController {
    private final RecordRepository recordRepository;

    public _5_RecordController(final RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    // Test URL: http://localhost:8080/record
    @GetMapping("/record")
    public Iterable<Record> getAllRecords() {
        return this.recordRepository.findAll();
    }

    // Test URL: http://localhost:8080/record/1
    @GetMapping("/record/{id}")
    public Optional<Record> getRecordById(@PathVariable("id") Integer id) {
        return this.recordRepository.findById(id);
    }

    // Test CURL command
    // curl -X POST localhost:8080/record -H "Content-Type: application/json" -d "{\"name\":\"Test Doc 1\",\"creator\":\"Ron Lee\"}"
    // curl -X POST localhost:8080/record -H "Content-Type: application/json" -d "{\"name\":\"TestDoc2\"}"
    // curl -X POST localhost:8080/record -H "Content-Type: application/json" -d "{\"name\":\"Test Doc 3\"}"
    // Missing field will become NULL
    @PostMapping("/record")
    public Record createNewRecord(@RequestBody Record record) {
        Record newRecord = this.recordRepository.save(record);
        return newRecord;
    }

    // Test CURL Command
    // curl -X PUT localhost:8080/record/3 -H "Content-Type: application/json" -d "{\"creator\": \"Ron Ron\""}"
    @PutMapping("/record/{id}")
    public Record updateRecord(@PathVariable("id") Integer id, @RequestBody Record r) {
        Optional<Record> recordToUpdateOptional = this.recordRepository.findById(id);
        if (!recordToUpdateOptional.isPresent()) {
            return null;
        }

        // Optional
        Record recordToUpdate = recordToUpdateOptional.get();

        if (r.getName() != null) {
            recordToUpdate.setName(r.getName());
        }

        if (r.getCreator() != null) {
            recordToUpdate.setCreator(r.getCreator());
        }

        Record updatedRecord = this.recordRepository.save(recordToUpdate);
        return updatedRecord;
    }

    // Test CURL Command
    // curl -X DELETE localhost:8080/record/3
    @DeleteMapping("/record/{id}")
    public Record deletePlant(@PathVariable("id") Integer id) {
        Optional<Record> recordToDeleteOptional = this.recordRepository.findById(id);
        if (!recordToDeleteOptional.isPresent()) {
            return null;
        }
        Record recordToDelete = recordToDeleteOptional.get();
        this.recordRepository.delete(recordToDelete);
        return recordToDelete;
    }

    // Test URL: http://localhost:8080/record/search/?name=Test%20Doc%201
    // Test URL: http://localhost:8080/record/search/?name=TestDoc2
    // Test URL: http://localhost:8080/record/search/?creator=Ron%20Lee
    // Test URL: http://localhost:8080/record/search/?name=Test%20Doc%201&creator=Ron%20Lee

    @GetMapping("/record/search")
    public List<Record> searchRecord(
            @RequestParam(name = "name", required = false) String name, 
            @RequestParam(name = "creator", required = false) String creator) {
        if (name != null && creator != null) {
            return this.recordRepository.findByNameAndCreator(name, creator);
        } else if (name != null) {
            return this.recordRepository.findByName(name);
        } else if (creator != null) {
            return this.recordRepository.findByCreator(creator);
        } else {
            return new ArrayList<>();
        }
    }

}
