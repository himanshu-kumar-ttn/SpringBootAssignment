package com.spring.hib.threeeee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Many to one relationship between author and book
// there are many books that is written by one author
// a particular author who has written a particular book
// many to one recommended
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private Long bookId;
    private String bookName;

    // implementing bi-directional one to mapping
   // here we cannot define joining column as we already defined in author
    @OneToOne(
          mappedBy = "book"
    )
    private Author author;


    // ii -> Many to one
 // just the represental change from one to many to many to one the structure would remain same
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "authorId"
    )
    private Author author;

}
