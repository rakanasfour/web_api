package com.radol.service;

import java.util.List;

import com.radol.dto.ModelPictureDTO;

public interface ModelPictureService {
    ModelPictureDTO createModelPicture(ModelPictureDTO modelPictureDTO);
    ModelPictureDTO getModelPictureById(Integer modelPictureId);
    List<ModelPictureDTO> getAllModelPictures();
    ModelPictureDTO updateModelPicture(Integer modelPictureId, ModelPictureDTO modelPictureDTO);
    void deleteModelPicture(Integer modelPictureId);
}
