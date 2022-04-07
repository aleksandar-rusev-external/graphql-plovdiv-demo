package com.endava.graphqldemo.repository;

import com.endava.graphqldemo.model.Author;
import com.endava.graphqldemo.model.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

  Optional<Author> findByBooksContains(Book book);
}
