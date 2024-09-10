import java.util.ArrayList;

public class Flight{
    public int flightId;
    public static int id=1;
    public int availableTickets;
    public long currPrice;
    public ArrayList<Passengers> passengersList;
    public Flight(){
        flightId = id++;
        availableTickets = 50;
        currPrice = 5000;
        passengersList = new ArrayList<>();
    }

    public void addPassenger(Passengers p){
        if(p.tickets>availableTickets){
            System.out.println(p.tickets+" Tickets Not Available!!!");
            return;
        }
        passengersList.add(p);
        long amount = currPrice*p.tickets;
        p.setAmount(amount);
        currPrice += (p.tickets*200);
        availableTickets-=p.tickets;
        System.out.println("Amount Paid : "+p.amount);
        System.out.println("Ticket booked successfully...");
        remaining();
    }

    public void cancelPassenger(Passengers p){
        Boolean found = false;
        for(Passengers passenger:passengersList){
            if(passenger.equals(p)){
                found = true;
            }
        }
        if(!found){
            System.out.println("Invalid Passenger!!!");
            return;
        }
        passengersList.remove(p);
        currPrice -= (p.tickets*200);
        availableTickets += p.tickets;
        System.out.println("Ticket canceled successfully... and Refuned Rs: "+p.amount);
        remaining();
    }

    public void print(){
        remaining();
        if(availableTickets==50){
            return;
        }
        for(Passengers p:passengersList){
            System.out.println("Passenger Name :"+p.name+" Tickets Booked:"+p.tickets+" Amount Paid:"+p.amount);
        }
    }

    public void remaining(){
        System.out.println("Flight Id: "+flightId+" Remaining seats:"+availableTickets+" Current Price:"+currPrice);
    }

}