package com.api.parkingcontrol.service;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repository.IParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
