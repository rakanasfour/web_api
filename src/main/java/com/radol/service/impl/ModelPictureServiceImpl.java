package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ModelPictureDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.ModelPicture;
import com.radol.repository.ModelPictureRepository;
import com.radol.repository.ModelRepository;
import com.radol.service.ModelPictureService;

@Service
public class ModelPictureServiceImpl implements ModelPictureService {

    private final ModelPictureRepository modelPictureRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelPictureServiceImpl(ModelPictureRepository modelPictureRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelPictureRepository = modelPictureRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelPictureDTO createModelPicture(ModelPictureDTO modelPictureDTO) {
        ModelPicture modelPicture = modelMapper.map(modelPictureDTO, ModelPicture.class);

        // Set Model relationship
        modelPicture.setModelPicture(modelRepository.findById(modelPictureDTO.getModelId())
                .orElseThrow(() -> new ResourceNotFoundException("Model not found")));

        ModelPicture savedModelPicture = modelPictureRepository.save(modelPicture);
        return modelMapper.map(savedModelPicture, ModelPictureDTO.class);
    }

    @Override
    public ModelPictureDTO getModelPictureById(Integer modelPictureId) {
        ModelPicture modelPicture = modelPictureRepository.findById(modelPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Model Picture not found"));
        return modelMapper.map(modelPicture, ModelPictureDTO.class);
    }

    @Override
    public List<ModelPictureDTO> getAllModelPictures() {
        return modelPictureRepository.findAll().stream()
            .map(modelPicture -> modelMapper.map(modelPicture, ModelPictureDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ModelPictureDTO updateModelPicture(Integer modelPictureId, ModelPictureDTO modelPictureDTO) {
        ModelPicture existingModelPicture = modelPictureRepository.findById(modelPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Model Picture not found"));

        // Update fields from DTO
        existingModelPicture.setModelPictureName(modelPictureDTO.getModelPictureName());
        existingModelPicture.setModelPictureLink(modelPictureDTO.getModelPictureLink());

        // Update Model relationship
        existingModelPicture.setModelPicture(modelRepository.findById(modelPictureDTO.getModelId())
                .orElseThrow(() -> new ResourceNotFoundException("Model not found")));

        ModelPicture updatedModelPicture = modelPictureRepository.save(existingModelPicture);
        return modelMapper.map(updatedModelPicture, ModelPictureDTO.class);
    }

    @Override
    public void deleteModelPicture(Integer modelPictureId) {
        ModelPicture modelPicture = modelPictureRepository.findById(modelPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Model Picture not found"));
        modelPictureRepository.delete(modelPicture);
    }
}
