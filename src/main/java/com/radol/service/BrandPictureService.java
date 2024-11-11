package com.radol.service;

import java.util.List;

import com.radol.dto.BrandPictureDTO;

public interface BrandPictureService {
    BrandPictureDTO createBrandPicture(BrandPictureDTO brandPictureDTO);
    BrandPictureDTO getBrandPictureById(Integer brandPictureId);
    List<BrandPictureDTO> getAllBrandPictures();
    BrandPictureDTO updateBrandPicture(Integer brandPictureId, BrandPictureDTO brandPictureDTO);
    void deleteBrandPicture(Integer brandPictureId);
}