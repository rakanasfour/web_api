package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ManufacturerDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Manufacturer;
import com.radol.repository.ManufacturerRepository;
import com.radol.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ModelMapper modelMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ManufacturerDTO createManufacturer(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = modelMapper.map(manufacturerDTO, Manufacturer.class);
        Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
        return modelMapper.map(savedManufacturer, ManufacturerDTO.class);
    }

    @Override
    public ManufacturerDTO getManufacturerById(Integer manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found"));
        return modelMapper.map(manufacturer, ManufacturerDTO.class);
    }

    @Override
    public List<ManufacturerDTO> getAllManufacturers() {
        return manufacturerRepository.findAll().stream()
            .map(manufacturer -> modelMapper.map(manufacturer, ManufacturerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ManufacturerDTO updateManufacturer(Integer manufacturerId, ManufacturerDTO manufacturerDTO) {
        Manufacturer existingManufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found"));

        modelMapper.map(manufacturerDTO, existingManufacturer);  // Update fields from DTO
        Manufacturer updatedManufacturer = manufacturerRepository.save(existingManufacturer);
        return modelMapper.map(updatedManufacturer, ManufacturerDTO.class);
    }

    @Override
    public void deleteManufacturer(Integer manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found"));
        manufacturerRepository.delete(manufacturer);
    }
}
