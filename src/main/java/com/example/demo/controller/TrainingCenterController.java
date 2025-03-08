package com.example.demo.controller;

import com.example.demo.dto.TrainingCenterRequest;
import com.example.demo.model.TrainingCenter;
import com.example.demo.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<TrainingCenter> create(@Valid @RequestBody TrainingCenterRequest request) {
        System.out.println("Received request: " + request);
        TrainingCenter saved = service.createTrainingCenter(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
     @PostMapping("/test")
    public ResponseEntity<String> test() {
    return ResponseEntity.ok("POST request is working!");
    }
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAll() {
        return ResponseEntity.ok(service.getAllTrainingCenters());
    }

}