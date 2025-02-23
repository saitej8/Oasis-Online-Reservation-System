package onlinereservationsystem;

import java.sql.*;

public class Reservation {
    public boolean makeReservation(String passengerName,String trainNo,String trainName,String classType,String date,String fromPlace,String toPlace)
    {
try(Connection conn=DatabaseConnection.getConnection()) {
            String pnrNumber=generatePNR();
            String query="insert into Reservations(pnrNumber,passengerName,trainNo,trainName,classType,date,fromPlace,toPlace)"+
                           "values(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1,pnrNumber);
            pstmt.setString(2,passengerName);
            pstmt.setString(3,trainNo);
            pstmt.setString(4,trainName);
            pstmt.setString(5,classType);
            pstmt.setString(6,date);
            pstmt.setString(7,fromPlace);
            pstmt.setString(8,toPlace);

            int rowsInserted=pstmt.executeUpdate();
            return rowsInserted>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String generatePNR() {
        return "PNR"+System.currentTimeMillis();
    }
}
