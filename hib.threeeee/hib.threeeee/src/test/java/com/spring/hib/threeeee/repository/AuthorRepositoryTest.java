package com.spring.hib.threeeee.repository;

import com.spring.hib.threeeee.entity.Author;
import com.spring.hib.threeeee.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    // Trying to save Author for this author we have to have a book that is already save din the database
    // when we save and we also pass the book and it the book doesnot exist we need to create book as well
//    that can be done by cascading

    // *** One to One uni and bi directional ** //

    @Test
    public void saveAuthor() {

        Book book = Book.builder().bookName("Invisible Man").build();

        Author author =
                Author.builder().name("Himanshu Kumar").book(book).build();
        authorRepository.save(author);
    }

    @Test
    public void printAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        System.out.println(authors);
    }


    // *** One to Many and many to one ** //

    // save a author with the book
    @Test
    public void saveAuthorOne() {

        // now in the book table there will be too book written by one author

        Book bookOne = Book.builder().bookName(" A Tale of Two Cities ").build();
        Book bookTwo = Book.builder().bookName(" A Tale of Two Cities Part2").build();

//        Author author = Author.builder()
//                .name("Rohan Kumar")
//                .book(List.of(bookOne, bookTwo)).
//                build();
//
//        authorRepository.save(author);
    }


}