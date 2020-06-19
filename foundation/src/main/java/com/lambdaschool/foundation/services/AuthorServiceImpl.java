package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
   @Autowired
   private AuthorRepository authrepos;

   @Override
   public List<Author> findAllAuthors()
   {
      List<Author> list = new ArrayList<>();

      authrepos.findAll()
              .iterator()
              .forEachRemaining(list::add);
      return list;
   }

   @Transactional
   @Override
   public Author save(Author author)
   {
      Author newAuthor = new Author();

      newAuthor.setAuthorid(author.getAuthorid());
      newAuthor.setFirstname(author.getFirstname());
      newAuthor.setLastname(author.getLastname());

      newAuthor.setWrotes(author.getWrotes());

      return authrepos.save(newAuthor);
   }
}
