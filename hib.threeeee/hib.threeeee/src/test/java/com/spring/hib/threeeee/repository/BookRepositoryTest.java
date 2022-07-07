package com.spring.hib.threeeee.repository;

import com.spring.hib.threeeee.entity.Author;
import com.spring.hib.threeeee.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookRepositoryTest {

    private BookRepository bookRepository;

    // on getting book we want author too
    // we have unidirectional one to one mapping till now
    // we dont have author reference in our book

    @Test
    public void printBook(){
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    // Many to one
    @Test
    public void saveBookWithAuthor(){

        Author author = Author.builder().name("Rohan").build();

        Book book = Book.builder().bookName("The tale of city").author(author).build();

        bookRepository.save(book);

    }


}