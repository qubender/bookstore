package hh.bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.bookstore.domain.Book;
import hh.bookstore.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	CommandLineRunner demo(BookRepository repository) {
		return args -> {
			repository.save(new Book("kirja", "kirjailija", 2026, 654894, 69));
			repository.save(new Book("tokakirja", "tokakirjailija", 1900, 549898, 56));
			System.out.println("Kirja tallennettu");
		};
	}

}
