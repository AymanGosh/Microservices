package q3;

public class Book<T>{
	private String bookName,store;
	private double price,pages;
	private T cover;
	
	public Book(String bookName, String store, double price, double pages, T cover) {
		this.bookName = bookName;
		this.store = store;
		this.price = price;
		this.pages = pages;
		this.cover = cover;
	}

	public Book() {
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPages() {
		return pages;
	}

	public void setPages(double pages) {
		this.pages = pages;
	}

	public T getCover() {
		return cover;
	}

	public void setCover(T cover) {
		this.cover = cover;
	}
	public void display() {
		System.out.println(bookName+" "+store+" "+price+" "+pages+" "+cover);
	}
	public static void main(String[] args) {
		
		Book<String> stringBook = new Book<>("Harry Potter","Amazon",9.9,500,"harry potter and the philosopher's stone, by J.K. Rowling");
		Book<Integer> integerBook = new Book<>("The lord of the ring","Ali-baba",0.99,20,1984);
		
		stringBook.display();
		integerBook.display();
		
	}

}
