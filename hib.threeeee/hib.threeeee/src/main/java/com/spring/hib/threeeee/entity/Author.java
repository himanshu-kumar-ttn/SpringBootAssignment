package com.spring.hib.threeeee.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "book")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;

    @Embedded
    private AuthorAddress authorAddress;

   // subject one

//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    private Set<Subject> subjectSet = new HashSet<>();

//    i > one to one
    @OneToOne(
            cascade = CascadeType.ALL, // whatever the operation are there everything will happen there
            fetch = FetchType.LAZY
    )

//     after doing this the bookId will be saved in the author table acting as a foreign key between two table
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Book book;


    //ii one to many uni directional
    // one author can write multiple books
    @OneToMany(
            cascade = CascadeType.ALL
    )
    // for author table which particular books author has written that particular relationship should have
    // book table will have extra column (foreign key) that will define this book is written by which author
    // now in the book table new author id will be added there
    @JoinColumn(
            name ="author_id",
            referencedColumnName = "authorId"
    )
    private List<Book> books;


//    iii -> Many to One recommended


    // Persit 3 subjects
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Subject> subjects = new ArrayList<>();



}

