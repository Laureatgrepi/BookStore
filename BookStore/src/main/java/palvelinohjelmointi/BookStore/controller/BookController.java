package palvelinohjelmointi.BookStore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.BookStore.domain.Book;
import palvelinohjelmointi.BookStore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	


@GetMapping("/index")
	public String bookStore() {
	return "indexPage";
}

@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("booklist", repository.findAll() );
	return "booklist";
}
@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
		
}
@GetMapping("/edit/{id}")
public String editBook(@PathVariable("id") Long bookId, Model model){
	model.addAttribute("book", repository.findById(bookId));
	return "editBook";
	

}
	

@GetMapping("/create")
	public String createBook(Model model) {
		model.addAttribute("book",new Book());
		return "createBook";
}

@PostMapping("/save")
public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
}
}
