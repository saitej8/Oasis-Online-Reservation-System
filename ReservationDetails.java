package onlinereservationsystem;

public class ReservationDetails {
    private String pnrNumber;
    private String passengerName;
    private String trainNo;
    private String trainName;
    private String classType;
    private String date;
    private String fromPlace;
    private String toPlace;

    public ReservationDetails(String pnrNumber, String passengerName, String trainNo, String trainName,
                              String classType, String date, String fromPlace, String toPlace) {
        this.pnrNumber=pnrNumber;
        this.passengerName=passengerName;
        this.trainNo=trainNo;
        this.trainName=trainName;
        this.classType=classType;
        this.date=date;
        this.fromPlace=fromPlace;
        this.toPlace=toPlace;
    }

    public String getPassengerName() {
        return passengerName;
    }
}
