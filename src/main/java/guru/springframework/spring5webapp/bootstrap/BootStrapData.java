package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherReposirtory) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherReposirtory;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher1 = new Publisher("Publisher1", "address1", "state1", "city1", "122016"); 
		publisherRepository.save(publisher1);
		
		Author eric = new Author("Eric", "James");
		Book book1 = new Book("Book1", "1731");
		book1.setPublisher(publisher1);
		publisher1.getBooks().add(book1);
		
		authorRepository.save(eric);
		bookRepository.save(book1);
		publisherRepository.save(publisher1);
		
		Author thomas = new Author("Thomas", "Cook");
		Book book2 = new Book("Book2", "98731");
		book2.setPublisher(publisher1);
		publisher1.getBooks().add(book2);
		
		
		authorRepository.save(thomas);
		bookRepository.save(book2);
		publisherRepository.save(publisher1);
		
		
		System.out.println("All the data saved in the repositories!!");
		System.out.println("No. of Authors: "+authorRepository.count());
		System.out.println("No. of Books: "+ bookRepository.count());
		System.out.println("No. of Publishers: "+ publisherRepository.count());
		
		System.out.println(
				"Books for " + publisher1.getName() + " :" + publisher1.getBooks().size());
		
	}

}
