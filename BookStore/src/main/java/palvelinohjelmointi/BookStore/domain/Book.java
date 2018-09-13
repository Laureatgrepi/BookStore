package palvelinohjelmointi.BookStore.domain;

import javax.persistence.Entity;

@Entity
public class Book {
		private String title, author, isbn ;
		private double price;
		private int year;
		
		
		public Book() {
		}


		public Book(String title) {
			super();
			this.title = title;
		}
		
		

}