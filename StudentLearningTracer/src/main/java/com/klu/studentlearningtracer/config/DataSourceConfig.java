package com.klu.studentlearningtracer.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceConfig {

    private static HikariDataSource dataSource;

    static {
        // Initialize the HikariDataSource with configuration settings
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/student_learning_outcomes");
        config.setUsername("root");
        config.setPassword("Taha@123");
        config.setMaximumPoolSize(10); // Set the maximum pool size (optional)
        config.setAutoCommit(true); // or false, depending on your needs
        config.setTransactionIsolation("TRANSACTION_READ_COMMITTED"); // or another level

        // Create the DataSource
        dataSource = new HikariDataSource(config);
    }

    // Method to get the DataSource
    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
