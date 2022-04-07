package com.endava.graphqldemo.resolver;

import com.endava.graphqldemo.model.Author;
import com.endava.graphqldemo.model.Book;
import com.endava.graphqldemo.repository.AuthorRepository;
import com.endava.graphqldemo.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  @Autowired
  public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  public List<Book> findAllBooksByAuthor(Long authorId) {
    Objects.requireNonNull(authorId);

    return bookRepository.findAllByAuthorId(authorId);
  }

  public long countAuthors() {
    return authorRepository.count();
  }

  public long countBooks(Long authorId) {
    if (Objects.nonNull(authorId)) {
      return bookRepository.countAllByAuthorId(authorId);
    }
    return bookRepository.count();
  }

}
