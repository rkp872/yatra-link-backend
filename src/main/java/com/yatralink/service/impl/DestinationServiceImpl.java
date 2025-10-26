package com.yatralink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatralink.model.Destination;
import com.yatralink.repository.DestinationRepository;
import com.yatralink.service.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Destination addDestination(Destination destination) {
       return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDestination(Long id) {
      destinationRepository.deleteById(id);
    }

}
