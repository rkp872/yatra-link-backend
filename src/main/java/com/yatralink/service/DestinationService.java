package com.yatralink.service;

import java.util.List;

import com.yatralink.model.Destination;

public interface DestinationService {
    Destination addDestination(Destination destination);
    List<Destination> getAllDestinations();
    Destination getDestinationById(Long id);
    void deleteDestination(Long id);
}
