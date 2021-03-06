package ola.classes;

import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

public class Book {
    private String title;
    private Author author;
    private Image cover;
    private Text description;
    private File file;
    private ArrayList<String> comments = new ArrayList<>();

    public void addComment(String c){
        comments.add(c);
    }

    public void deleteComment(String c){
        comments.remove(c);
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public Book(String title) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
    }
    public Book(String title, Author author) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
    }
    public Book(String title, Author author, Image cover) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        setCover(cover);
    }
    public Book(String title, Author author, Text description) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        this.description=description;
    }
    public Book(String title, Author author, File file) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        this.file=file;
    }
    public Book(String title, Author author, Image cover, Text description) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        setCover(cover);
        this.description=description;
    }
    public Book(String title, Author author, Image cover, File file) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        setCover(cover);
        this.file=file;
    }
    public Book(String title, Author author, Text description, File file) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        this.description=description;
        this.file=file;
    }
    public Book(String title, Author author, Image cover, Text description, File file) {
        addComment("Author: Welcome to this Book! Please be nice :)");
        this.title = title;
        this.author=author;
        setCover(cover);
        this.description=description;
        this.file=file;
    }
    public Book(){
        addComment("Author: Welcome to this Book! Please be nice :)");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean equals(Object b){
        if(b instanceof Book)
        {
            Book book=(Book)b;
            return (book.title.equals(title));
        }
        return false;
    }
}
