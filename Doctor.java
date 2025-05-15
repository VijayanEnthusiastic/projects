package HospitalManagement;

import java.sql.*;
import java.util.Scanner;

public class Doctor {
    private Connection conn;

    public Doctor(Connection conn){
        this.conn = conn;
    }

    public void viewDoctors(){
        String query = "SELECT * FROM doctors";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nList of Doctors: ");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String specialization = rs.getString("specialization");
                String contact = rs.getString("contact");
                System.out.println("ID: "+id+", Name: "+name+", Specialization: "+specialization+", Contact: "+contact);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getDoctorById(int id){
        String query = "SELECT * FROM doctors WHERE id = ?";
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


