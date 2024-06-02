package com.iStudent.microservicos.town.service;

import com.iStudent.microservicos.town.dto.TownDTO;
import com.iStudent.microservicos.town.model.Town;
import com.iStudent.microservicos.town.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

@Service
public class TownService {

    private final TownRepository townRepository;
        private final ModelMapper mapper;

    @Autowired
    public TownService(TownRepository townRepository, ModelMapper mapper) {
        this.townRepository = townRepository;
        this.mapper = mapper;
    }

    public Town findByTownId(Long townId){
        return this.townRepository.findById(townId).orElseThrow();
    }

    public long addTown(TownDTO townDTO) {
        Town town = mapper.map(townDTO, Town.class);

        townRepository.save(town);

        return town.getId();
    }

    public Town findByTownName(String townName){
        return this.townRepository.findByName(townName).orElseThrow();
    }

        public List<TownDTO> getAllTowns() {
        return townRepository.
                findAll().
                stream().
                map(this::mapToTownDTO).
                toList();
    }

    private TownDTO mapToTownDTO(Town town) {
        return mapper.map(town, TownDTO.class);
    }

    public Optional<TownDTO> getTownById(Long town) {
        return townRepository.
                findById(town).
                map(this::mapToTownDTO);
    }


}