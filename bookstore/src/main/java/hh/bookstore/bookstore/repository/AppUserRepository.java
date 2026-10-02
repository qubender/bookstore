package hh.bookstore.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import hh.bookstore.bookstore.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
