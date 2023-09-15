package Banco.Account;

import Banco.Screen.Screen;

public class Account {
    float balance = 1000;

    public void displayBalance(){
        Screen.printLine();
        Screen.print("O seu saldo atual é: " + this.balance);
        Screen.printLine();
    }
    public void depositValue(float value){
        this.balance += value;
    };
    public void withdrawValue(float value){
        if(value > this.balance){
            Screen.printLine();
            Screen.print("O valor de saque é invalido!!!");
            Screen.printLine();
            return;
        }
        this.balance -= value;
    };
}
