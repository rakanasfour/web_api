package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ShippingDimensionDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.ShippingDimension;
import com.radol.repository.ShippingDimensionRepository;
import com.radol.service.ShippingDimensionService;

@Service
public class ShippingDimensionServiceImpl implements ShippingDimensionService {

    private final ShippingDimensionRepository shippingDimensionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShippingDimensionServiceImpl(ShippingDimensionRepository shippingDimensionRepository, ModelMapper modelMapper) {
        this.shippingDimensionRepository = shippingDimensionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShippingDimensionDTO createShippingDimension(ShippingDimensionDTO shippingDimensionDTO) {
        ShippingDimension shippingDimension = modelMapper.map(shippingDimensionDTO, ShippingDimension.class);
        ShippingDimension savedShippingDimension = shippingDimensionRepository.save(shippingDimension);
        return modelMapper.map(savedShippingDimension, ShippingDimensionDTO.class);
    }

    @Override
    public ShippingDimensionDTO getShippingDimensionById(Integer shippingDimensionId) {
        ShippingDimension shippingDimension = shippingDimensionRepository.findById(shippingDimensionId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipping Dimension not found"));
        return modelMapper.map(shippingDimension, ShippingDimensionDTO.class);
    }

    @Override
    public List<ShippingDimensionDTO> getAllShippingDimensions() {
        return shippingDimensionRepository.findAll().stream()
            .map(shippingDimension -> modelMapper.map(shippingDimension, ShippingDimensionDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ShippingDimensionDTO updateShippingDimension(Integer shippingDimensionId, ShippingDimensionDTO shippingDimensionDTO) {
        ShippingDimension existingShippingDimension = shippingDimensionRepository.findById(shippingDimensionId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipping Dimension not found"));

        // Update fields from DTO
        existingShippingDimension.setHeight(shippingDimensionDTO.getHeight());
        existingShippingDimension.setWidth(shippingDimensionDTO.getWidth());
        existingShippingDimension.setLength(shippingDimensionDTO.getLength());
        existingShippingDimension.setWeight(shippingDimensionDTO.getWeight());

        ShippingDimension updatedShippingDimension = shippingDimensionRepository.save(existingShippingDimension);
        return modelMapper.map(updatedShippingDimension, ShippingDimensionDTO.class);
    }

    @Override
    public void deleteShippingDimension(Integer shippingDimensionId) {
        ShippingDimension shippingDimension = shippingDimensionRepository.findById(shippingDimensionId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipping Dimension not found"));
        shippingDimensionRepository.delete(shippingDimension);
    }
}
