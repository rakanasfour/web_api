package com.radol.service;

import java.util.List;

import com.radol.dto.ChannelDTO;

public interface ChannelService {
    ChannelDTO createChannel(ChannelDTO channelDTO);
    ChannelDTO getChannelById(Integer channelId);
    List<ChannelDTO> getAllChannels();
    ChannelDTO updateChannel(Integer channelId, ChannelDTO channelDTO);
    void deleteChannel(Integer channelId);
}
