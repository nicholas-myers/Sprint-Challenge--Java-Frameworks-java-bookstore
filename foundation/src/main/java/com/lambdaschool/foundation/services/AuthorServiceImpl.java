package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
   @Autowired
   private AuthorRepository authrepos;

   @Transactional
   @Override
   public Author save(Author author)
   {
      Author newAuthor = new Author();

      newAuthor.setAuthorid(author.getAuthorid());
      newAuthor.setFirstname(author.getFirstname());
      newAuthor.setLastname(author.getLastname());

      newAuthor.getWrotes().clear();

      return authrepos.save(newAuthor);
   }
}
