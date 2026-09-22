package hh.bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.bookstore.domain.Book;
import hh.bookstore.bookstore.domain.Category;
import hh.bookstore.bookstore.repository.BookRepository;
import hh.bookstore.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	CommandLineRunner demo(BookRepository repository,  CategoryRepository categoryRepository) {
		return args -> {
			Category fiktio = categoryRepository.save(new Category());
			fiktio.setName("Fiktio");
			categoryRepository.save(fiktio);

			Category tietokirja = categoryRepository.save(new Category());
			tietokirja.setName("Tietokirja");
			categoryRepository.save(tietokirja);

			Book b1 = new Book("kirja", "kirjailija", 2026, 654894, 69);
        	b1.setCategory(fiktio);
        	repository.save(b1);

        	Book b2 = new Book("tokakirja", "tokakirjailija", 1900, 549898, 56);
        	b2.setCategory(tietokirja);
        	repository.save(b2);
		};
	}

}
