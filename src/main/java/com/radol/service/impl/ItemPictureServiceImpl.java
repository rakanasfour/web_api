package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ItemPictureDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.ItemPicture;
import com.radol.repository.ItemPictureRepository;
import com.radol.repository.ItemRepository;
import com.radol.service.ItemPictureService;

@Service
public class ItemPictureServiceImpl implements ItemPictureService {

    private final ItemPictureRepository itemPictureRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemPictureServiceImpl(ItemPictureRepository itemPictureRepository, ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemPictureRepository = itemPictureRepository;
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ItemPictureDTO createItemPicture(ItemPictureDTO itemPictureDTO) {
        ItemPicture itemPicture = modelMapper.map(itemPictureDTO, ItemPicture.class);

        // Set Item relationship
        itemPicture.setItem(itemRepository.findById(itemPictureDTO.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found")));

        ItemPicture savedItemPicture = itemPictureRepository.save(itemPicture);
        return modelMapper.map(savedItemPicture, ItemPictureDTO.class);
    }

    @Override
    public ItemPictureDTO getItemPictureById(Integer itemPictureId) {
        ItemPicture itemPicture = itemPictureRepository.findById(itemPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Item Picture not found"));
        return modelMapper.map(itemPicture, ItemPictureDTO.class);
    }

    @Override
    public List<ItemPictureDTO> getAllItemPictures() {
        return itemPictureRepository.findAll().stream()
            .map(itemPicture -> modelMapper.map(itemPicture, ItemPictureDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ItemPictureDTO updateItemPicture(Integer itemPictureId, ItemPictureDTO itemPictureDTO) {
        ItemPicture existingItemPicture = itemPictureRepository.findById(itemPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Item Picture not found"));

        // Update fields from DTO
        existingItemPicture.setItemPictureMain(itemPictureDTO.getItemPictureMain());

        // Update Item relationship
        existingItemPicture.setItem(itemRepository.findById(itemPictureDTO.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found")));

        ItemPicture updatedItemPicture = itemPictureRepository.save(existingItemPicture);
        return modelMapper.map(updatedItemPicture, ItemPictureDTO.class);
    }

    @Override
    public void deleteItemPicture(Integer itemPictureId) {
        ItemPicture itemPicture = itemPictureRepository.findById(itemPictureId)
            .orElseThrow(() -> new ResourceNotFoundException("Item Picture not found"));
        itemPictureRepository.delete(itemPicture);
    }
}
