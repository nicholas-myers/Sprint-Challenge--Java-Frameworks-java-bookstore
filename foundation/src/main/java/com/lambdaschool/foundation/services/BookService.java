package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.models.Book;

import java.util.List;

public interface BookService
{
   List<Book> findAllBooks();
   Book save(Book book);
   void deleteBook(long bookid);
}
