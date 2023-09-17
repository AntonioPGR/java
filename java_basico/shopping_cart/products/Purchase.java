package shopping_cart.products;

import shopping_cart.screen.Displayable;
import shopping_cart.screen.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Purchase implements Displayable {
	List<Product> shopping_cart = new ArrayList<>();

	public void addProduct(Product product){
		shopping_cart.add(product);
		Collections.sort(shopping_cart);
	}

	public void buy(){
		printItems();
		printTotal();
	}

	@Override
	public void printItems() {
		Screen.printLine();

		AtomicInteger iterator = new AtomicInteger(0);
		List<Product> already_displayed = new ArrayList<>();
		shopping_cart.forEach((product) -> {
			iterator.incrementAndGet();
			if(!already_displayed.contains(product)){
				already_displayed.add(product);
				int quantity = Collections.frequency(shopping_cart, product);
				float total_price = product.price * quantity;
				Screen.print(iterator + "- " + product.name + " " + quantity + "x$" + product.price + " = " + total_price);
			}
		});

		Screen.printLine();
	}

	public void printTotal(){
		AtomicReference<Float> total = new AtomicReference<>((float) 0);
		shopping_cart.forEach((product) -> {
			total.updateAndGet(v -> v + product.price);
		});
		Screen.printLine();
		Screen.print("Total: $" + total);
		Screen.printLine();
	}

}
