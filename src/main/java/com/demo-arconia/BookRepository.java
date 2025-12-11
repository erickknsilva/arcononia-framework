package com.teste.demo;

import org.springframework.data.repository.ListCrudRepository;

public interface BookRepository extends ListCrudRepository<com.teste.demo.Book, Long> {
}
