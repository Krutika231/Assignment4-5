package Books;

import java.util.ArrayList;

public class Author {

    private String AuthorName;

    private ArrayList<Book> book;

    public Author(String name,ArrayList<Book> book) {
        this.AuthorName = name;
        this.book =book;
    }
    public String getName() {

        return AuthorName;
    }

    public ArrayList<Book> getBook() {
        return book;
    }
}
