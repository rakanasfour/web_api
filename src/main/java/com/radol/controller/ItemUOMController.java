package com.radol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.ItemUOMDTO;
import com.radol.service.impl.ItemUOMServiceImpl;

@RestController
	@RequestMapping("/api/items-query")
	public class ItemUOMController {

	    private final ItemUOMServiceImpl itemUOMServiceImpl;

	    @Autowired
	    public ItemUOMController(ItemUOMServiceImpl itemUOMServiceImpl) {
	        this.itemUOMServiceImpl = itemUOMServiceImpl;
	    }

	/*
	    @GetMapping
	    public  ResponseEntity<List<ItemUOMDTO>>getAllItems() {
	    	List<ItemUOMDTO>items = itemUOMServiceImpl.getItemWithUomDetails();
	    	return  ResponseEntity.ok(items);
	
	    }
	
	    
	    
	    @GetMapping("/display")
	    public  ResponseEntity<List<ItemUOMDTO>>getAllItemUom() {
	    	List<ItemUOMDTO>items = itemUOMServiceImpl.getAllItemUom();
	    	return  ResponseEntity.ok(items);
	
	    }
	    
	        */
  
	    /*
    	@PostMapping
        public ResponseEntity<ItemUOMDTO> createItem(@RequestBody ItemUOMDTO itemUOMDTO) {
    		ItemUOMDTO createdOrder = itemUOMServiceImpl.createItemUOM(itemUOMDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        }
        
        */
    	
    	

}
