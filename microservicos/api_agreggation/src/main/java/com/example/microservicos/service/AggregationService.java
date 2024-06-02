package com.example.microservicos.service;

import com.example.microservicos.dto.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AggregationService {
        private final RestTemplate restTemplate;
    
        @Autowired
        public AggregationService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public List<AggregationDTO> getAllStudentDetails() {
            StudentDTO[] students = restTemplate.getForObject("http://student-service/students", StudentDTO[].class);
    
            return Arrays.stream(students).map(student -> {
                ParentDTO parent = restTemplate.getForObject("http://parent-service/parents/" + student.getParent(), ParentDTO.class);
                TownDTO town = restTemplate.getForObject("http://town-service/towns/" + student.getTown().getId(), TownDTO.class);
                ClubDTO club = restTemplate.getForObject("http://club-service/clubs/" + student.getClub_id(), ClubDTO.class);
    
                return new AggregationDTO(student, parent, town, club);
            }).collect(Collectors.toList());
        }
    
        public AggregationDTO getStudentDetails(Long studentId) {
            StudentDTO student = restTemplate.getForObject("http://localhost:8082/students/" + studentId, StudentDTO.class);
            ParentDTO parent = restTemplate.getForObject("http://localhost:8083/parents/" + student.getParent(), ParentDTO.class);
            TownDTO town = restTemplate.getForObject("http://localhost:8081/towns/" + student.getTown().getId(), TownDTO.class);
            ClubDTO club = restTemplate.getForObject("http://localhost:8084/clubs/" + student.getClub_id(), ClubDTO.class);
    
            return new AggregationDTO(student, parent, town, club);
        }
    }
    


