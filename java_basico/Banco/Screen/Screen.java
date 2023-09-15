package Banco.Screen;

public class Screen {
    public static void printLine(){
        System.out.println("-------------------");
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static  void jumpLine(){
        print("");
    }

    public static void printHeader(){
        printLine();
        print("Bem vindo ao Pacheco's Bank");
        printLine();
        jumpLine();
    }

    public static void printOptions(){
        print("Escolha uma opção a baixo para prosseguir: ");
        print("1- Ver saldo");
        print("2- Depositar");
        print("3- Sacar");
        print("4- Sair");
    }
}
