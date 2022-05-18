
package GioTarefas;

import java.sql.Connection;
import util.ConnectionFactory;


public class Main {

    public static void main(String[] args) {
        Connection c = ConnectionFactory.getConnection();
        
        ConnectionFactory.closeConnection(c);
    }
    
}
