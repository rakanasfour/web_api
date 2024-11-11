package com.radol.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ChannelDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Channel;
import com.radol.model.Item;
import com.radol.model.ItemChannel;
import com.radol.repository.ChannelRepository;
import com.radol.repository.ItemChannelRepository;
import com.radol.repository.ItemRepository;
import com.radol.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ItemRepository itemRepository;
    private final ItemChannelRepository itemChannelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository, ItemRepository itemRepository, ItemChannelRepository itemChannelRepository, ModelMapper modelMapper) {
        this.channelRepository = channelRepository;
        this.itemRepository = itemRepository;
        this.itemChannelRepository = itemChannelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChannelDTO createChannel(ChannelDTO channelDTO) {
        Channel channel = modelMapper.map(channelDTO, Channel.class);

        // Save channel
        Channel savedChannel = channelRepository.save(channel);

        // Establish relationships with items if provided
        if (channelDTO.getItemChannels() != null && channelDTO.getItemChannels().isEmpty() ) {
            Set<Item> items = itemRepository.findAllById(channelDTO.getItemChannels()).stream().collect(Collectors.toSet());
            for (Item item : items) {
                ItemChannel itemChannel = new ItemChannel();
                itemChannel.setMappedItemChannel(item);
                itemChannel.setMappedChannel(savedChannel);
                itemChannelRepository.save(itemChannel);
            }
        }

        return modelMapper.map(savedChannel, ChannelDTO.class);
    }

    @Override
    public ChannelDTO getChannelById(Integer channelId) {
        Channel channel = channelRepository.findById(channelId)
            .orElseThrow(() -> new ResourceNotFoundException("Channel not found"));
        return modelMapper.map(channel, ChannelDTO.class);
    }

    @Override
    public List<ChannelDTO> getAllChannels() {
        return channelRepository.findAll().stream()
            .map(channel -> modelMapper.map(channel, ChannelDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ChannelDTO updateChannel(Integer channelId, ChannelDTO channelDTO) {
        Channel existingChannel = channelRepository.findById(channelId)
            .orElseThrow(() -> new ResourceNotFoundException("Channel not found"));

        // Update fields from DTO
        existingChannel.setChannelDescription(channelDTO.getChannelDescription());
        existingChannel.setChannelsLevel(channelDTO.getChannelsLevel());
        existingChannel.setChannelDefaultUom(channelDTO.getChannelDefaultUom());

        // Update related items
        if (channelDTO.getItemChannels() != null && channelDTO.getItemChannels().isEmpty()) {
            // Remove existing relationships
            itemChannelRepository.deleteAllByMappedChannel(existingChannel);

            // Add new relationships
            Set<Item> items = itemRepository.findAllById(channelDTO.getItemChannels()).stream().collect(Collectors.toSet());
            for (Item item : items) {
                ItemChannel itemChannel = new ItemChannel();
                itemChannel.setMappedItemChannel(item);
                itemChannel.setMappedChannel(existingChannel);
                itemChannelRepository.save(itemChannel);
            }
        }

        Channel updatedChannel = channelRepository.save(existingChannel);
        return modelMapper.map(updatedChannel, ChannelDTO.class);
    }

    @Override
    public void deleteChannel(Integer channelId) {
        Channel channel = channelRepository.findById(channelId)
            .orElseThrow(() -> new ResourceNotFoundException("Channel not found"));
        
        // Remove all relationships for this channel
        itemChannelRepository.deleteAllByMappedChannel(channel);

        // Delete the channel
        channelRepository.delete(channel);
    }
}
