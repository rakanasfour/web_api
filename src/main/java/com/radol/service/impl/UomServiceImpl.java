package com.radol.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.UomDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Item;
import com.radol.model.ItemUOM;
import com.radol.model.Uom;
import com.radol.repository.ItemRepository;
import com.radol.repository.ItemUomRepository;
import com.radol.repository.UomRepository;
import com.radol.service.UomService;

@Service
public class UomServiceImpl implements UomService {

    private final UomRepository uomRepository;
    private final ItemRepository itemRepository;
    private final ItemUomRepository itemUomRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UomServiceImpl(UomRepository uomRepository, ItemRepository itemRepository, ItemUomRepository itemUomRepository, ModelMapper modelMapper) {
        this.uomRepository = uomRepository;
        this.itemRepository = itemRepository;
        this.itemUomRepository = itemUomRepository;
        this.modelMapper = modelMapper;
    }
    
    
    @Override
    public List<UomDTO> getAllUoms() {
    	
    //	modelMapper.getConfiguration()
    //	.setMatchingStrategy(MatchingStrategies.LOOSE);
    	
        return uomRepository.findAll().stream()
            .map(uom -> modelMapper.map(uom, UomDTO.class))
            .collect(Collectors.toList());
    }
/*
    @Override
    public UomDTO createUom(UomDTO uomDTO) {
        Uom uom = modelMapper.map(uomDTO, Uom.class);

        // Save UOM
        Uom savedUom = uomRepository.save(uom);

        // Establish relationships with items if provided
        if (uomDTO.getItemQuantities() != null) {
            for (Map.Entry<Integer, Integer> entry : uomDTO.getItemQuantities().entrySet()) {
                Item item = itemRepository.findById(entry.getKey())
                        .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + entry.getKey()));

                ItemUom itemUom = new ItemUom();
                itemUom.setItem(item);
                itemUom.setUom(savedUom);
                itemUom.setItemUomQuantity(entry.getValue());
                itemUomRepository.save(itemUom);
            }
        }

        return modelMapper.map(savedUom, UomDTO.class);
    }
  

    @Override
    public UomDTO getUomById(Integer uomId) {
        Uom uom = uomRepository.findById(uomId)
            .orElseThrow(() -> new ResourceNotFoundException("UOM not found"));
        return modelMapper.map(uom, UomDTO.class);
    }



    @Override
    public UomDTO updateUom(Integer uomId, UomDTO uomDTO) {
        Uom existingUom = uomRepository.findById(uomId)
            .orElseThrow(() -> new ResourceNotFoundException("UOM not found"));

        // Update fields from DTO
        existingUom.setUomType(uomDTO.getUomType());
        existingUom.setUomLevel(uomDTO.getUomLevel());
        existingUom.setUomStatus(uomDTO.getUomStatus());
        existingUom.setUomManufacturerBarcode(uomDTO.getUomManufacturerBarcode());
        existingUom.setUomInternalBarcode(uomDTO.getUomInternalBarcode());

        // Update related items
        if (uomDTO.getItemQuantities() != null) {
            // Remove existing relationships
            itemUomRepository.deleteAllByUom(existingUom);

            // Add new relationships
            for (Map.Entry<Integer, Integer> entry : uomDTO.getItemQuantities().entrySet()) {
                Item item = itemRepository.findById(entry.getKey())
                        .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + entry.getKey()));

                ItemUom itemUom = new ItemUom();
                itemUom.setItem(item);
                itemUom.setUom(existingUom);
                itemUom.setItemUomQuantity(entry.getValue());
                itemUomRepository.save(itemUom);
            }
        }

        Uom updatedUom = uomRepository.save(existingUom);
        return modelMapper.map(updatedUom, UomDTO.class);
    }

    @Override
    public void deleteUom(Integer uomId) {
        Uom uom = uomRepository.findById(uomId)
            .orElseThrow(() -> new ResourceNotFoundException("UOM not found"));
        
        // Remove all relationships for this UOM
        itemUomRepository.deleteAllByUom(uom);

        // Delete the UOM
        uomRepository.delete(uom);
    }
      */


	@Override
	public UomDTO createUom(UomDTO uomDTO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UomDTO getUomById(Integer uomId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UomDTO updateUom(Integer uomId, UomDTO uomDTO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteUom(Integer uomId) {
		// TODO Auto-generated method stub
		
	}
}
