package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.UomPictureDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.UomPicture;
import com.radol.repository.UomPictureRepository;
import com.radol.repository.UomRepository;
import com.radol.service.UomPictureService;

@Service
public class UomPictureServiceImpl implements UomPictureService {

    private final UomPictureRepository uomPictureRepository;
    private final UomRepository uomRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UomPictureServiceImpl(UomPictureRepository uomPictureRepository, UomRepository uomRepository, ModelMapper modelMapper) {
        this.uomPictureRepository = uomPictureRepository;
        this.uomRepository = uomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UomPictureDTO createUomPicture(UomPictureDTO uomPictureDTO) {
        UomPicture uomPicture = modelMapper.map(uomPictureDTO, UomPicture.class);

        // Set Uom relationship
        uomPicture.setUompicture(uomRepository.findById(uomPictureDTO.getUomId())
                .orElseThrow(() -> new ResourceNotFoundException("UOM not found")));

        UomPicture savedUomPicture = uomPictureRepository.save(uomPicture);
        return modelMapper.map(savedUomPicture, UomPictureDTO.class);
    }

    @Override
    public UomPictureDTO getUomPictureById(Integer uomPictureId) {
        UomPicture uomPicture = uomPictureRepository.findById(uomPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("UOM Picture not found"));
        return modelMapper.map(uomPicture, UomPictureDTO.class);
    }

    @Override
    public List<UomPictureDTO> getAllUomPictures() {
        return uomPictureRepository.findAll().stream()
            .map(uomPicture -> modelMapper.map(uomPicture, UomPictureDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public UomPictureDTO updateUomPicture(Integer uomPictureId, UomPictureDTO uomPictureDTO) {
        UomPicture existingUomPicture = uomPictureRepository.findById(uomPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("UOM Picture not found"));

        // Update fields from DTO
        existingUomPicture.setUomPictureName(uomPictureDTO.getUomPictureName());
        existingUomPicture.setUomPictureLink(uomPictureDTO.getUomPictureLink());

        // Update Uom relationship
        existingUomPicture.setUompicture(uomRepository.findById(uomPictureDTO.getUomId())
                .orElseThrow(() -> new ResourceNotFoundException("UOM not found")));

        UomPicture updatedUomPicture = uomPictureRepository.save(existingUomPicture);
        return modelMapper.map(updatedUomPicture, UomPictureDTO.class);
    }

    @Override
    public void deleteUomPicture(Integer uomPictureId) {
        UomPicture uomPicture = uomPictureRepository.findById(uomPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("UOM Picture not found"));
        uomPictureRepository.delete(uomPicture);
    }
}
