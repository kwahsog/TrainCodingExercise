package exercisethree.driveranddelaydetails;

import java.time.LocalDateTime;

/**
 * Class to represent raw data from feed.
 */
public class DriverAndDelayEntry {

    private String trainId;
    private String station;
    private LocalDateTime actualDepartureTime;
    private String driverName;
    private String departureLateness;

    public DriverAndDelayEntry(String trainId, String station, LocalDateTime actualDepartureTime, String driverName, String departureLateness) {
        this.setTrainId(trainId);
        this.setStation(station);
        this.setActualDepartureTime(actualDepartureTime);
        this.setDriverName(driverName);
        this.setDepartureLateness(departureLateness);
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public LocalDateTime getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(LocalDateTime actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDepartureLateness() {
        return departureLateness;
    }

    public void setDepartureLateness(String departureLateness) {
        this.departureLateness = departureLateness;
    }

    @Override
    public String toString() {
        return "DriverAndDelayEntry{" +
                "trainId='" + getTrainId() + '\'' +
                ", station='" + getStation() + '\'' +
                ", actualDepartureTime=" + getActualDepartureTime() +
                ", driverName='" + getDriverName() + '\'' +
                ", departureLateness=" + getDepartureLateness() +
                '}';
    }
}
