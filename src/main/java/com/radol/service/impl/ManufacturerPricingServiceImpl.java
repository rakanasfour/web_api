package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ManufacturerPricingDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.ManufacturerPricing;
import com.radol.repository.ManufacturerPricingRepository;
import com.radol.service.ManufacturerPricingService;

@Service
public class ManufacturerPricingServiceImpl implements ManufacturerPricingService {

    private final ManufacturerPricingRepository pricingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ManufacturerPricingServiceImpl(ManufacturerPricingRepository pricingRepository, ModelMapper modelMapper) {
        this.pricingRepository = pricingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ManufacturerPricingDTO createPricing(ManufacturerPricingDTO pricingDTO) {
        ManufacturerPricing pricing = modelMapper.map(pricingDTO, ManufacturerPricing.class);
        ManufacturerPricing savedPricing = pricingRepository.save(pricing);
        return modelMapper.map(savedPricing, ManufacturerPricingDTO.class);
    }

    @Override
    public ManufacturerPricingDTO getPricingById(Integer pricingId) {
        ManufacturerPricing pricing = pricingRepository.findById(pricingId)
            .orElseThrow(() -> new ResourceNotFoundException("Pricing not found"));
        return modelMapper.map(pricing, ManufacturerPricingDTO.class);
    }

    @Override
    public List<ManufacturerPricingDTO> getAllPricing() {
        return pricingRepository.findAll().stream()
            .map(pricing -> modelMapper.map(pricing, ManufacturerPricingDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ManufacturerPricingDTO updatePricing(Integer pricingId, ManufacturerPricingDTO pricingDTO) {
        ManufacturerPricing existingPricing = pricingRepository.findById(pricingId)
            .orElseThrow(() -> new ResourceNotFoundException("Pricing not found"));

        modelMapper.map(pricingDTO, existingPricing);  // Update fields from DTO
        ManufacturerPricing updatedPricing = pricingRepository.save(existingPricing);
        return modelMapper.map(updatedPricing, ManufacturerPricingDTO.class);
    }

    @Override
    public void deletePricing(Integer pricingId) {
        ManufacturerPricing pricing = pricingRepository.findById(pricingId)
            .orElseThrow(() -> new ResourceNotFoundException("Pricing not found"));
        pricingRepository.delete(pricing);
    }
}