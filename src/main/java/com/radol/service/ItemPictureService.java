package com.radol.service;

import java.util.List;

import com.radol.dto.ItemPictureDTO;

public interface ItemPictureService {
    ItemPictureDTO createItemPicture(ItemPictureDTO itemPictureDTO);
    ItemPictureDTO getItemPictureById(Integer itemPictureId);
    List<ItemPictureDTO> getAllItemPictures();
    ItemPictureDTO updateItemPicture(Integer itemPictureId, ItemPictureDTO itemPictureDTO);
    void deleteItemPicture(Integer itemPictureId);
}