package exercisethree.driveranddelaydetails;

import org.springframework.data.annotation.Id;

import java.util.Objects;

/**
 * Class to represent the driver details of trains from the inbound data.
 * As per spec - this represents the train_driver_details collection.
 */

public class TrainDriverDetails {

    @Id
    public String id;

    private String trainId;
    private String fromStation;
    private String toStation;
    private String driverName;
    private String journeyStatus;

    public TrainDriverDetails() {}

    public TrainDriverDetails(String trainId, String fromStation, String toStation, String driverName, String journeyStatus) {
        this.trainId = trainId;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.driverName = driverName;
        this.journeyStatus = journeyStatus;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getJourneyStatus() {
        return journeyStatus;
    }

    public void setJourneyStatus(String journeyStatus) {
        this.journeyStatus = journeyStatus;
    }

    @Override
    public String toString() {
        return "TrainDriverDetails{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", driverName='" + driverName + '\'' +
                ", journeyStatus='" + journeyStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDriverDetails that = (TrainDriverDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(trainId, that.trainId) &&
                Objects.equals(fromStation, that.fromStation) &&
                Objects.equals(toStation, that.toStation) &&
                Objects.equals(driverName, that.driverName) &&
                Objects.equals(journeyStatus, that.journeyStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, trainId, fromStation, toStation, driverName, journeyStatus);
    }
}
