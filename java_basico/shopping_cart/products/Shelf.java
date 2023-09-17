package shopping_cart.products;

import shopping_cart.screen.Displayable;
import shopping_cart.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Shelf implements Displayable {
	List<Product> products_avaible = new ArrayList<>();

	public Shelf() {
		this.addProductsToShelf();
	}

	private void addProductsToShelf(){
		products_avaible.add(new Product(799.99f, "Laptop"));
		products_avaible.add(new Product(399.99f, "Smartphone"));
		products_avaible.add(new Product(79.99f, "Headphones"));
		products_avaible.add(new Product(59.99f, "Coffee Maker"));
		products_avaible.add(new Product(129.99f, "Running Shoes"));
		products_avaible.add(new Product(49.99f, "Backpack"));
		products_avaible.add(new Product(199.99f, "Smart Watch"));
		products_avaible.add(new Product(69.99f, "Blender"));
	}

	public Product getProductByPosition(int position){
		if(position > products_avaible.size() || position <= 0){
			return null;
		}
		return  products_avaible.get(position - 1);
	}

	@Override
	public void printItems() {
		Screen.printLine(30);
		AtomicInteger iterator = new AtomicInteger();
		products_avaible.forEach(((product) -> {
			iterator.getAndIncrement();
			Screen.print(iterator +"- " + product.name + ": $" + product.price);
		}));
		Screen.printLine(30);
	}
}
