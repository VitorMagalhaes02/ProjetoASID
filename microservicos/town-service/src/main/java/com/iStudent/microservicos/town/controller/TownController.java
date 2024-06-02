package com.iStudent.microservicos.town.controller;

import com.iStudent.microservicos.town.dto.TownDTO;
import com.iStudent.microservicos.town.service.TownService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/towns")
public class TownController {

    private final TownService townService;

    @Autowired
    public TownController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping
    public ResponseEntity<List<TownDTO>> getAllTowns() {
        return ResponseEntity.
                ok(townService.getAllTowns());
    }

    @PostMapping
    public ResponseEntity<TownDTO> addClub(@Valid @RequestBody TownDTO townDTO,
                                           UriComponentsBuilder uriComponentsBuilder) {

        long newTownId = townService.addTown(townDTO);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/clubs/{id}")
                        .build(newTownId))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TownDTO> getTownById(@PathVariable("id") Long townId) {
        Optional<TownDTO> town = this.townService.getTownById(townId);

        if (town.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();

        } else {
            return ResponseEntity
                    .ok(town.get());

        }
    }

}
