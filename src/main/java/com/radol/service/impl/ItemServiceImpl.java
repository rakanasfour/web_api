package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ItemDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Item;
import com.radol.repository.ItemRepository;
import com.radol.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {


    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    
    

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }
    
    

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
    
        Item item = modelMapper.map(itemDTO, Item.class);
        Item savedItem = itemRepository.save(item);
        return modelMapper.map(savedItem, ItemDTO.class);
    }

    @Override
    public ItemDTO getItemById(Integer itemId) {
        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        return modelMapper.map(item, ItemDTO.class);
    }

    
 	//modelMapper.getConfiguration()
	//.setMatchingStrategy(MatchingStrategies.LOOSE);
    
	
    @Override
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
            .map(item -> modelMapper.map(item, ItemDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ItemDTO updateItem(Integer itemId, ItemDTO itemDTO) {
        Item existingItem = itemRepository.findById(itemId)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found"));

        modelMapper.map(itemDTO, existingItem);  // Update fields from DTO
        Item updatedItem = itemRepository.save(existingItem);
        return modelMapper.map(updatedItem, ItemDTO.class);
    }

    @Override
    public void deleteItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        itemRepository.delete(item);
    }
}
