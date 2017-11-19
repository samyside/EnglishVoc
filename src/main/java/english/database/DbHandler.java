package english.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DbHandler {
    private static final String URL = "jdbc:SQLite:D:/words.db";

    private Connection connection;

    DbHandler() throws SQLException
    {
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(URL);
    }

    List<Words> getAllWords()
    {
        // Statement используется дл того, чтобы выполнить SQL-запрос
        try (Statement statement = this.connection.createStatement())
        {
            List<Words> words = new ArrayList<>();

            // В resultSet хранится результат statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TableWords");

            // Проходим по нашему resultSet и заносим данные в words
            while (resultSet.next())
            {
                words.add(new Words(resultSet.getInt("id"),
                                    resultSet.getString("eng"),
                                    resultSet.getString("rus")));
            }
            return words;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }
}
