package domain;

public class Bet {

    private int quantity;
    private Horse horse;

    public Bet(int quantity, Horse horse) {
        this.quantity = quantity;
        this.horse = horse;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}
