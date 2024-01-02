package q1;

public class Product {

	private String name;
	private double price;
	public static final double VAT = 0.17;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Product() {
		this.name = null;
		this.price = 0;
	}
	
	public double getPriceIncludingVat() {
		return this.price - this.price*Product.VAT;
	}
	
	public void display() {
		System.out.println(this.name + " -> " + this.price + " NIS"); 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static void main(String[] args) {
		Product chair = new Product("Chair",19.99);
		chair.display();
		System.out.println(chair.getPriceIncludingVat());

	}

}
