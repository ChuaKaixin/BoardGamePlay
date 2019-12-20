package com.weekend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
	public String getGame_id() {
		return game_id;
	}
	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}
	public int getTurn_number() {
		return turn_number;
	}
	public void setTurn_number(int turn_number) {
		this.turn_number = turn_number;
	}
	public int getMove_number() {
		return move_number;
	}
	public void setMove_number(int move_number) {
		this.move_number = move_number;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public Tile[][] getBoard() {
		return board;
	}
	public void setBoard(Tile[][] board) {
		this.board = board;
	}
	public Players getPlayers() {
		return players;
	}
	public void setPlayers(Players players) {
		this.players = players;
	}
	private String game_id;
	private int turn_number;
	private int move_number;
	private String winner;
	
	private Tile[][] board;
	private Players players;
}
