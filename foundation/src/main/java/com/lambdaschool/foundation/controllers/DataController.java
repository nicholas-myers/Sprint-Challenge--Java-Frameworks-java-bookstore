package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController
{

   @Autowired
   private BookService bookService;

   @PreAuthorize("hasAnyRole('ADMIN')")
   @DeleteMapping(value = "/book/{bookid}")
   public ResponseEntity<?> deleteBookById(@PathVariable long bookid)
   {
      bookService.deleteBook(bookid);
      return new ResponseEntity<>(HttpStatus.OK);
   }
}
