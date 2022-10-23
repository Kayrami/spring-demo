package kaurami.me.t.springdemo.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}


enum test{
    MERCURY("text"), MASR("text");

    String text;

    test(String text) {
        this.text = text;
    }
}