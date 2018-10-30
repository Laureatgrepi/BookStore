package palvelinohjelmointi.BookStore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.BookStore.domain.Book;
import palvelinohjelmointi.BookStore.domain.BookRepository;
import palvelinohjelmointi.BookStore.domain.Category;
import palvelinohjelmointi.BookStore.domain.CategoryRepository;
import palvelinohjelmointi.BookStore.domain.User;
import palvelinohjelmointi.BookStore.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepoTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository cateRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//Bookrepon testit
	@Test
	public void findByTitle() {
		List<Book> books = bookRepository.findByTitle("Ihmeelliset seikkailut");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor().equals("Laureat Grepi"));
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Aapiskirja","Matti Mattinen");
		bookRepository.save(book);
		List<Book> books = bookRepository.findByTitle("Aapiskirja");
		assertNotNull(books.get(0).getAuthor());
	}
	
	@Test
	public void deleteBook() {
		Book book = new Book("Esimerkki123", "Kirjailija321");
		bookRepository.save(book);
		List<Book> books = bookRepository.findByTitle("Esimerkki123");
		assertEquals("Kirjailija321", books.get(0).getAuthor());
		
		bookRepository.delete(book);
		List<Book> books1 = bookRepository.findByTitle("Esimerkki123");
		assertThat(books1.isEmpty());
	}
	
	
	//CategoryRepon testit
	@Test
	public void findByCategory() {
		List<Category> categories= cateRepository.findByName("Kauhu");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName().equals("Kauhu"));
	}
	
	@Test
	public void createNewCategory() {
		Category category= new Category("Komedia");
		cateRepository.save(category);
		List<Category> categories = cateRepository.findByName("Komedia");
		assertNotNull(categories.get(0).getName());
	}
	
	@Test
	public void deleteCategory() {
		Category cate = new Category("Esimerkki123");
		cateRepository.save(cate);
		List<Category> categories = cateRepository.findByName("Esimerkki123");
		assertEquals("Esimerkki123", categories.get(0).getName());
		
		cateRepository.delete(cate);
		List<Category> categories1 = cateRepository.findByName("Esimerkki123");
		assertThat(categories1.isEmpty());
	}
	
	//UserRepon testit
	
	@Test
	public void findByUsername() {
		User user = userRepository.findByUsername("user");
		
		assertNotNull(user);
	}
	
	@Test
	public void createNewUser() {
		User user = new User("esimerkki", "$2y$12$U0rhRctSen4ovSGLBNWaSuR9QZzXOrSPwOXOUMacFdqphwEsj1xiy", "USER");
		userRepository.save(user);
		User user1 = userRepository.findByUsername("esimerkki");
		assertNotNull(user1);
	}
	
	@Test
	public void deleteUser() {
		User user = new User("esimerkki", "$2y$12$U0rhRctSen4ovSGLBNWaSuR9QZzXOrSPwOXOUMacFdqphwEsj1xiy", "USER");
		userRepository.save(user);
		User user1 = userRepository.findByUsername("esimerkki");
		assertNotNull(user1);
		
		userRepository.delete(user1);
		assertNull(userRepository.findByUsername(user1.getUsername()));
	}
	
}
