package com.radol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.DistributorDTO;
import com.radol.service.DistributorService;

@RestController
@RequestMapping("/api/distributors")
public class DistributorController {

    private final DistributorService distributorService;

    @Autowired
    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @PostMapping
    public ResponseEntity<DistributorDTO> createDistributor(@RequestBody DistributorDTO distributorDTO) {
        DistributorDTO createdDistributor = distributorService.createDistributor(distributorDTO);
        return new ResponseEntity<>(createdDistributor, HttpStatus.CREATED);
    }

    @GetMapping("/{distributorId}")
    public ResponseEntity<DistributorDTO> getDistributorById(@PathVariable Integer distributorId) {
        DistributorDTO distributor = distributorService.getDistributorById(distributorId);
        return new ResponseEntity<>(distributor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DistributorDTO>> getAllDistributors() {
        List<DistributorDTO> distributors = distributorService.getAllDistributors();
        return new ResponseEntity<>(distributors, HttpStatus.OK);
    }

    @PutMapping("/{distributorId}")
    public ResponseEntity<DistributorDTO> updateDistributor(@PathVariable Integer distributorId, @RequestBody DistributorDTO distributorDTO) {
        DistributorDTO updatedDistributor = distributorService.updateDistributor(distributorId, distributorDTO);
        return new ResponseEntity<>(updatedDistributor, HttpStatus.OK);
    }

    @DeleteMapping("/{distributorId}")
    public ResponseEntity<Void> deleteDistributor(@PathVariable Integer distributorId) {
        distributorService.deleteDistributor(distributorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
