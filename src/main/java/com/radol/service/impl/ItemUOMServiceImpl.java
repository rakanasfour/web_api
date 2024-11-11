package com.radol.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ItemUOMDTO;
import com.radol.model.Item;
import com.radol.model.Uom;
import com.radol.repository.ItemRepository;
import com.radol.repository.UomRepository;
@Service
public class ItemUOMServiceImpl  {
	
	
	
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    
    

    @Autowired
    public ItemUOMServiceImpl(ItemRepository itemRepository,  ModelMapper modelMapper) {
        this.itemRepository = itemRepository;

        this.modelMapper = modelMapper;
    }
    
  
        
   // public List<ItemUOMDTO> getItemWithUomDetails() {
   //     return itemRepository.findItemNames(1);
   // }
    
    /*
    
    public List<ItemUOMDTO> getAllItemUom() {
        return itemRepository.findItemUom(1);
    }
    
    /*
    
    public List<ItemUOMDTO> createItemUOM(ItemUOMDTO itemUOMDTO) {
    	
        Item item = modelMapper.map(itemUOMDTO, Item.class);
        
        itemRepository.save(item);

        Uom uom = modelMapper.map(itemUOMDTO, Uom.class);
    	
        
        uomepository.save(uom);
        
        return ;
        		
        		
    }
    
 
     
            /*
               public List<ItemUOMDTO> getItemUOM() {
        	
        	
        	
                         // .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
            // Map each related entity to its respective DTO
         //   ItemUOMDTO itemUOMDTO = modelMapper.map(item, ItemUOMDTO.class);
            
      
            UomDTO uomDTO = modelMapper.map(item.getUom(), UomDTO.class);
            CategoryDTO categoryDTO = modelMapper.map(item.getCategory(), CategoryDTO.class);
            BrandDTO brandDTO = modelMapper.map(item.getBrand(), BrandDTO.class);
            SupplierDTO supplierDTO = modelMapper.map(item.getSupplier(), SupplierDTO.class);
            
            // Assemble the composite DTO
            return new ItemDetailsDTO(itemDTO, uomDTO, categoryDTO, brandDTO, supplierDTO);
     
            
            return itemRepository.findItemNamesById();
                   */
        
    }