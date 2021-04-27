package com.JavaFundamentals.articles2;

public class Article {
    private String title;
    private String content;
    private String author;

    String getTitle() {
        return title;
    }

    String getContent() {
        return content;
    }

    String getAuthor() {
        return author;
    }

    Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", title, content, author);
    }
}
