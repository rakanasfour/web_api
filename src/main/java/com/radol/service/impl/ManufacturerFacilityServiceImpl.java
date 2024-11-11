package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ManufacturerFacilityDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.ManufacturerFacility;
import com.radol.repository.ManufacturerFacilityRepository;
import com.radol.repository.ManufacturerRepository;
import com.radol.service.ManufacturerFacilityService;

@Service
public class ManufacturerFacilityServiceImpl implements ManufacturerFacilityService {

    private final ManufacturerFacilityRepository facilityRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ManufacturerFacilityServiceImpl(ManufacturerFacilityRepository facilityRepository, ManufacturerRepository manufacturerRepository, ModelMapper modelMapper) {
        this.facilityRepository = facilityRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ManufacturerFacilityDTO createFacility(ManufacturerFacilityDTO facilityDTO) {
        ManufacturerFacility facility = modelMapper.map(facilityDTO, ManufacturerFacility.class);

        // Set Manufacturer relationship
        facility.setManufacturer(manufacturerRepository.findById(facilityDTO.getManufacturerId())
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found")));

        ManufacturerFacility savedFacility = facilityRepository.save(facility);
        return modelMapper.map(savedFacility, ManufacturerFacilityDTO.class);
    }

    @Override
    public ManufacturerFacilityDTO getFacilityById(Integer facilityId) {
        ManufacturerFacility facility = facilityRepository.findById(facilityId)
            .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
        return modelMapper.map(facility, ManufacturerFacilityDTO.class);
    }

    @Override
    public List<ManufacturerFacilityDTO> getAllFacilities() {
        return facilityRepository.findAll().stream()
            .map(facility -> modelMapper.map(facility, ManufacturerFacilityDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ManufacturerFacilityDTO updateFacility(Integer facilityId, ManufacturerFacilityDTO facilityDTO) {
        ManufacturerFacility existingFacility = facilityRepository.findById(facilityId)
            .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));

        modelMapper.map(facilityDTO, existingFacility); // Update fields from DTO

        // Update Manufacturer relationship
        existingFacility.setManufacturer(manufacturerRepository.findById(facilityDTO.getManufacturerId())
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found")));

        ManufacturerFacility updatedFacility = facilityRepository.save(existingFacility);
        return modelMapper.map(updatedFacility, ManufacturerFacilityDTO.class);
    }

    @Override
    public void deleteFacility(Integer facilityId) {
        ManufacturerFacility facility = facilityRepository.findById(facilityId)
            .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
        facilityRepository.delete(facility);
    }
}
