import javafx.scene.text.Text;
import ola.classes.Author;
import ola.classes.Book;
import ola.controllers.ReaderHomePageController;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void secondTest(){
        ArrayList<Book> list = new ArrayList<>();
        Book b1 = new Book("Reader");
        Book b2 = new Book("Home");
        Book b3 = new Book("Good");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        ReaderHomePageController tester = new ReaderHomePageController();
        assertEquals(true, tester.containsBook(list, "Good"), "List must contain Good");

    }

    @Test
    public void thirdTest(){
        Book b = new Book("Vatican", new Author("Antoine"), new Text("this is a good book"));

        assertEquals("Vatican", b.getTitle(), "Title should be Vatican");
        assertEquals("Antoine", b.getAuthor().getName(), "Author's name should be Antoine");
        assertEquals("this is a good book", b.getDescription(), "Description should be >this is a good book<");
    }

    @Test
    public void fourthTest(){
        Author a = new Author("Helen");
        a.addBook(new Book("Flower"));

        assertEquals(true, a.getBooks().contains(new Book("Flower")), "Author should have a book >Flower<");

    }

    public static void main(String[] args) {
        MyTest test = new MyTest();
        test.secondTest();
        test.thirdTest();
        test.fourthTest();
    }
}