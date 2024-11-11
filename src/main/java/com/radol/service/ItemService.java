package com.radol.service;

import java.util.List;

import com.radol.dto.ItemDTO;

public interface ItemService {
    ItemDTO createItem(ItemDTO itemDTO);
    ItemDTO getItemById(Integer itemId);
    List<ItemDTO> getAllItems();
    ItemDTO updateItem(Integer itemId, ItemDTO itemDTO);
    void deleteItem(Integer itemId);
}