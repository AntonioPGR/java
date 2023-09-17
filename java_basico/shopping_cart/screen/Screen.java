package shopping_cart.screen;

public class Screen {

    public static void printLine(){
        for(int i = 0; i < 30; i++){
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public static void printLine(int line_width){
        for(int i = 0; i < line_width; i++){
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static void jumpLine(){
        print("");
    }

    public static void printHeader(String message){
        printLine();
        jumpLine();
        print(message);
        jumpLine();
        printLine();
    }
}
