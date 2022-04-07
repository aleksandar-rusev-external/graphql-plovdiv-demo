package com.endava.graphqldemo.resolver;

import com.endava.graphqldemo.model.Author;
import com.endava.graphqldemo.model.Book;
import com.endava.graphqldemo.repository.AuthorRepository;
import com.endava.graphqldemo.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  @Autowired
  public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public Author createAuthor(String name, Integer age) {
    Author author = new Author();
    author.setName(name);
    author.setAge(age);
    authorRepository.save(author);
    return author;
  }

  public Book createBook(String title, String description, Long authorId) {
    Book book = new Book();
    book.setAuthor(new Author(authorId));
    book.setTitle(title);
    book.setDescription(description);
    bookRepository.save(book);
    return book;
  }

  public boolean deleteBook(Long id) {
    bookRepository.deleteById(id);
    return true;
  }

  public Book updateBook(Long id, String title, String description) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Not found Book to update!"));
    if (title != null) {
      book.setTitle(title);
    }
    if (description != null) {
      book.setDescription(description);
    }
    bookRepository.save(book);
    return book;
  }

}
