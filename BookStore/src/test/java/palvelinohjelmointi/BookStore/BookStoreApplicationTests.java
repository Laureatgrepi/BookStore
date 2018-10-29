package palvelinohjelmointi.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.BookStore.controller.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();	
	}

}
