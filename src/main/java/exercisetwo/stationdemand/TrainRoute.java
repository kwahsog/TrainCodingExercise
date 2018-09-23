package exercisetwo.stationdemand;

import java.util.*;

public class TrainRoute {

    private LinkedHashMap<String, List<Station>> trainRoute;
    private List<Station> allStations;
    private List<String> stationsInOrder;

    public TrainRoute() {
        trainRoute = new LinkedHashMap<>();
        stationsInOrder = new ArrayList<>();
        allStations = new ArrayList<>();
    }

    public List<String> getStationsInOrder() {
        return stationsInOrder;
    }

    public void addStationDetails(String startingStation, String userInput) {
        //Waterloo
        //0,400,500,650,450,200
        String[] inputArray = userInput.split(",");
        for (int i = 0; i < inputArray.length; i++) {
            Station temp = new Station(startingStation, stationsInOrder.get(i), Integer.parseInt(inputArray[i]));
            trainRoute.get(startingStation).add(temp);
            allStations.add(temp);
        }
    }

    public void addStationDetails(String userInput) {
        String[] inputArray = userInput.split(",");
        for (String s : inputArray) {
            stationsInOrder.add(s);
            trainRoute.put(s, new ArrayList<>());
        }
    }

    public void printStationMatrix() {

        //convert inner LinkedHashMap to 2d array

        String[][] tempArray = new String[trainRoute.size() + 1][trainRoute.size() + 1];

        tempArray[0][0] = "Destination/Origin";
        for (int j = 0; j < stationsInOrder.size(); j++) {
            tempArray[0][j+1] = stationsInOrder.get(j);
        }
        int i = 1;
        for (String key : trainRoute.keySet()) {
            //int j = 0;
            tempArray[i][0] = key;
            List<Station> allStations = trainRoute.get(key);
            for (int k = 0; k < allStations.size(); k++) {
                tempArray[i][k+1] = String.valueOf(allStations.get(k).getPassengerDemand());
            }
            i++;
        }
        System.out.println(Arrays.deepToString(tempArray).replace("], ", "]\n"));
    }

    public void printMaxDemand() {

        List<Station> maxDemandStations = new ArrayList<>();
        allStations.sort(Comparator.comparing(Station::getPassengerDemand, Comparator.reverseOrder()));
        maxDemandStations.add(allStations.get(0));
        int i = 0;
        while (allStations.get(i + 1).getPassengerDemand() >= allStations.get(0).getPassengerDemand()) {
            maxDemandStations.add(allStations.get(i+1));
            i++;
        }

        for (Station st : maxDemandStations) {
            System.out.println(st.prettyString());
        }
    }

    public void printMinimumDemand(String userInput) {
        Integer lowerLimit = Integer.parseInt(userInput);
        allStations.sort(Comparator.comparing(Station::getPassengerDemand, Comparator.reverseOrder()));
        List<Station> stations = new ArrayList<>();
        for (Station st : allStations) {
            if (st.getPassengerDemand() >= lowerLimit) {
                stations.add(st);
            } else {
                break;
            }
        }
        if (stations.size() == 0 ) {
            System.out.println("No results");
        } else {
            for (Station st : stations) {
                System.out.println(st.prettyString());
            }
        }
    }


}
