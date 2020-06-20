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
   @JoinColumn(name = "sectionid")
   @JsonIgnoreProperties(value = "books")
   private Section section;

   @OneToMany(mappedBy = "book",
   cascade = CascadeType.ALL)
   private List<Wrote> wrotes = new ArrayList<>();

   public Book() {}

   public Book(String booktitle, String ISBN, int copyrightdate, Section section)
   {
      this.booktitle = booktitle;
      this.ISBN = ISBN;
      this.copyrightdate = copyrightdate;
      this.section = section;
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

   public Section getSection()
   {
      return section;
   }

   public void setSection(Section section)
   {
      this.section = section;
   }

   public List<Wrote> getWrotes()
   {
      return wrotes;
   }

   public void setWrotes(List<Wrote> wrotes)
   {
      this.wrotes = wrotes;
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
