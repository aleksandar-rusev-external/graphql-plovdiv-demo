package com.endava.graphqldemo.repository;

import com.endava.graphqldemo.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllByAuthorId(Long authorId);

  long countAllByAuthorId(Long authorId);
}
