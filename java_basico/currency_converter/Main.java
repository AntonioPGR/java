package currency_converter;

import currency_converter.Exception.APIException;
import currency_converter.currency.Currency;
import currency_converter.screen.Screen;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner terminal = new Scanner(System.in);
		Screen.printHeader("Welcome to Internation Currency Converter");
		Screen.jumpLine();

		Screen.print("De qual moeda você deseja converter? ");
		String from = terminal.next().toUpperCase();

		Screen.print("Para qual moeda você deseja converter? ");
		String to = terminal.next().toUpperCase();

		Screen.print("Qual o valor em " + from + " que você deseja converter para " + to + "? ");
		float amount = Float.parseFloat(terminal.next());

		Currency currency = new Currency(from, to);
		try{
			currency.convert(amount);
		} catch (APIException apiException){
			System.out.println("Não foi possivel se conectar na api");
		}
	}
}
