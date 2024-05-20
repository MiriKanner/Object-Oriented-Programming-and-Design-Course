import java. util. *;
public class Train implements Comparable, Movable{
    public static final int PASSENGER_LIMIT = 500;
    public static final int STATION_LIMIT = 5;


    int licenceNumber;
    Location source, destination;
    int numberOfStations;
    int currentStation;
    int maximalPassenger;
    public Train(int id, Location src, Location dst, int numOfStations, int maxPassengers) {
        licenceNumber = id;
        source = src;
        destination = dst;
        numberOfStations = numOfStations;
        currentStation = 0;
        maximalPassenger = maxPassengers;
    }
    //    @Override
//public int getLicenceNumber() {
//        return licenceNumber;
//}
    @Override
    public String toString() {
        return String.format("licence = %d, source = %s, destination = %s, station = %d, maxPassengers = %d",
                licenceNumber, source, destination, currentStation, maximalPassenger);
    }

    @Override
    public String getType() {//
        return "Train";
    }

    @Override
    public int getId() {
        return licenceNumber;
    }

    @Override
    public Location getSource() {
        return source;
    }

    @Override
    public Location getDestination() {
        return destination;
    }

    @Override
    public String getCurrentLocation() {
        //station Madrid between 4 and Rome
        //station 4 between Madrid and Rome.
        if(this.currentStation==0)
            return source.toString();
        else{
            return"station "+ currentStation +" between "+ this.source
                    +" and "+destination+".";
        }

    }
    //
    @Override
    public void move() {






        this.currentStation++;


        if (this.currentStation == numberOfStations)
        {
            Location temp = source;
            this.source = this.destination;
            this.destination = temp;
            this.currentStation=0;
        }

    }

    @Override
    public int compareTo(Object o) {
        Train t1 = (Train) o;
        if(t1.maximalPassenger==this.maximalPassenger)
            return 0;
        else if (t1.maximalPassenger>this.maximalPassenger)
            return -1;
        else
            return 1;
    }
}
