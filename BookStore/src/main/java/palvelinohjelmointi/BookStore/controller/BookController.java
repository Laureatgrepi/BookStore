package palvelinohjelmointi.BookStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.BookStore.domain.Book;
import palvelinohjelmointi.BookStore.domain.BookRepository;
import palvelinohjelmointi.BookStore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/index")
	public String bookStore() {
		return "indexPage";
	}

	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("booklist", bookRepository.findAll());
		return "booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";

	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());

		return "editBook";

	}

	@GetMapping("/create")
	public String createBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "createBook";
	}

	@PostMapping("/save")
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) bookRepository.findAll();
	}
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookById(@PathVariable("id") Long bookId){
		return bookRepository.findById(bookId);
		
	}
}
