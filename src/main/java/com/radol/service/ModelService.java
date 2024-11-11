package com.radol.service;

import java.util.List;

import com.radol.dto.ModelDTO;

public interface ModelService {
    ModelDTO createModel(ModelDTO modelDTO);
    ModelDTO getModelById(Integer modelId);
    List<ModelDTO> getAllModels();
    ModelDTO updateModel(Integer modelId, ModelDTO modelDTO);
    void deleteModel(Integer modelId);
}
