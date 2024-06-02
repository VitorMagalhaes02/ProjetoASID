package com.iStudent.microservicos.studentmark.service;

import com.iStudent.microservicos.studentmark.dto.StudentDTO;
import com.iStudent.microservicos.studentmark.model.Student;
import com.iStudent.microservicos.studentmark.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper mapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::mapToStudentDTO)
                .toList();
    }

    public Optional<StudentDTO> getStudentById(Long studentId) {
        return studentRepository
                .findById(studentId)
                .map(this::mapToStudentDTO);
    }

    public long addStudent(StudentDTO studentDTO) {
        // ID da cidade do DTO do estudante
        Long townId = studentDTO.getTown().getId();
        Long club_id = studentDTO.getClub_id();
        Long parentToMap = studentDTO.getParent();

        Student student = mapper.map(studentDTO, Student.class);

        student.setTownId(townId);
        student.setParent_id(parentToMap);
        student.setClub_id(club_id);

        studentRepository.save(student);

        return student.getId();
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    private StudentDTO mapToStudentDTO(Student student) {
        return mapper.map(student, StudentDTO.class);
    }
}
