public class Passengers {
    public String name;
    public int age;
    public int tickets;
    public long amount;
    public Passengers(String name,int age,int tickets){
        this.name = name;
        this.age = age;
        this.tickets = tickets;
    }
    public void setAmount(long amount){
        this.amount = amount;
    }
}
