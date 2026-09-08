package hh.bookstore.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import hh.bookstore.bookstore.domain.Book;

public interface  BookRepository extends CrudRepository<Book, Long>{

}
