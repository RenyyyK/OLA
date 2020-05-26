import ola.controllers.BookPageController;
import org.junit.Assert;
import org.junit.Test;

public class MyTest {
    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void secondTest(){
        BookPageController page;


        /*int port = 8818;
        Connection con;
        String url = "jdbc:mysql://localhost:3306/travel-map";
        con= (Connection) DriverManager.getConnection(url, "root", "TravelMap");
        Server server = new Server(port,con);
        server.start();

        Client client = new Client( "localhost", 8818,con);

        client.addUserStatusListener((new UserStatusListener() {
            @Override
            public void online(String username) {
                System.out.println("ONLINE: "+username);
            }

            @Override
            public void offline(String username) {
                System.out.println("OFFLINE: "+username);
            }
        }));
        client.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(String from, String text) {
                System.out.println("Message from "+from+" --> "+text);
            }
        });
        if( !client.connect()){
            System.err.println("Connect failed");
        } else {
            System.out.println("Connect successful");
            if( client.login("guest","password") ) {
                System.out.println("Login successful");
                client.msgSimple("jim", "Hei Salut! Sunt guest!");
            }
            else System.err.println("Login failed");
        }

        System.out.println("gata");
        client.disconnect();

    }

    @Test
    public void test1() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/travel-map";
        Connection con = (Connection) DriverManager.getConnection(url, "root", "TravelMap");
        ResultSet transportData = (new Transport(con,1)).getAllData();

        System.out.println("Type: "+transportData.getString("type"));
        System.out.println("Max tickets: "+transportData.getInt("max_tickets"));
        System.out.println("Reserved tickets: "+transportData.getInt("taken_tickets"));
        System.out.println("From: "+transportData.getString("departure_city"));
        System.out.println("To: "+transportData.getString("destination_city"));
        System.out.println("Departure date, hour: "+transportData.getTimestamp("departure"));
        System.out.println("Arrival date, hour: "+transportData.getTimestamp("arrival"));
        System.out.println("Price: "+transportData.getDouble("price"));*/

    }
}