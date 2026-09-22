package hh.bookstore.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import hh.bookstore.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
