package com.weekend.controller;

import com.weekend.model.Move;
import com.weekend.model.Tile;

public class Player {
	
	public static final String ME = "kaixin_chua";
	public static Move play(Tile[][] tiles) {
		int[]from = new int[2];
		int[]to = new int[2];
		int currentBestMoveStrengthDiff = 0;
		Tile tile = null;
		
		int myCurrentStrength = 0;
		int[] moveCheck = null;
		boolean validMoveExist = false;
		for(int row = 0; row < 4; row++) {
			for (int coln = 0; coln < 4; coln ++) {
				tile = tiles[row][coln];
				System.out.println("tile info:" + tile.getPlayer() + " - " + tile.getStrength());
				if(tile.getPlayer()!=null && tile.getPlayer().equals(ME)) {
					myCurrentStrength = tile.getStrength();
					moveCheck = bestMove(row, coln, tiles, myCurrentStrength);
					if(moveCheck[2]!=0 && moveCheck[2]>currentBestMoveStrengthDiff) {
						from[0] = row;
						from[1] = coln;
						to[0] = moveCheck[0];
						to[1] = moveCheck[1];
						validMoveExist = true;
					}
				}
			}
		}
		if(validMoveExist)
			return new Move(from, to);
		else 
			return null;
	}
	
	public static int[] bestMove(int x, int y, Tile[][] tiles, int currentStrength) {
		int[] bestMove = new int[3];
		Tile attemptedTile = null;
		
		int biggestDiffInStrength = 0;
		
		if(currentStrength > 1) {
			if(x>0) {
				attemptedTile = tiles[x-1][y];
				if(attemptedTile.getPlayer()!=null && !attemptedTile.getPlayer().equals(ME)) {
					if(currentStrength > attemptedTile.getStrength() 
							&& (currentStrength - attemptedTile.getStrength() > biggestDiffInStrength)) {
						biggestDiffInStrength = currentStrength - attemptedTile.getStrength();
						bestMove[0] = x-1;
						bestMove[1] = y;
						bestMove[2] = biggestDiffInStrength;
					}
				}
			}
			if(x<3) {
				attemptedTile = tiles[x+1][y];
				if(attemptedTile.getPlayer()!=null && !attemptedTile.getPlayer().equals(ME)) {
					if(currentStrength > attemptedTile.getStrength() 
							&& (currentStrength - attemptedTile.getStrength() > biggestDiffInStrength)) {
						biggestDiffInStrength = currentStrength - attemptedTile.getStrength();
						bestMove[0] = x+1;
						bestMove[1] = y;
						bestMove[2] = biggestDiffInStrength;
					}
				}
			}
			if(y>0) {
				attemptedTile = tiles[x][y-1];
				if(attemptedTile.getPlayer()!=null && !attemptedTile.getPlayer().equals(ME)) {
					if(currentStrength > attemptedTile.getStrength() 
							&& (currentStrength - attemptedTile.getStrength() > biggestDiffInStrength)) {
						biggestDiffInStrength = currentStrength - attemptedTile.getStrength();
						bestMove[0] = x;
						bestMove[1] = y-1;
						bestMove[2] = biggestDiffInStrength;
					}
				}
			}
			if(y<3) {
				attemptedTile = tiles[x][y+1];
				if(attemptedTile.getPlayer()!=null && !attemptedTile.getPlayer().equals(ME)) {
					if(currentStrength > attemptedTile.getStrength() 
							&& (currentStrength - attemptedTile.getStrength() > biggestDiffInStrength)) {
						biggestDiffInStrength = currentStrength - attemptedTile.getStrength();
						bestMove[0] = x;
						bestMove[1] = y+1;
						bestMove[2] = biggestDiffInStrength;
					}
				}
			}
		}
		return bestMove;
	}
	
	
}
