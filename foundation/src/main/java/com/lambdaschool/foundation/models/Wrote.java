package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "wrote", uniqueConstraints = {@UniqueConstraint(columnNames = {"authorid", "bookid"})})
public class Wrote extends Auditable implements Serializable
{
   @Id
   @ManyToOne
   @JoinColumn(name = "authorid")
   @JsonIgnoreProperties(value = "wrotes",
           allowSetters = true)
   private Author author;

   @Id
   @ManyToOne
   @JoinColumn(name = "bookid")
   @JsonIgnoreProperties(value = "wrotes",
           allowSetters = true)
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

   @Override
   public String toString()
   {
      return "Wrote{" +
              "author=" + author +
              ", book=" + book +
              '}';
   }
}
