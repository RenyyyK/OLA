package org.loose.fis.registration.example.classes;

import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

public class Book {
    private String Title;
    private Author author;
    private Image cover;
    private Text description;
    private File file;
    private ArrayList<String> comments;

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

    public Book(String title, Image cover) {
        Title = title;
        setCover(cover);
    }

    public Book(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
}
