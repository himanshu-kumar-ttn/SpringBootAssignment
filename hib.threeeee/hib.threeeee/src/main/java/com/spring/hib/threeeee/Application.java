package com.spring.hib.threeeee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// cm is author c is book
// Author can have multiple books -> one to many
// Teacher                  course -> Many books can be written by single author (Many to one)

// Many to Many we have Author and Book class
// There is author table and there is book table there has to be thir table that
will represent
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//Q -> Which method on the session object can be used to remove an object from the cache?
evict() is used to remove a particular object from cache associated with session

//Q -> What does @transactional annotation do?
//
//    It is considered to be a set of actions that allows to modify or make changes in a database.
//        Whenever a Transaction happens, and in case of any failure in between the course of an action,then the entire transaction has to be rolled off.
//        In other words, a transaction must be committed only after the successful execution of the entire actions. Otherwise,
//        the transaction should be rolled off in case of any exceptions.

// when you call the data for author do we need to fetch data of book to if not we
// can apply lazy fetch if we want the book data to on fetching the author data we can
// use eager fetching