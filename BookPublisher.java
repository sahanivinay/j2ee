import java.util.*;

//Class for books
class Books{
	String title, author, publisher;
	int price;
	Books(String title, String author, String publisher, int price){
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	void getDetails() {
		System.out.println("Title: "+this.title+" Author: "+this.author+" Publisher: "+this.publisher);
		System.out.println("Price: "+this.price);
	}
	
}

//Class for Pricecompare
class priceCompare implements Comparator<Books>{
	public int compare(Books b1, Books b2) {
		if(b1.price == b2.price) {
			return 0;
		}
		else if(b1.price > b2.price) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

//Class for BookCollection
class BookCollection{
	HashMap<Integer,Books> books;
	ArrayList<Books> sortedBooks;
	ArrayList<Books> priceBasedBooks;
	Books b;
	Scanner sc;
	BookCollection(){
		books = new HashMap<Integer,Books>();
		sortedBooks = new ArrayList<Books>();
		priceBasedBooks = new ArrayList<Books>();
		sc = new Scanner(System.in);
		
		b = new Books("Harry Potter","JK Rowling","Penguin",700);
		books.put(101, b);
		sortedBooks.add(b);
		b = new Books("Two States","Chetan Bhagat","Atlas",250);
		books.put(102, b);
		sortedBooks.add(b);
		b = new Books("The Alchemist","Paul Coelo","Penguin",500);
		books.put(103, b);
		sortedBooks.add(b);
		b = new Books("Three Mistakes of My Life","Chetan Bhagat","Atlas",300);
		books.put(104, b);
		sortedBooks.add(b);

		showBooks();
		sortBooks();
		askAuthor();
		newBooksHolding();
		matchBookTitle();
		findPublisher();
		
		
	}
	void showBooks() {
		System.out.println("Book List");
		for(Map.Entry<Integer, Books> b: this.books.entrySet()) {
			System.out.print("Book Id: "+b.getKey()+" ");
			b.getValue().getDetails();
		}
		System.out.println();
	}
	void sortBooks() {
		System.out.println("Sorted based on price: ");
		Collections.sort(this.sortedBooks,new priceCompare());
		for(Books b : this.sortedBooks) {
			b.getDetails();
		}
		System.out.println();
	}
	void askAuthor() {
		String name;
		System.out.println("Enter author's name in Title Format: ");
		name = this.sc.nextLine();
		for(Books b: this.sortedBooks) {
			if(name.equalsIgnoreCase(b.author)) {
				b.getDetails();
			}
		}
		System.out.println();
	}
	void newBooksHolding(){
		int price;
		System.out.println("Enter a price: ");
		price = this.sc.nextInt();
		System.out.println("Books with price greater than "+price+":");
		for(Books b: this.sortedBooks) {
			if(b.price > price) {
				b.getDetails();
			}
		}
		System.out.println();
	}
	void matchBookTitle() {
		String titlePart;
		System.out.println("Enter the part of title: ");
		titlePart = this.sc.next();
		for(Books b:this.sortedBooks) {
			if(b.title.contains(titlePart)){
				b.getDetails();
			}
		}
		System.out.println();
	}
	void findPublisher() {
		String name,newName;
		System.out.println("Enter the name of Publisher");
		name = this.sc.next();
		for(Books b:this.sortedBooks) {
			if(b.publisher.equalsIgnoreCase(name)) {
				b.getDetails();
			}
		}
		System.out.println("Enter the new Publisher name: ");
		newName = this.sc.next();
		for(Books b: this.sortedBooks) {
			if(b.publisher.equalsIgnoreCase(name))
				b.publisher = newName;
		}
		showBooks();
		System.out.println();
		
	}
}

//MainClass
public class BookPublisher {
	public static void main(String args[]) {
		new BookCollection();
	}

}