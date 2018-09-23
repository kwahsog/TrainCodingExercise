package exercisetwo.stationdemand;

/**
 * Station class for storing passenger demand between two stations.
 */
public class Station {

    private String origin;
    private String destination;
    private int passengerDemand;

    public Station(String origin, String destination, int passengerDemand) {
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setPassengerDemand(passengerDemand);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPassengerDemand() {
        return passengerDemand;
    }

    public void setPassengerDemand(int passengerDemand) {
        this.passengerDemand = passengerDemand;
    }

    @Override
    public String toString() {
        return "Station{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", passengerDemand=" + passengerDemand +
                '}';
    }

    public String prettyString() {
        return origin + " to " + destination + " - " + passengerDemand;
    }
}
