package com.endava.graphqldemo.resolver;

import com.endava.graphqldemo.model.Author;
import com.endava.graphqldemo.model.Book;
import com.endava.graphqldemo.repository.AuthorRepository;
import com.endava.graphqldemo.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public AuthorResolver(AuthorRepository authorRepository,
      BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public List<Book> books(Author author) {
    return this.bookRepository.findAllByAuthorId(author.getId());
  }

  public long booksCount(Author author) {
    return this.bookRepository.countAllByAuthorId(author.getId());
  }

}
