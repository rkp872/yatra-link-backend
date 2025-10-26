package com.yatralink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatralink.model.Destination;
import com.yatralink.service.DestinationService;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = "http://localhost:3000")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public Destination addDestination(@RequestBody Destination destination){
        return destinationService.addDestination(destination);
    }

    @GetMapping
    public List<Destination> getAllDestinations(){
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id){
        return destinationService.getDestinationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id){
        destinationService.deleteDestination(id);
    }


    
}
