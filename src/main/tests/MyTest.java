import javafx.scene.text.Text;
import ola.classes.Author;
import ola.classes.Book;
import ola.controllers.ReaderHomePageController;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest extends TestCase{

    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void chechSearchUser() {
        User usera = new User("a", "a", "Author", "a");
        User userr = new User("a", "a", "Reader");
        Assert.assertTrue(usera.equals(userr));
    }

    @Test
    public void checkSearchBook() {
        Book book1=new Book("b1", "a");
        Book book2=new Book("b2", "a");
        Assert.assertTrue(book11.equlas(book2));
    }

    @Test
    public void checkSearchAuthor() {
        Author author1=new Author("a");
        Author author2=new Author("b");
        Assert.assertTrue(author1.equals(author2));
    }
        
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
        test.chechSearchUser();
        test.checkSearchAuthor();
        test.checkSearchBook();
    }
}