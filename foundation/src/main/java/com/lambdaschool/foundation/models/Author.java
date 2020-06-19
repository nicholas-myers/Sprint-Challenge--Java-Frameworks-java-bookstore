package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "authors")
public class Author extends Auditable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long authorid;

   @NotNull
   @Column(nullable = false,
           unique = true)
   private String firstname;

   @NotNull
   @Column(nullable = false,
           unique = true)
   private String lastname;

   @OneToMany(mappedBy = "author",
   cascade = CascadeType.ALL)
   @JsonIgnoreProperties("author")
   private List<Wrote> wrotes = new ArrayList<>();

   public Author(){}

   public Author(String firstname,String lastname)
   {
      this.lastname = firstname;
      this.firstname = lastname;
   }

   public long getAuthorid()
   {
      return authorid;
   }

   public void setAuthorid(long authorid)
   {
      this.authorid = authorid;
   }

   public String getLastname()
   {
      return lastname;
   }

   public void setLastname(String lastname)
   {
      this.lastname = lastname;
   }

   public String getFirstname()
   {
      return firstname;
   }

   public void setFirstname(String firstname)
   {
      this.firstname = firstname;
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
      return "Author{" +
              "authorid=" + authorid +
              ", lastname='" + lastname + '\'' +
              ", firstname='" + firstname + '\'' +
              '}';
   }
}
