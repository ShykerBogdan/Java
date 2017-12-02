import controller.Controller;
import model.Model;
import view.View;
//import ResourceBundle;

import java.sql.SQLException;

/**
 * Created by Vladislav on 5/22/2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       new Controller(new View(), new Model()).processUser();
    }
}
