package Banco;

import Banco.Account.Account;
import Banco.Screen.Screen;

import java.io.IOException;
import java.util.Scanner;

public class Banco {
    Account account = new Account();
    boolean is_system_running = true;
    Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        Banco banco = new Banco();

        Screen.printHeader();
        while (banco.is_system_running){
            Screen.printOptions();
            int option = banco.readOption();
            banco.executeOption(option);
            Screen.jumpLine();
        }
        banco.keyboard.close();
    }

    private int readOption(){
        Screen.print("Sua escolha:");
        String option = this.keyboard.nextLine();
        return Integer.parseInt(option);
    }

    private void executeOption(int option){
        switch (option){
            case 1:
                this.account.displayBalance();
                break;
            case 2:
                this.makeDeposit();
                break;
            case 3:
                makeWithdraw();
                break;
            case 4:
                stopApp();
                break;
            default:
                displayNotRegnizedOptionError();
        }
    }
    private void makeDeposit(){
        Screen.print("Digite o valor desejado: ");
        String value = this.keyboard.nextLine();
        this.account.depositValue(Integer.parseInt(value));
        account.displayBalance();
    };
    private void makeWithdraw(){
        Screen.print("Digite o valor desejado:");
        String value = this.keyboard.nextLine();
        this.account.withdrawValue(Integer.parseInt(value));
        account.displayBalance();
    };
    private void stopApp(){
        this.is_system_running = false;
    };
    private void displayNotRegnizedOptionError(){
        Screen.print("Não foi possivel reconhecer essa opção! tente denovo");
    };
}
