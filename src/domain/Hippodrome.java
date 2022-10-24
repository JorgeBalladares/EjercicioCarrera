package domain;

import java.util.Scanner;

public class Hippodrome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Hippodrome hippodrome = new Hippodrome();

// INTRODUCE THE HORSE OBJECT MANUALLY
        Horse h1 = new Horse(125, "Marron");
        Horse h2 = new Horse(165, "Blanco");
        Horse h3 = new Horse(568, "Negro");
        Horse[] listHorse = new Horse[]{h1, h2, h3};

        System.out.println("Introduce the players: ");
        Player[] listPlayers = new Player[2];

// INTRODUCE THE PLAYERS DATA
        for (int i = 0; i<2; i++){
            System.out.print("\nEnter the player's name: ");
            String name = scan.next();
            System.out.print("Enter the money available in his wallet: ");
            int money = scan.nextInt();
            Player p = new Player(name, money);
            listPlayers[i] = p;
        }
//CALL THE METHOD TO SHOW THE MENU
        hippodrome.drawMenu(listPlayers, listHorse);

    }

//Method to check if the horse with the number written exists
    private boolean proofNumber(int number, Horse[] listHorse){
        boolean exit = false;
        for (int i = 0; i<3; i++){
            if (number == listHorse[i].getNumberId()) {
                exit = true;
                break;
            }
        }
        return exit;
    }

    private void drawMenu(Player[] listPlayer, Horse[] listHorse){
        Hippodrome hippodrome = new Hippodrome();
        Scanner scan = new Scanner(System.in);

        String menu = """
                Enter an option:\s
                1. Bet on the competition:\s
                2. Run the horses race:\s
                3. Exit:\s""";
        int exit ;

        do{
            System.out.println();
            System.out.print(menu);
            System.out.print("Introduce your option: ");
            exit = scan.nextInt();

            switch (exit) {
                case 1 -> hippodrome.betting(listPlayer, listHorse);
                case 2 -> hippodrome.raceCompetition(listPlayer, listHorse);
                case 3 -> System.out.println("Goodbye!");
                default -> System.out.println("This options is not allowed");
            }
        }while(exit!=3);
        scan.close();
    }

    private void betting(Player[] listPlayer, Horse[] listHorse){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do{
            System.out.print("Enter the name of the player who is going to bet on the race: ");
            String name = scan.next();
            for(Player p : listPlayer){
                if(p.getName().equals(name)){
                    System.out.print("Enter the money the player wants to bet: ");
                    int money = scan.nextInt();
                    if (p.getMoney()<=money){
                        System.out.println("The player cannot bet this amount since his balance would be negative\n");
                    }
                    else{
                        System.out.print("Enter the horse the player wants to bet on: ");
                        int numberHorse = scan.nextInt();
                        boolean proofHorse = true;
                        if(proofNumber(numberHorse, listHorse) == proofHorse){
                            for(Horse s : listHorse){
                                if (s.getNumberId()==numberHorse){
                                    int actualMoney = p.getMoney()-money;
                                    p.setMoney(actualMoney);
                                    Bet b = new Bet(money, s);
                                    p.setBet(b);
                                    System.out.println("This player has completed his bet\n");
                                    exit = true;
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("The horse's number does not exist in the race\n");
                        }
                    }
                }
            }
        }while(!exit);
    }

    private void raceCompetition(Player[] listPlayer, Horse[] listHorse){

        boolean proof = true;

        for (Player p : listPlayer) {
            if (p.getBet() == null) {
                proof = false;
                break;
            }
        }
        if (!proof){
            System.out.println("The race can only be started when all players have bet\n");

        }else{
            Hippodrome hippodrome = new Hippodrome();
            Horse horseWinner = hippodrome.getHorseWinner(listHorse);
            for (Player p : listPlayer) {
                if(p.getMoney()<p.getBet().getQuantity()){
                    System.out.println("You can not bet because it is not allowed to have a balance in negative, change the bets");
                    break;
                }
                else{
                    if (p.getBet().getHorse().getNumberId() == horseWinner.getNumberId()) {
                        System.out.println("The player " + p.getName() + " has won the race because he bet on the horse with number " + horseWinner.getNumberId());
                        System.out.println("His salary before the bet was: " + p.getMoney());
                        int win = 5 * p.getBet().getQuantity();
                        p.setMoney(win);
                        System.out.println("His current salary after the bet is: " + p.getMoney());
                    } else {
                        System.out.println("The player " + p.getName() + " lost the bet he made since he bet on the horse with the number " + p.getBet().getHorse().getNumberId() +
                                " and the winning horse was the one with the dorsal number " + horseWinner.getNumberId());
                        System.out.println("\"His current salary after the bet is: " + p.getMoney());
                    }
                }
            }
        }
    }

    private Horse getHorseWinner(Horse[] listHorse){
        Race race = new Race("Championship", 80);
        return race.startRace(listHorse);
    }

}
