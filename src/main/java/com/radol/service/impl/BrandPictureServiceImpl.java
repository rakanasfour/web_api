package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.BrandPictureDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.BrandPicture;
import com.radol.repository.BrandPictureRepository;
import com.radol.repository.BrandRepository;
import com.radol.service.BrandPictureService;

@Service
public class BrandPictureServiceImpl implements BrandPictureService {

    private final BrandPictureRepository brandPictureRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandPictureServiceImpl(BrandPictureRepository brandPictureRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandPictureRepository = brandPictureRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandPictureDTO createBrandPicture(BrandPictureDTO brandPictureDTO) {
        BrandPicture brandPicture = modelMapper.map(brandPictureDTO, BrandPicture.class);

        // Set Brand relationship
        brandPicture.setBrand(brandRepository.findById(brandPictureDTO.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found")));

        BrandPicture savedBrandPicture = brandPictureRepository.save(brandPicture);
        return modelMapper.map(savedBrandPicture, BrandPictureDTO.class);
    }

    @Override
    public BrandPictureDTO getBrandPictureById(Integer brandPictureId) {
        BrandPicture brandPicture = brandPictureRepository.findById(brandPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand Picture not found"));
        return modelMapper.map(brandPicture, BrandPictureDTO.class);
    }

    @Override
    public List<BrandPictureDTO> getAllBrandPictures() {
        return brandPictureRepository.findAll().stream()
            .map(brandPicture -> modelMapper.map(brandPicture, BrandPictureDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public BrandPictureDTO updateBrandPicture(Integer brandPictureId, BrandPictureDTO brandPictureDTO) {
        BrandPicture existingBrandPicture = brandPictureRepository.findById(brandPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand Picture not found"));

        // Update fields from DTO
        existingBrandPicture.setBrandPictureName(brandPictureDTO.getBrandPictureName());
        existingBrandPicture.setBrandPictureLink(brandPictureDTO.getBrandPictureLink());

        // Update Brand relationship
        existingBrandPicture.setBrand(brandRepository.findById(brandPictureDTO.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found")));

        BrandPicture updatedBrandPicture = brandPictureRepository.save(existingBrandPicture);
        return modelMapper.map(updatedBrandPicture, BrandPictureDTO.class);
    }

    @Override
    public void deleteBrandPicture(Integer brandPictureId) {
        BrandPicture brandPicture = brandPictureRepository.findById(brandPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand Picture not found"));
        brandPictureRepository.delete(brandPicture);
    }
}
