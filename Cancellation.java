package onlinereservationsystem;

import java.sql.*;

public class Cancellation {
    public ReservationDetails getReservationByPNR(String pnrNumber) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query="select * from Reservations where pnrNumber = ?";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1,pnrNumber);

            ResultSet rs=pstmt.executeQuery();
            if (rs.next()) {
                return new ReservationDetails(
                        rs.getString("pnrNumber"),
                        rs.getString("passengerName"),
                        rs.getString("trainNo"),
                        rs.getString("trainName"),
                        rs.getString("classType"),
                        rs.getString("date"),
                        rs.getString("fromPlace"),
                        rs.getString("toPlace")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean cancelReservation(String pnrNumber) {
        try (Connection conn=DatabaseConnection.getConnection()) {
            String query="delete from Reservations where pnrNumber = ?";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1,pnrNumber);

            int rowsDeleted=pstmt.executeUpdate();
            return rowsDeleted>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
