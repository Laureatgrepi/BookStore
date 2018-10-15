package palvelinohjelmointi.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.BookStore.domain.Book;
import palvelinohjelmointi.BookStore.domain.BookRepository;
import palvelinohjelmointi.BookStore.domain.Category;
import palvelinohjelmointi.BookStore.domain.CategoryRepository;
import palvelinohjelmointi.BookStore.domain.User;
import palvelinohjelmointi.BookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);

	
		}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository cateRepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books and categories");
			repository.save(new Book("Ihmeelliset seikkailut", "Laureat Grepi"));
			repository.save(new Book("Ihmeelliset seikkailut 2", "Laureat Grepi"));
			repository.save(new Book("Kauhujen talo", "Martti Mattinen"));
			cateRepository.save(new Category("Kauhu"));
			cateRepository.save(new Category("Draama"));
			cateRepository.save(new Category("Trilleri"));
			
			User user1 = new User("user", "$2y$12$zn.wm7rFBt2ZV.jMzx27BuWXK4ghC0zNC0tfkbBkIAmrIL3R74e/e", "USER");
			User user2 = new User("admin", "$2y$12$.LIlNICNsx/iK1gmMOVcZeeBdaH3.X1K/cVaP/vdpvBwDKuTOB7RK", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for ( Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
