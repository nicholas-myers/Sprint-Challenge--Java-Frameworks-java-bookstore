package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Auditable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long bookid;

   @NotNull
   @Column(nullable = false,
           unique = true)
   private String booktitle;

   @NotNull
   @Column(nullable = false,
           unique = true)
   private String ISBN;

   private int copyrightdate;

   @ManyToOne
   @JoinColumn(name = "sectionid", nullable = false)
   @JsonIgnoreProperties(value = "section")
   private Section section;

   public Book(@NotNull String booktitle, @NotNull String ISBN, int copyrightdate)
   {
      this.booktitle = booktitle;
      this.ISBN = ISBN;
      this.copyrightdate = copyrightdate;
   }

   public long getBookid()
   {
      return bookid;
   }

   public void setBookid(long bookid)
   {
      this.bookid = bookid;
   }

   public String getBooktitle()
   {
      return booktitle;
   }

   public void setBooktitle(String booktitle)
   {
      this.booktitle = booktitle;
   }

   public String getISBN()
   {
      return ISBN;
   }

   public void setISBN(String ISBN)
   {
      this.ISBN = ISBN;
   }

   public int getCopyrightdate()
   {
      return copyrightdate;
   }

   public void setCopyrightdate(int copyrightdate)
   {
      this.copyrightdate = copyrightdate;
   }

   @Override
   public String toString()
   {
      return "Book{" +
              "bookid=" + bookid +
              ", booktitle='" + booktitle + '\'' +
              ", ISBN='" + ISBN + '\'' +
              ", copyrightdate=" + copyrightdate +
              '}';
   }
}
