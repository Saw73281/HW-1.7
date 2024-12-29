package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String sqlFilePath = "src/sql/populate_db.sql";
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = Files.readString(Paths.get(sqlFilePath));
            stmt.execute(sql);

            System.out.println("Database populated successfully.");
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Failed to populate database", e);
        }
    }
}
