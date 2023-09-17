package shopping_cart;

import shopping_cart.products.Product;
import shopping_cart.products.Purchase;
import shopping_cart.products.Shelf;
import shopping_cart.screen.Screen;

import java.util.Objects;
import java.util.Scanner;

public class App {

	Purchase shopping_cart;
	Shelf avaible_products;
	Scanner terminal;

	public App() {
		this.shopping_cart = new Purchase();
		this.avaible_products = new Shelf();
		this.terminal = new Scanner(System.in);

		Screen.printHeader("Welcome to our shop!");
		startLoop();
		shopping_cart.buy();
	}

	public void startLoop(){
		boolean adding_products = true;
		while (adding_products){
			addProduct();
			if(!repeatLoop()){
				adding_products = false;
			}
		}
	}

	private void addProduct(){
		avaible_products.printItems();
		Screen.print("What product do you want to add to your shopping cart?");
		int option = Integer.parseInt(terminal.nextLine());
		Product chose_product = avaible_products.getProductByPosition(option);
		if(chose_product != null){
			shopping_cart.addProduct(chose_product);
		} else {
			Screen.print("You may have passed a wrong product number! your product wasn't added to cart!");
		}
	}

	private boolean repeatLoop(){
		while(true){
			Screen.print("Do you want to add other product? (s/n)");
			String option = terminal.nextLine();
			if(Objects.equals(option, "s")){
				return  true;
			}
			if(Objects.equals(option, "n")){
				return false;
			}
		}
	}


}
