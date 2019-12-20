package com.weekend.controller;

import java.net.URI;
import java.net.URISyntaxException;

import com.weekend.model.Board;
import com.weekend.model.Move;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
	

    public static boolean gameOver = false;
    public static Board boardgame = null;

	public static ObjectMapper mapper = new ObjectMapper();
	public static final String MYTURN = "current";
	
	public static int count = 0;
	public static void main(String[] args) {
		try {
            // open websocket
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://websocketaddress"));

            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                	try {
	                    System.out.println(message);
	                    boardgame = boardParser(message);
	
	                	if(boardgame!=null) {
		                    //System.out.println("Whose turn: "+ boardgame.getPlayers().getKaixin_chua());
		                    //System.out.println("is it my turn: "+ boardgame.getPlayers().getKaixin_chua().equalsIgnoreCase(MYTURN));
	                		if(boardgame.getPlayers().getKaixin_chua().equalsIgnoreCase(MYTURN)) {
	                            System.out.println("my turn");
	    	                    Move bestMove = Player.play(boardgame.getBoard());
	    	                    if(bestMove != null) {
		    	                    System.out.println("move from" + bestMove.getFrom()[0] + "," + bestMove.getFrom()[1] + 
		    	                    		" to " + bestMove.getTo()[0] + "," + bestMove.getTo()[1]);
		    	                    clientEndPoint.sendMessage(mapper.writeValueAsString(bestMove));
	    	                    } else {

		    	                    clientEndPoint.sendMessage("{\"done\":true}");
		    	                    System.err.println("DONE WITH MY TURN");
	    	                    }
	                        } else {
	                        	System.out.println("NOT MY TURN");
	    	                    
	                        }
	                		count ++;
	                	}
                	} catch (Exception e) {

                        System.err.println("Some exception!!!: " + e.getMessage());
                	}
                    
                }
            });

            
            while(!gameOver) {
            	Thread.sleep(5000);
                System.out.println("awake");
            }
            // send message to websocket
//            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Some other exception: " + ex.getMessage());
        } 
	}
	
	private static Board boardParser(String message) {
		try {
		//ObjectMapper mapper = new ObjectMapper();
		Board board = mapper.readValue(message, Board.class);
		return board;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	} 

}
