package com.endava.graphqldemo.resolver;

import com.endava.graphqldemo.model.Author;
import com.endava.graphqldemo.model.Book;
import com.endava.graphqldemo.repository.AuthorRepository;
import com.endava.graphqldemo.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BookResolver(AuthorRepository authorRepository,
      BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public Author author(Book book) {
    return this.authorRepository.findById(book.getAuthor().getId())
        .orElseThrow(() -> new RuntimeException("Author not found by ID!"));
  }

}
