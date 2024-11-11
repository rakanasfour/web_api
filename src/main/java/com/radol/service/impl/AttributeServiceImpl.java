package com.radol.service.impl;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.AttributeDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Attribute;
import com.radol.model.Item;
import com.radol.model.ItemAttribute;
import com.radol.repository.AttributeRepository;
import com.radol.repository.ItemAttributeRepository;
import com.radol.repository.ItemRepository;
import com.radol.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;
    private final ItemRepository itemRepository;
    private final ItemAttributeRepository itemAttributeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AttributeServiceImpl(AttributeRepository attributeRepository, ItemRepository itemRepository, ItemAttributeRepository itemAttributeRepository, ModelMapper modelMapper) {
        this.attributeRepository = attributeRepository;
        this.itemRepository = itemRepository;
        this.itemAttributeRepository = itemAttributeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AttributeDTO createAttribute(AttributeDTO attributeDTO) {
        Attribute attribute = modelMapper.map(attributeDTO, Attribute.class);

        // Save attribute
        Attribute savedAttribute = attributeRepository.save(attribute);

        // Establish relationships with items if provided
        if (attributeDTO.getItemAttributes() != null && !attributeDTO.getItemAttributes().isEmpty()) {
            Set<Item> items = itemRepository.findAllById(attributeDTO.getItemAttributes()).stream().collect(Collectors.toSet());
            for (Item item : items) {
                ItemAttribute itemAttribute = new ItemAttribute();
                itemAttribute.setMappedItem(item);
                itemAttribute.setMappedAttribute(savedAttribute);
                itemAttributeRepository.save(itemAttribute);
            }
        }

        return modelMapper.map(savedAttribute, AttributeDTO.class);
    }

    @Override
    public AttributeDTO getAttributeById(Integer attributeId) {
        Attribute attribute = attributeRepository.findById(attributeId)
            .orElseThrow(() -> new ResourceNotFoundException("Attribute not found"));
        return modelMapper.map(attribute, AttributeDTO.class);
    }

    @Override
    public List<AttributeDTO> getAllAttributes() {
        return attributeRepository.findAll().stream()
            .map(attribute -> modelMapper.map(attribute, AttributeDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public AttributeDTO updateAttribute(Integer attributeId, AttributeDTO attributeDTO) {
        Attribute existingAttribute = attributeRepository.findById(attributeId)
            .orElseThrow(() -> new ResourceNotFoundException("Attribute not found"));

        // Update fields from DTO
        existingAttribute.setAttributeName(attributeDTO.getAttributeName());
        existingAttribute.setAttributeType(attributeDTO.getAttributeType());
        existingAttribute.setAttributeAssistText(attributeDTO.getAttributeAssistText());

        // Update related items
        if (attributeDTO.getItemAttributes() != null) {
            // Remove existing relationships
            itemAttributeRepository.deleteAllByMappedAttribute(existingAttribute);

            // Add new relationships
            List<Item> items = itemRepository.findAllById(attributeDTO.getItemAttributes()).stream().collect(Collectors.toSet());
            for (Item item : items) {
                ItemAttribute itemAttribute = new ItemAttribute();
                itemAttribute.setMappedItem(item);
                itemAttribute.setMappedAttribute(existingAttribute);
                itemAttributeRepository.save(itemAttribute);
            }
        }

        Attribute updatedAttribute = attributeRepository.save(existingAttribute);
        return modelMapper.map(updatedAttribute, AttributeDTO.class);
    }

    @Override
    public void deleteAttribute(Integer attributeId) {
        Attribute attribute = attributeRepository.findById(attributeId)
            .orElseThrow(() -> new ResourceNotFoundException("Attribute not found"));
        
        // Remove all relationships for this attribute
        itemAttributeRepository.deleteAllByMappedAttribute(attribute);

        // Delete the attribute
        attributeRepository.delete(attribute);
    }
}
