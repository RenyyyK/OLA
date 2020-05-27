import ola.controllers.BookPageController;
import org.junit.Assert;
import org.junit.Test;

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
    public static void main(String []args)
    {
        MyTest test =new MyTest();
        test.chechSearchUser();
        test.checkSearchAuthor();
        test.checkSearchBook();
    }
}