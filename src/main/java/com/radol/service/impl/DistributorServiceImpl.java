package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.DistributorDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Distributor;
import com.radol.repository.DistributorRepository;
import com.radol.service.DistributorService;

@Service
public class DistributorServiceImpl implements DistributorService {

    private final DistributorRepository distributorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DistributorServiceImpl(DistributorRepository distributorRepository, ModelMapper modelMapper) {
        this.distributorRepository = distributorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DistributorDTO createDistributor(DistributorDTO distributorDTO) {
        Distributor distributor = modelMapper.map(distributorDTO, Distributor.class);
        Distributor savedDistributor = distributorRepository.save(distributor);
        return modelMapper.map(savedDistributor, DistributorDTO.class);
    }

    @Override
    public DistributorDTO getDistributorById(Integer distributorId) {
        Distributor distributor = distributorRepository.findById(distributorId)
            .orElseThrow(() -> new ResourceNotFoundException("Distributor not found"));
        return modelMapper.map(distributor, DistributorDTO.class);
    }

    @Override
    public List<DistributorDTO> getAllDistributors() {
        return distributorRepository.findAll().stream()
            .map(distributor -> modelMapper.map(distributor, DistributorDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public DistributorDTO updateDistributor(Integer distributorId, DistributorDTO distributorDTO) {
        Distributor existingDistributor = distributorRepository.findById(distributorId)
            .orElseThrow(() -> new ResourceNotFoundException("Distributor not found"));

        modelMapper.map(distributorDTO, existingDistributor);  // Update fields from DTO
        Distributor updatedDistributor = distributorRepository.save(existingDistributor);
        return modelMapper.map(updatedDistributor, DistributorDTO.class);
    }

    @Override
    public void deleteDistributor(Integer distributorId) {
        Distributor distributor = distributorRepository.findById(distributorId)
            .orElseThrow(() -> new ResourceNotFoundException("Distributor not found"));
        distributorRepository.delete(distributor);
    }
}
