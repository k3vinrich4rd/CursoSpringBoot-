package com.api.parkingcontrol.service;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repository.IParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service //Estereótipo
public class ParkingSpotService {

    //Injeção de dependência
    final IParkingSpotRepository iParkingSpotRepository;

    public ParkingSpotService(IParkingSpotRepository iParkingSpotRepository) {
        this.iParkingSpotRepository = iParkingSpotRepository;
    }

    @Transactional //Garante o rollback em transações caso algo dê errado
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return iParkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return iParkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return iParkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }


    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return iParkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return iParkingSpotRepository.findAll(pageable);
    }


    public Optional<ParkingSpotModel> findById(UUID id) {
        return iParkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        iParkingSpotRepository.delete(parkingSpotModel);
    }
}

