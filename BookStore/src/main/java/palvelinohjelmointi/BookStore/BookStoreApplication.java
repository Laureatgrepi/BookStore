package palvelinohjelmointi.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.BookStore.domain.Book;
import palvelinohjelmointi.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);

	
		}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Ihmeelliset seikkailut", "Laureat Grepi"));
			repository.save(new Book("Ihmeelliset seikkailut 2", "Laureat Grepi"));
			repository.save(new Book("Kauhujen talo", "Martti Mattinen"));
			
			log.info("fetch all books");
			for ( Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
