package com.lambdaschool.foundation.models;

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
   private String lastname;

   @NotNull
   @Column(nullable = false,
           unique = true)
   private String firstname;

   @ManyToMany()
   private List<Wrote> wrote = new ArrayList<>();


   public Author(@NotNull String lastname, @NotNull String firstname)
   {
      this.lastname = lastname;
      this.firstname = firstname;
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
