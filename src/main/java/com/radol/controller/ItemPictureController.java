package com.radol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.ItemPictureDTO;
import com.radol.service.ItemPictureService;

@RestController
@RequestMapping("/api/item-pictures")
public class ItemPictureController {

    private final ItemPictureService itemPictureService;

    @Autowired
    public ItemPictureController(ItemPictureService itemPictureService) {
        this.itemPictureService = itemPictureService;
    }

    @PostMapping
    public ResponseEntity<ItemPictureDTO> createItemPicture(@RequestBody ItemPictureDTO itemPictureDTO) {
        ItemPictureDTO createdItemPicture = itemPictureService.createItemPicture(itemPictureDTO);
        return new ResponseEntity<>(createdItemPicture, HttpStatus.CREATED);
    }

    @GetMapping("/{itemPictureId}")
    public ResponseEntity<ItemPictureDTO> getItemPictureById(@PathVariable Integer itemPictureId) {
        ItemPictureDTO itemPicture = itemPictureService.getItemPictureById(itemPictureId);
        return new ResponseEntity<>(itemPicture, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemPictureDTO>> getAllItemPictures() {
        List<ItemPictureDTO> itemPictures = itemPictureService.getAllItemPictures();
        return new ResponseEntity<>(itemPictures, HttpStatus.OK);
    }

    @PutMapping("/{itemPictureId}")
    public ResponseEntity<ItemPictureDTO> updateItemPicture(@PathVariable Integer itemPictureId, @RequestBody ItemPictureDTO itemPictureDTO) {
        ItemPictureDTO updatedItemPicture = itemPictureService.updateItemPicture(itemPictureId, itemPictureDTO);
        return new ResponseEntity<>(updatedItemPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{itemPictureId}")
    public ResponseEntity<Void> deleteItemPicture(@PathVariable Integer itemPictureId) {
        itemPictureService.deleteItemPicture(itemPictureId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}