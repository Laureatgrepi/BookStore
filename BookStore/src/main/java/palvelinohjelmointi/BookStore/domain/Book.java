package palvelinohjelmointi.BookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String title, author, isbn ;
		private double price;
		private int year;
		
		
		
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name="categoryId")
		private Category category;
		
		
		public Book() {
		}


		public Book(String title, Category category) {
		
			this.title = title;
			this.category = category;
		}


		public Book(String title, String author, Category category) {
			
			this.title = title;
			this.author = author;
			this.category = category;
		}


		public Book(String title, String author) {
			super();
			this.title = title;
			this.author = author;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}


		public String getIsbn() {
			return isbn;
		}


		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}


		public Category getCategory() {
			return category;
		}


		public void setCategory(Category category) {
			this.category = category;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public int getYear() {
			return year;
		}


		public void setYear(int year) {
			this.year = year;
		}


		@Override
		public String toString() {
			if (this.category != null)
				return "Book [id=" + id  + "name: "+this.getTitle() + " category =" + this.getCategory() + "]";		
			else
				return "Book [id=" + id + "name: "+this.getTitle() + "]";
		}
		
		

}