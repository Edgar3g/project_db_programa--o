package aej.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connect() {
        try {
            String user = System.getenv("USER");
            String pass = System.getenv("PASSWORD");
            String server = System.getenv("URL");

            if (user == null || pass == null || server == null) {
                throw new RuntimeException("Erro ao carregar variáveis de ambiente");
            }

            return DriverManager.getConnection(server, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

}
