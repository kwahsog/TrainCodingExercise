package exerciseone.traindetails;

import java.util.Objects;

/**
 * Train class to represent inputted train data.
 */
public class Train {

    private String trainType;
    private int gear;
    private int speedKMPH;
    private int energyKHW;

    public Train(String trainType, int gear, int speedKMPH, int energyKHW) {
        this.setTrainType(trainType);
        this.setGear(gear);
        this.setSpeedKMPH(speedKMPH);
        this.setEnergyKHW(energyKHW);
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeedKMPH() {
        return speedKMPH;
    }

    public void setSpeedKMPH(int speedKMPH) {
        this.speedKMPH = speedKMPH;
    }

    public int getEnergyKHW() {
        return energyKHW;
    }

    public void setEnergyKHW(int energyKHW) {
        this.energyKHW = energyKHW;
    }

    public String toStringMaxSpeedRequest() {
        return "The max speed for this train is: " + this.getSpeedKMPH() + " (KMPH)";
    }

    public String toStringTrainAndEnergyRequest() {
        return "The best train type for this gear is: " + this.getTrainType() + " with the energy consumption of: " + this.getEnergyKHW() + " (KWH)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Train)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Train train = (Train)obj;
        return Objects.equals(trainType, train.trainType) && (gear == train.gear) && (speedKMPH == train.speedKMPH) && (energyKHW == train.energyKHW);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainType, gear, speedKMPH, energyKHW);
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainType='" + getTrainType() + '\'' +
                ", gear=" + getGear() +
                ", speedKMPH=" + getSpeedKMPH() +
                ", energyKHW=" + getEnergyKHW() +
                '}';
    }
}
