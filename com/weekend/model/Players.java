package com.weekend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Players {
	String kaixin_chua;

	public String getKaixin_chua() {
		return kaixin_chua;
	}

	public void setKaixin_chua(String kaixin_chua) {
		this.kaixin_chua = kaixin_chua;
	}
}
