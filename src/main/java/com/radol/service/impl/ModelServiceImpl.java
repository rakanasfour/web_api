package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ModelDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Model;
import com.radol.repository.BrandRepository;
import com.radol.repository.ManufacturerFacilityRepository;
import com.radol.repository.ModelRepository;
import com.radol.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ManufacturerFacilityRepository manufacturerFacilityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ManufacturerFacilityRepository manufacturerFacilityRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.manufacturerFacilityRepository = manufacturerFacilityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDTO createModel(ModelDTO modelDTO) {
        Model model = modelMapper.map(modelDTO, Model.class);

        // Set relationships
        model.setBrand(brandRepository.findById(modelDTO.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found")));
        if (modelDTO.getManufacturerFacilityId() != null) {
            model.setManufacturerFacility(manufacturerFacilityRepository.findById(modelDTO.getManufacturerFacilityId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manufacturer Facility not found")));
        }

        Model savedModel = modelRepository.save(model);
        return modelMapper.map(savedModel, ModelDTO.class);
    }

    @Override
    public ModelDTO getModelById(Integer modelId) {
        Model model = modelRepository.findById(modelId)
            .orElseThrow(() -> new ResourceNotFoundException("Model not found"));
        return modelMapper.map(model, ModelDTO.class);
    }

    @Override
    public List<ModelDTO> getAllModels() {
        return modelRepository.findAll().stream()
            .map(model -> modelMapper.map(model, ModelDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ModelDTO updateModel(Integer modelId, ModelDTO modelDTO) {
        Model existingModel = modelRepository.findById(modelId)
            .orElseThrow(() -> new ResourceNotFoundException("Model not found"));

        modelMapper.map(modelDTO, existingModel);  // Update fields from DTO

        // Update relationships
        existingModel.setBrand(brandRepository.findById(modelDTO.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found")));
        if (modelDTO.getManufacturerFacilityId() != null) {
            existingModel.setManufacturerFacility(manufacturerFacilityRepository.findById(modelDTO.getManufacturerFacilityId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manufacturer Facility not found")));
        } else {
            existingModel.setManufacturerFacility(null);
        }

        Model updatedModel = modelRepository.save(existingModel);
        return modelMapper.map(updatedModel, ModelDTO.class);
    }

    @Override
    public void deleteModel(Integer modelId) {
        Model model = modelRepository.findById(modelId)
            .orElseThrow(() -> new ResourceNotFoundException("Model not found"));
        modelRepository.delete(model);
    }
}
