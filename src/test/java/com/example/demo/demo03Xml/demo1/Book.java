package com.example.demo.demo03Xml.demo1;

import java.util.List;

public class Book {
    public long id;
    public String name;
    public String author;
    public String isbn;
    public List<String> tags;
    public String pubDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", tags=" + tags +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}