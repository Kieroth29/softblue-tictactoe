package kieroth29.tictactoe.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {

	public static void printText(String text) {
		System.out.println(text);
	}
	
	public static void printTextWithNoNewLine(String text) {
		System.out.print(text);
	}
	
	public static void printNewLine() {
		System.out.println();
	}
	
	public static void printGameTitle() {
		printText("=================");
		printText("| JOGO DA VELHA |");
		printText("=================");
		printNewLine();
	}
	
	public static String readInput(String text) {
		printTextWithNoNewLine(text);
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler o dado do teclado");
		}
	}
	
}
