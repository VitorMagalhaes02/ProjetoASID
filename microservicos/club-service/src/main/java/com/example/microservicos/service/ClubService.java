package com.example.microservicos.service;

import com.example.microservicos.dto.ClubDTO;
import com.example.microservicos.model.Club;
import com.example.microservicos.repository.ClubRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    private final ModelMapper mapper;

    @Autowired
    public ClubService(ClubRepository clubRepository, ModelMapper mapper) {
        this.clubRepository = clubRepository;
        this.mapper = mapper;
    }

    public List<ClubDTO> getAllClubs() {
        return clubRepository.
                findAll().
                stream().
                map(this::mapToClubDTO).
                toList();
    }

    private ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO = mapper.map(club, ClubDTO.class);
        clubDTO.setId(club.getId());
        return clubDTO;
    }

    public Optional<ClubDTO> getClubById(Long clubId) {
        return clubRepository.
                findById(clubId).
                map(this::mapToClubDTO);
    }

    @Transactional
    public void deleteClubById(Long clubId) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);
    
        clubRepository.deleteById(clubId);
    }

    public long addClub(ClubDTO clubDTO) {
        Club club = mapper.map(clubDTO, Club.class);

        clubRepository.save(club);

        return club.getId();
    }
    
    public ClubDTO changeClubName(Long id, ClubDTO clubDTO) {
        Optional<Club> optionalClub = clubRepository.findById(id);

        if (optionalClub.isPresent()) {
            Club club = optionalClub.get();
            club.setName(clubDTO.getName());

            clubRepository.save(club);
            return mapToClubDTO(club);
        }

        return null;
    }
}
