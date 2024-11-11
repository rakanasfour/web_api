package com.radol.service;

import java.util.List;

import com.radol.dto.UomPictureDTO;

public interface UomPictureService {
    UomPictureDTO createUomPicture(UomPictureDTO uomPictureDTO);
    UomPictureDTO getUomPictureById(Integer uomPictureId);
    List<UomPictureDTO> getAllUomPictures();
    UomPictureDTO updateUomPicture(Integer uomPictureId, UomPictureDTO uomPictureDTO);
    void deleteUomPicture(Integer uomPictureId);
}