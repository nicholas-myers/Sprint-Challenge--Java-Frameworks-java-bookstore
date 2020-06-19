package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
   @Autowired
   private BookRepository bookrepos;

   @Override
   public List<Book> findAllBooks()
   {
      List<Book> list = new ArrayList<>();
      /*
       * findAll returns an iterator set.
       * iterate over the iterator set and add each element to an array list.
       */
      bookrepos.findAll()
              .iterator()
              .forEachRemaining(list::add);
      return list;
   }

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

   @Transactional
   @Override
   public void deleteBook(long bookid)
   {
      bookrepos.findById(bookid)
              .orElseThrow(() -> new ResourceNotFoundException("User id " + bookid + " not found!"));

      bookrepos.deleteById(bookid);
   }
}
