package kieroth29.tictactoe.core;

import kieroth29.tictactoe.ui.UI;

public class Player {
	
	private String name;
	private Board board;
	private char symbol;
	
	public Player(String name, Board board, char symbol) {
		this.name = name;
		this.board = board;
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbolInput) {
		symbol = symbolInput;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String nameInput) {
		name = nameInput;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board boardInput) {
		board = boardInput;
	}
	
	private Move inputMove() throws InvalidMoveException {
		int moveLine, moveColumn;
		
		try {
			String i = UI.readInput("Linha: ");
			moveLine = Integer.parseInt(i);
	
			String j = UI.readInput("Coluna: ");
			moveColumn = Integer.parseInt(j);
		} catch(Exception e) {
			throw new InvalidMoveException("Jogada inválida.");
		}
		
		return new Move(moveLine, moveColumn);
	}
	
	public Boolean play() throws InvalidMoveException{
		UI.printText("Vez de " + this.name + ":");
		Move move = inputMove();
		
		return board.play(this, move);
	}
	
}
