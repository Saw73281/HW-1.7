package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFilePath = "src/sql/find_max_projects_client.sql";
        List<MaxProjectCountClient> result = new ArrayList<>();

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(Files.readString(Paths.get(sqlFilePath)))) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(new MaxProjectCountClient(rs.getString("NAME"), rs.getInt("PROJECT_COUNT")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        String sqlFilePath = "src/sql/find_longest_project.sql";
        List<LongestProject> result = new ArrayList<>();

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(Files.readString(Paths.get(sqlFilePath)))) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(new LongestProject(rs.getInt("ID"), rs.getInt("MONTH_COUNT")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilePath = "src/sql/find_max_salary_worker.sql";
        List<MaxSalaryWorker> result = new ArrayList<>();

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(Files.readString(Paths.get(sqlFilePath)))) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(new MaxSalaryWorker(rs.getString("NAME"), rs.getInt("SALARY")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        String sqlFilePath = "src/sql/find_youngest_eldest_workers.sql";
        List<YoungestEldestWorker> result = new ArrayList<>();

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(Files.readString(Paths.get(sqlFilePath)))) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(new YoungestEldestWorker(rs.getString("TYPE"), rs.getString("NAME"), rs.getDate("BIRTHDAY")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        String sqlFilePath = "src/sql/print_project_prices.sql";
        List<ProjectPrice> result = new ArrayList<>();

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(Files.readString(Paths.get(sqlFilePath)))) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(new ProjectPrice(rs.getInt("NAME"), rs.getInt("PRICE")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return result;
    }
}
