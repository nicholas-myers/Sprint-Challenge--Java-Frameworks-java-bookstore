package com.lambdaschool.foundation.models;

public class Wrote
{
   private Author author;
   private Book book;

   public Wrote(Author author, Book book)
   {
      this.author = author;
      this.book = book;
   }

   public Author getAuthor()
   {
      return author;
   }

   public void setAuthor(Author author)
   {
      this.author = author;
   }

   public Book getBook()
   {
      return book;
   }

   public void setBook(Book book)
   {
      this.book = book;
   }
}
