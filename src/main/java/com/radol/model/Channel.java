package com.radol.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id" , columnDefinition = "INT UNSIGNED")
    private Integer channelId;

    @Column(name = "channel_description", length = 250)
    private String channelDescription;

    @Column(name = "channels_level")
    private Integer channelsLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel_default_uom", nullable = false)
    private ChannelUOM channelDefaultUom;

    public enum ChannelUOM {
        SINGLE,
        PACK,
        BOX,
        CASE,
        PALLET
    }

    @OneToMany(mappedBy = "mappedChannel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemChannel> itemChannels = new ArrayList<>();

	public Channel(Integer channelId, String channelDescription, Integer channelsLevel, ChannelUOM channelDefaultUom,
			List<ItemChannel> itemChannels) {
		super();
		this.channelId = channelId;
		this.channelDescription = channelDescription;
		this.channelsLevel = channelsLevel;
		this.channelDefaultUom = channelDefaultUom;
		this.itemChannels = itemChannels;
	}

	public Channel() {
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

	public ChannelUOM getChannelDefaultUom() {
		return channelDefaultUom;
	}

	public void setChannelDefaultUom(ChannelUOM channelDefaultUom) {
		this.channelDefaultUom = channelDefaultUom;
	}

	public List<ItemChannel> getItemChannels() {
		return itemChannels;
	}

	public void setItemChannels(List<ItemChannel> itemChannels) {
		this.itemChannels = itemChannels;
	}
    

    
    

}
