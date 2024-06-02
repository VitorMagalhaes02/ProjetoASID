package com.example.microservicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.microservicos.dto.AggregationDTO;
import com.example.microservicos.service.AggregationService;

@RestController
@RequestMapping("/api/students")
public class AggregationController {
    private final AggregationService service;

    @Autowired
    public AggregationController(AggregationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AggregationDTO>> getAllStudentDetails() {
        List<AggregationDTO> aggregatedStudentDTOs = service.getAllStudentDetails();
        return ResponseEntity.ok(aggregatedStudentDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AggregationDTO> getStudentDetails(@PathVariable Long id) {
        AggregationDTO aggregatedStudentDTO = service.getStudentDetails(id);
        return ResponseEntity.ok(aggregatedStudentDTO);
    }
}
