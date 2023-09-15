package grade_controll;

import java.util.Scanner;

public class GradeControll {

  public static void main(String[] args) {
    System.out.println("Enter the user grade:");
    int grade = getGrade();

    if (grade < 7) {
      System.out.println("This student has flunked");
    } else {
      System.out.println("This student have2 passed");
    }
  }

  static int getGrade() {
    Scanner teclado = new Scanner(System.in);
    String input = teclado.nextLine();
    teclado.close();
    return Integer.parseInt(input);
  }

}
