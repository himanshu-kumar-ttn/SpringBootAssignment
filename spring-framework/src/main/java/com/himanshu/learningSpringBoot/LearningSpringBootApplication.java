package com.himanshu.learningSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningSpringBootApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(LearningSpringBootApplication.class, args);
        BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);

        int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 3);
        System.out.println(result);

    }

}
