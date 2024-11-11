package com.radol.service;

import java.util.List;

import com.radol.dto.AttributeDTO;

public interface AttributeService {
    AttributeDTO createAttribute(AttributeDTO attributeDTO);
    AttributeDTO getAttributeById(Integer attributeId);
    List<AttributeDTO> getAllAttributes();
    AttributeDTO updateAttribute(Integer attributeId, AttributeDTO attributeDTO);
    void deleteAttribute(Integer attributeId);
}