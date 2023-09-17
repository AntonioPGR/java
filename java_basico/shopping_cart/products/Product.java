package shopping_cart.products;

public class Product implements Comparable<Product> {
	float price;
	String name;

	public Product(float price, String name) {
		this.price = price;
		this.name = name;
	}


	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Product other_product) {
		return Float.compare(price, other_product.price);
	}
}
