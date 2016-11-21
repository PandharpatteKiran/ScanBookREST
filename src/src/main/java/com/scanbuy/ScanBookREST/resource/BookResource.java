package com.scanbuy.ScanBookREST.resource;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scanbuy.ScanBookREST.model.Book;
import com.scanbuy.ScanBookREST.service.BookService;

/**
 * Kiran Pandharpatte
 */

@EnableAutoConfiguration
@Controller
@RequestMapping("ScanBook/books")
public class BookResource {

	BookService bookService = new BookService();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getMessage() {
		return bookService.getAllBooks();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book updateBook(@PathVariable("barcode") long barcode, @RequestBody Book book) {
		book.setBarcode(barcode);
		return bookService.updateBook(book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void removeBook(@PathVariable("barcode") long barcode) {
		bookService.removeBook(barcode);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book getBook(@PathVariable("barcode") long barcode) {
		return bookService.getBook(barcode);
	}

}
