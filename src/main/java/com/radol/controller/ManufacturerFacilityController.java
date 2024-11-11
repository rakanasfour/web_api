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

import com.radol.dto.ManufacturerFacilityDTO;
import com.radol.service.ManufacturerFacilityService;

@RestController
@RequestMapping("/api/manufacturer-facilities")
public class ManufacturerFacilityController {

    private final ManufacturerFacilityService facilityService;

    @Autowired
    public ManufacturerFacilityController(ManufacturerFacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public ResponseEntity<ManufacturerFacilityDTO> createFacility(@RequestBody ManufacturerFacilityDTO facilityDTO) {
        ManufacturerFacilityDTO createdFacility = facilityService.createFacility(facilityDTO);
        return new ResponseEntity<>(createdFacility, HttpStatus.CREATED);
    }

    @GetMapping("/{facilityId}")
    public ResponseEntity<ManufacturerFacilityDTO> getFacilityById(@PathVariable Integer facilityId) {
        ManufacturerFacilityDTO facility = facilityService.getFacilityById(facilityId);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerFacilityDTO>> getAllFacilities() {
        List<ManufacturerFacilityDTO> facilities = facilityService.getAllFacilities();
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }

    @PutMapping("/{facilityId}")
    public ResponseEntity<ManufacturerFacilityDTO> updateFacility(@PathVariable Integer facilityId, @RequestBody ManufacturerFacilityDTO facilityDTO) {
        ManufacturerFacilityDTO updatedFacility = facilityService.updateFacility(facilityId, facilityDTO);
        return new ResponseEntity<>(updatedFacility, HttpStatus.OK);
    }

    @DeleteMapping("/{facilityId}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Integer facilityId) {
        facilityService.deleteFacility(facilityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
