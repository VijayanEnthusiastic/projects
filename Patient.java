package HospitalManagement;

import java.sql.*;
import java.util.Scanner;

public class Patient {
    private Connection conn;
    private Scanner sc;

    public Patient(Connection conn, Scanner sc){
        this.conn = conn;
        this.sc = sc;
    }

    public void addPatient(){
        System.out.println("Enter Patient Name: ");
        String name = sc.next();
        System.out.println("Enter Patient Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Patient Gender: ");
        String gender = sc.next();
        System.out.println("Enter Patient Contact: ");
        String contact = sc.next();

        try {
            String query = "INSERT INTO patients(name,age,gender,contact) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2,age);
            ps.setString(3,gender);
            ps.setString(4, contact);
            int affectedRows = ps.executeUpdate();

            if(affectedRows > 0){
                System.out.println("Patient Details Added.....");
            }
            else{
                System.out.println("Failed to add Patient !!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPatients(){
        String query = "SELECT * FROM patients";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nList of Patients: ");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String contact = rs.getString("contact");
                System.out.println("ID: "+id+", Name: "+name+", Age: "+age+", Gender: "+gender+", Contact: "+contact);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getPatientById(int id){
        String query = "SELECT * FROM patients WHERE id = ?";
        try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
            return true;
           }else{
            return false;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }
}
