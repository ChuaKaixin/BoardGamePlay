package com.weekend.model;

public class Move {
	private int[] from;
	private int[] to;
	public int[] getFrom() {
		return from;
	}
	public void setFrom(int[] from) {
		this.from = from;
	}
	public int[] getTo() {
		return to;
	}
	public void setTo(int[] to) {
		this.to = to;
	}
	
	public Move(int[]from, int[]to) {
		this.from = from;
		this.to = to;
	}
}
