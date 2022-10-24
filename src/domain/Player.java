package domain;

public class Player {

    private String name;
    private int money;
    private Bet bet;

    public Player() {
    }

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public Player(String name, int money, Bet bet) {
        this.name = name;
        this.money = money;
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
