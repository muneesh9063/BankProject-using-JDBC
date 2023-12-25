package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAL {
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "Admin@123");
        if (conn != null) {
            return conn;
        } else {
            throw new RuntimeException("Connection error");
        }
    }

    public static List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        List<Customer> customers = new ArrayList<>();

        String query = "SELECT * FROM bankdb";

        Statement stmt = getConnection().createStatement();
        ResultSet results = stmt.executeQuery(query);

        while (results.next()) {
            Customer customer = new Customer();

            customer.setId(results.getInt("id"));
            customer.setFname(results.getString("fname"));
            customer.setLname(results.getString("lname"));
            customer.setEmail(results.getString("email"));
            customer.setCity(results.getString("city"));
            customer.setContact(results.getLong("contact"));
            customer.setAccountType(results.getString("account_type"));

            customers.add(customer);
        }

        return customers;
    }

    public static Customer getCustomer(int id) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM bankdb WHERE id = ?";

        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setInt(1, id);//1 means first question Mark
        ResultSet results = pstmt.executeQuery();
        while (results.next()) {
            Customer customer = new Customer();
            customer.setId(results.getInt("id"));
            customer.setFname(results.getString("fname"));
            customer.setLname(results.getString("lname"));
            customer.setEmail(results.getString("email"));
            customer.setCity(results.getString("city"));
            customer.setContact(results.getLong("contact"));
            customer.setAccountType(results.getString("account_type"));

            return customer;
        }

        throw new RuntimeException("Customer doesn't exist"); // customer doesn't exist

    }

    public static void createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO bankdb(fname,lname,email, city, contact, account_type) VALUES (?, ?, ?, ?, ?,?)";

        PreparedStatement pstmt = getConnection().prepareStatement(sql);

        // replace these ?
        pstmt.setString(1, customer.getFname());
        pstmt.setString(2, customer.getLname());
        pstmt.setString(3, customer.getEmail());
        pstmt.setString(4, customer.getCity());
        pstmt.setLong(5, customer.getContact());
        pstmt.setString(6, customer.getAccountType());

        pstmt.execute();
    }

    public static void updateCustomer(Customer updatedCustomer) throws ClassNotFoundException, SQLException {

        String query = "UPDATE bankdb SET fname=?,lname=?,email=?, city=?, contact=?, account_type=? WHERE id = ?";

        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, updatedCustomer.getFname());
        pstmt.setString(2, updatedCustomer.getLname());
        pstmt.setString(3, updatedCustomer.getEmail());
        pstmt.setString(4, updatedCustomer.getCity());
        pstmt.setLong(5, updatedCustomer.getContact());
        pstmt.setString(6, updatedCustomer.getAccountType());
        pstmt.setInt(7, updatedCustomer.getId());

        pstmt.execute();
    }

    public static void deleteCustomer(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM bankdb WHERE id = ?";

        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.execute();
    }
}
