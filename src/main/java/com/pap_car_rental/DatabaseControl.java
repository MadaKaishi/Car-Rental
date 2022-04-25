package com.pap_car_rental;
import java.sql.*;
import java.util.ArrayList;


public class DatabaseControl {
    Connection c = null;
    Statement stmt = null;
    DatabaseControl()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:car_list.db");
            System.out.println("Connected to DB");
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
    }
    }
    public ArrayList<Car> listCars() throws SQLException {
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CAR_LIST");
        ArrayList<Car> car_list= new ArrayList<>();
        while(rs.next())
        {
            String Car_type = rs.getString("Car_type");
            String Brand = rs.getString("Brand");
            int Cost = rs.getInt("Cost");
            String Model = rs.getString("Model");
            Date dateFrom = rs.getDate("DateFrom");
            Date dateTo = rs.getDate("DateTo");
            Car new_car = new Car(Car_type, Brand, Cost, Model, dateFrom, dateTo);
            car_list.add(new_car);
        }
        return car_list;
    }
    public void addCar(String car_type,String brand,int cost,String model, Date dateFrom, Date dateTo) throws SQLException {
        PreparedStatement pstmt = c.prepareStatement("INSERT INTO `CAR_LIST`(Car_type, Brand, Cost, Model, DateFrom, DateTo) VALUES (?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, car_type);
        pstmt.setString(2, brand);
        pstmt.setInt(3, cost);
        pstmt.setString(4, model);
        pstmt.setDate(5, dateFrom);
        pstmt.setDate(6, dateTo);
        pstmt.executeUpdate();
    }
}
