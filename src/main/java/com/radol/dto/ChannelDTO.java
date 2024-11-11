package com.radol.dto;

import java.util.List;
import java.util.Set;

import com.radol.model.Channel;
import com.radol.model.Channel.ChannelUOM;




public class ChannelDTO {
    private Integer channelId;
    private String channelDescription;
    private Integer channelsLevel;
    private Channel.ChannelUOM channelDefaultUom;
    
    private List<ItemsChannelsDTO> itemChannels;

	public ChannelDTO(Integer channelId, String channelDescription, Integer channelsLevel, ChannelUOM channelDefaultUom,
			List<ItemsChannelsDTO> itemChannels) {
		super();
		this.channelId = channelId;
		this.channelDescription = channelDescription;
		this.channelsLevel = channelsLevel;
		this.channelDefaultUom = channelDefaultUom;
		this.itemChannels = itemChannels;
	}

	public ChannelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelDescription() {
		return channelDescription;
	}

	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	public Integer getChannelsLevel() {
		return channelsLevel;
	}

	public void setChannelsLevel(Integer channelsLevel) {
		this.channelsLevel = channelsLevel;
	}

	public Channel.ChannelUOM getChannelDefaultUom() {
		return channelDefaultUom;
	}

	public void setChannelDefaultUom(Channel.ChannelUOM channelDefaultUom) {
		this.channelDefaultUom = channelDefaultUom;
	}

	public List<ItemsChannelsDTO> getItemChannels() {
		return itemChannels;
	}

	public void setItemChannels(List<ItemsChannelsDTO> itemChannels) {
		this.itemChannels = itemChannels;
	}
    
    
	
    
    
    
    
    
   

    
    

}
