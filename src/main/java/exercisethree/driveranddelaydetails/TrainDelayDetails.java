package exercisethree.driveranddelaydetails;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class to represent the delay details of trains from the inbound data.
 * As per spec - this represents the train_delay_details collection.
 */
public class TrainDelayDetails {

    @Id
    public String id;

    private String trainId;
    private String station;
    private LocalDateTime departureTime;
    private String depatureLateness;

    public TrainDelayDetails() {}

    public TrainDelayDetails(String trainId, String station, LocalDateTime departureTime, String depatureLateness) {
        this.trainId = trainId;
        this.station = station;
        this.departureTime = departureTime;
        this.depatureLateness = depatureLateness;
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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepatureLateness() {
        return depatureLateness;
    }

    public void setDepatureLateness(String depatureLateness) {
        this.depatureLateness = depatureLateness;
    }

    @Override
    public String toString() {
        return "TrainDelayDetails{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", station='" + station + '\'' +
                ", departureTime=" + departureTime +
                ", depatureLateness='" + depatureLateness + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDelayDetails that = (TrainDelayDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(trainId, that.trainId) &&
                Objects.equals(station, that.station) &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(depatureLateness, that.depatureLateness);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, trainId, station, departureTime, depatureLateness);
    }
}
