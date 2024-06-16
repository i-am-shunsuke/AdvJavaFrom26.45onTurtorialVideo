package ca.georgiancollege.comp1011summer2024thursdays;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://demo-db.cfuqess6qiie.us-east-1.rds.amazonaws.com:3306/comp1011",
                    "admin",
                    "$Deanwinchester1224"
            );

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO Camera (Model, Make, Color) VALUES (?, ?, ?)"
            );

            preparedStatement.setString(1, "Cool");
            preparedStatement.setString(2, "Beans");
            preparedStatement.setString(3, "Hungry");

            preparedStatement.executeUpdate();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Camera");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String model = resultSet.getString("Model");
                String make = resultSet.getString("Make");
                String color = resultSet.getString("Color");

                System.out.println("ID: " + id);
                System.out.println("Model: " + model);
                System.out.println("Make: " + make);
                System.out.println("Color: " + color);
                System.out.println("*".repeat(20));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
