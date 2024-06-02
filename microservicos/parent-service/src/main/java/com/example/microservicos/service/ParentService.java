package com.example.microservicos.service;

import com.example.microservicos.model.Parent;
import com.example.microservicos.repository.ParentRepository;
import com.example.microservicos.dto.ParentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    private final ModelMapper mapper;

    @Autowired
    public ParentService(ParentRepository parentRepository, ModelMapper mapper) {
        this.parentRepository = parentRepository;
        this.mapper = mapper;
    }

    public Parent findParentById(Long parentId) {
        return parentRepository.findById(parentId).orElse(null);
    }

    public List<ParentDTO> getAllParents() {
        return parentRepository.
                findAll().
                stream().
                map(this::mapToParentDTO).
                toList();
    }

    private ParentDTO mapToParentDTO(Parent parent) {
        return mapper.map(parent, ParentDTO.class);
    }

    public Optional<ParentDTO> getParentById(Long parentId) {
        return parentRepository.
                findById(parentId).
                map(this::mapToParentDTO);
    }

    public long addParent(ParentDTO parentDTO) {
        Long townId = parentDTO.getTown().getId();

        Parent parent = mapper.map(parentDTO, Parent.class);
        parent.setTownId(townId);

        parentRepository.save(parent);

        return parent.getId();

    }

    public void deleteParentById(Long parentId) {
        parentRepository.deleteById(parentId);
    }

}
