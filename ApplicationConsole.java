package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ApplicationConsole{
	
	public ApplicationConsole() {
	}
	
	public BufferedReader consoleReader;

	public PrintWriter consoleWriter;
	
	//Funzione main di gestione varie console
	//Ho implementato solo la consoleAddettoFornitura
	//Nel diagramma dei package ho comunque inserito le altre console
	
	public static void main(String args[]) throws IOException, Exception {		// L'eccezione IOException riguarda una classe di eccezioni prodotte da operazioni di I/O mal riuscite

		final boolean AUTO_FLUSH_FLAG = true;
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter consoleWriter = new PrintWriter(System.out, AUTO_FLUSH_FLAG);
		ConsoleAddettoFornitura consAddForn = new ConsoleAddettoFornitura(consoleReader, consoleWriter);
		consAddForn.showConsoleAddettoFornitura();

	}
}