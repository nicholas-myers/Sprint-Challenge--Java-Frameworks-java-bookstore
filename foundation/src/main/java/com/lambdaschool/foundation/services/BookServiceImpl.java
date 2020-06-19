package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.repository.AuthorRepository;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
   @Autowired
   private BookRepository bookrepos;

   @Transactional
   @Override
   public Book save(Book book)
   {
      Book newBook = new Book();

      newBook.setBookid(book.getBookid());
      newBook.setBooktitle(book.getBooktitle());
      newBook.setISBN(book.getISBN());
      newBook.setCopyrightdate(book.getCopyrightdate());
      newBook.setSection(book.getSection());

      newBook.getWrotes().clear();

      return bookrepos.save(newBook);
   }
}
