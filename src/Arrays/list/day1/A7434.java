package Arrays.list.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A7434 {



        public static void main(String[] args) {
            List<Book> books = new ArrayList();
            books.add(new Book("War and Peace", "Leo Tolstoy"));
            books.add(new Book("It", "Stephen King"));
            books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
            books.add(new Book("Dune", "Frank Herbert"));
            System.out.println("Before sorting:");

            for(Book book : books) {
                System.out.println(book);
            }

            Collections.sort(books, new Comparator<Book>() {
                public int compare(Book b1, Book b2) {
                    return Integer.compare(b1.title.length(), b2.title.length());
                }
            });
            System.out.println("\nAfter sorting by title length:");

            for(Book book : books) {
                System.out.println(book);
            }

        }

        static class Book {
            String title;
            String author;

            Book(String title, String author) {
                this.title = title;
                this.author = author;
            }

            public String toString() {
                return "\"" + this.title + "\" by " + this.author;
            }
        }
    }


