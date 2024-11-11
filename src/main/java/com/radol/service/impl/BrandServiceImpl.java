package com.radol.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.BrandDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Brand;
import com.radol.repository.BrandRepository;
import com.radol.repository.ManufacturerRepository;
import com.radol.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ManufacturerRepository manufacturerRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);

        // Set Manufacturer relationship
        brand.setManufacturer(manufacturerRepository.findById(brandDTO.getManufacturerId())
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found")));

        Brand savedBrand = brandRepository.save(brand);
        return modelMapper.map(savedBrand, BrandDTO.class);
    }

    @Override
    public BrandDTO getBrandById(Integer brandId) {
        Brand brand = brandRepository.findById(brandId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
        return modelMapper.map(brand, BrandDTO.class);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll().stream()
            .map(brand -> modelMapper.map(brand, BrandDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public BrandDTO updateBrand(Integer brandId, BrandDTO brandDTO) {
        Brand existingBrand = brandRepository.findById(brandId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));

        // Update fields from DTO
        existingBrand.setBrandName(brandDTO.getBrandName());
        existingBrand.setBrandDescription(brandDTO.getBrandDescription());
        existingBrand.setBrandStatus(brandDTO.getBrandStatus());

        // Update Manufacturer relationship
        existingBrand.setManufacturer(manufacturerRepository.findById(brandDTO.getManufacturerId())
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found")));

        Brand updatedBrand = brandRepository.save(existingBrand);
        return modelMapper.map(updatedBrand, BrandDTO.class);
    }

    @Override
    public void deleteBrand(Integer brandId) {
        Brand brand = brandRepository.findById(brandId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
        brandRepository.delete(brand);
    }
}

