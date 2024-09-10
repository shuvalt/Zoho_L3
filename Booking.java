import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Flight> flights = new ArrayList<>();
        for(int i=0;i<2;i++){
            Flight flight = new Flight();
            flights.add(flight);
        }
        while (true) {
            System.out.println("1.book   2.cancel   3.flight details");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //booking
                    System.out.print("Flight Id: ");
                    int FlightId = sc.nextInt();
                    System.out.print("Passenger Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Passenger Age: ");
                    int age = sc.nextInt();
                    System.out.print("No of Tickets: ");
                    int tickets = sc.nextInt();
                    Flight flight = flights.get(FlightId-1);
                    Passengers newP = new Passengers(name, age, tickets);
                    flight.addPassenger(newP);
                    break;
                case 2:
                    //cancel
                    System.out.print("Flight Id: ");
                    int cancelflightid = sc.nextInt();
                    System.out.print("Passenger Name: ");
                    sc.nextLine();
                    String cancelname = sc.nextLine();
                    Flight currFlight = flights.get(cancelflightid-1);
                    if(flights.contains(currFlight)){
                        Passengers passengerstocancel = null;
                        for(Passengers p:currFlight.passengersList){
                            if(p.name.equals(cancelname)){
                                passengerstocancel=p;
                            }
                        }
                        currFlight.cancelPassenger(passengerstocancel);
                    }else{
                        System.out.println("Invalid Flight!!!");
                    }

                    break;
                case 3:
                    //display
                    for(Flight f:flights){
                        f.print();
                    }
                    break;
                default:
                    System.out.println("thanks..");
                    return;
            }
            sc.close();
        }
    }
}