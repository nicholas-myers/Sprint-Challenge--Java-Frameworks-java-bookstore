package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.FoundationApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FoundationApplication.class)
class BookServiceImplTest
{

   @Autowired
   private BookService bookService;

   @Before
   public void setUp() throws Exception
   {
      MockitoAnnotations.initMocks(this);
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void findAllBooks()
   {
      assertEquals(5, bookService.findAllBooks().size());
   }

   @Test
   void save()
   {
   }

   @Test
   void deleteBook()
   {
      bookService.deleteBook(80);
      assertEquals(4, bookService.findAllBooks().size());
   }
}