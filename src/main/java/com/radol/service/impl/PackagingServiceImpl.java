package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.PackagingDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Packaging;
import com.radol.repository.PackagingRepository;
import com.radol.service.PackagingService;

@Service
public class PackagingServiceImpl implements PackagingService {

    private final PackagingRepository packagingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PackagingServiceImpl(PackagingRepository packagingRepository, ModelMapper modelMapper) {
        this.packagingRepository = packagingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PackagingDTO createPackaging(PackagingDTO packagingDTO) {
        Packaging packaging = modelMapper.map(packagingDTO, Packaging.class);
        Packaging savedPackaging = packagingRepository.save(packaging);
        return modelMapper.map(savedPackaging, PackagingDTO.class);
    }

    @Override
    public PackagingDTO getPackagingById(Integer packagingId) {
        Packaging packaging = packagingRepository.findById(packagingId)
            .orElseThrow(() -> new ResourceNotFoundException("Packaging not found"));
        return modelMapper.map(packaging, PackagingDTO.class);
    }

    @Override
    public List<PackagingDTO> getAllPackagings() {
        return packagingRepository.findAll().stream()
            .map(packaging -> modelMapper.map(packaging, PackagingDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public PackagingDTO updatePackaging(Integer packagingId, PackagingDTO packagingDTO) {
        Packaging existingPackaging = packagingRepository.findById(packagingId)
            .orElseThrow(() -> new ResourceNotFoundException("Packaging not found"));

        // Update fields from DTO
        existingPackaging.setPackagingType(packagingDTO.getPackagingType());

        Packaging updatedPackaging = packagingRepository.save(existingPackaging);
        return modelMapper.map(updatedPackaging, PackagingDTO.class);
    }

    @Override
    public void deletePackaging(Integer packagingId) {
        Packaging packaging = packagingRepository.findById(packagingId)
            .orElseThrow(() -> new ResourceNotFoundException("Packaging not found"));
        packagingRepository.delete(packaging);
    }
}
