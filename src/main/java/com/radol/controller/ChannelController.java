package com.radol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.ChannelDTO;
import com.radol.service.ChannelService;

@RestController
@RequestMapping("/api/channels")
@CrossOrigin(origins = "http://localhost:3000")
public class ChannelController {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping
    public ResponseEntity<ChannelDTO> createChannel(@RequestBody ChannelDTO channelDTO) {
        ChannelDTO createdChannel = channelService.createChannel(channelDTO);
        return new ResponseEntity<>(createdChannel, HttpStatus.CREATED);
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<ChannelDTO> getChannelById(@PathVariable Integer channelId) {
        ChannelDTO channel = channelService.getChannelById(channelId);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ChannelDTO>> getAllChannels() {
        List<ChannelDTO> channels = channelService.getAllChannels();
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

    @PutMapping("/{channelId}")
    public ResponseEntity<ChannelDTO> updateChannel(@PathVariable Integer channelId, @RequestBody ChannelDTO channelDTO) {
        ChannelDTO updatedChannel = channelService.updateChannel(channelId, channelDTO);
        return new ResponseEntity<>(updatedChannel, HttpStatus.OK);
    }

    @DeleteMapping("/{channelId}")
    public ResponseEntity<Void> deleteChannel(@PathVariable Integer channelId) {
        channelService.deleteChannel(channelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
