package HospitalManagement;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/hospital";
    private static String user = "root";
    private static String password = "root";

    public static void main(String[] args) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e)  {
          e.printStackTrace();
      }

      Scanner sc = new Scanner(System.in);
      try {
        Connection conn = DriverManager.getConnection(url, user, password);
        Patient patient = new Patient(conn, sc);
        Doctor doctor = new Doctor(conn);

        while(true){
          System.out.println("HOSPITAL MANAGEMENT SYSTEM");
          System.out.println("-------------------------------------------------");
          System.out.println("1. Add Patient ");
          System.out.println("2. View Patient ");
          System.out.println("3. View Doctor ");
          System.out.println("4. Book Appointment ");
          System.out.println("5. Exit");
          System.out.println("-------------------------------------------------");
          System.out.println("Enter your Choice: ");
          int choice = sc.nextInt();

          switch(choice){
            case 1: 
                // Add Patient
                patient.addPatient();
                System.out.println();
                break;
            case 2:
                // View Patient
                patient.viewPatients();
                System.out.println();
                break;
            case 3:
                //View Doctor
                doctor.viewDoctors();
                System.out.println();
                break;
            case 4:
                //Book Appointment
                bookAppointment(patient, doctor, conn, sc);
                System.out.println();
                break;
            case 5:
                return ;
            default:
                System.out.println("Invalid Choice !!");    
          }

        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public static void bookAppointment(Patient patient , Doctor doctor , Connection connection , Scanner sc ){
      System.out.println("Enter Patient ID: ");
      int patient_id = sc.nextInt();
      System.out.println("Enter Doctor ID: ");
      int doctor_id = sc.nextInt();
      System.out.println("Enter Appointment Date (YYYY-MM-DD)");
      String appointment_date = sc.next();
      if(patient.getPatientById(patient_id) && doctor.getDoctorById(doctor_id)){
        if(checkDoctorAvailability(doctor_id,appointment_date,connection)){
          String appointmentquery = "INSERT INTO appointments(patient_id,doctor_id,appointment_date) VALUES(?,?,?)";
          try{
            PreparedStatement ps = connection.prepareStatement(appointmentquery);
            ps.setInt(1, patient_id);
            ps.setInt(2,doctor_id);
            ps.setString(3,appointment_date);
            int affectedRows = ps.executeUpdate();
            if(affectedRows > 0){
              System.out.println("Appointment Booked!!!");
            }
            else{
              System.out.println("Failed to book Appointment.......");
            }
          }
          catch(SQLException e){
            e.printStackTrace();
          }
        }
        else{
          System.out.println("Doctor is not available on that day");
        }
      }
      else{
        System.out.println("Patient & Doctor never exist !!");
      }
    }

    public static boolean checkDoctorAvailability(int doctor_id , String appointment_date , Connection connection){
      String query = "SELECT COUNT(*) FROM appointments where doctor_id = ? AND appointment_date = ?";
      try {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, doctor_id);
        ps.setString(2, appointment_date);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          int count = rs.getInt(1);
          if(count==0){
            return true;
          }
          else{
            return false;
          }
        }
      } catch (SQLException e) {
          e.printStackTrace();
      }
          return false;

    }

}
