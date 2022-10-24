package domain;

public class Race {

    private String nameRace;
    private int distance;
    private Horse[] listHorse;

    public Race(String nameRace, int distance, Horse[] listHorse) {
        this.nameRace = nameRace;
        this.distance = distance;
        this.listHorse = listHorse;
    }

    public Race(String nameRace, int distance) {
        this.nameRace = nameRace;
        this.distance = distance;

    }

    public Race() {
    }

    public String getNameRace() {
        return nameRace;
    }

    public void setNameRace(String nameRace) {
        this.nameRace = nameRace;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Horse[] getListHorse() {
        return listHorse;
    }

    public void setListHorse(Horse[] listHorse) {
        this.listHorse = listHorse;
    }



    //cada caballo corre, detener método., caballo que más haya avanzado una vez alcanzada la distancia, sera el ganador
    //ecuacion velo(1-10)+ex-edad+random(1-10)
    public Horse startRace(Horse [] listHorse){
        Horse horseProof = new Horse();
        int value = 0;
        boolean exit = true;
        int counter = 0;

        for (Horse horse : listHorse) {

            while (exit) {
                int runHorse = horse.runHorse();
                value += runHorse;
                horse.setDistanceAdvanced(value);
                if (horse.getDistanceAdvanced() < distance) {
                    counter++;
                    horse.setCount(counter);

                } else {
                    exit = false;
                }
            }
            counter = 0;
            exit = true;
            value = 0;
        }

        int valMin = listHorse[0].getCount();
        int maxDistance = listHorse[0].getDistanceAdvanced();

        for (Horse horse : listHorse) {
            if (horse.getCount() <= valMin) {
                valMin = horse.getCount();
                if(horse.getDistanceAdvanced() >= maxDistance) {
                    horseProof = horse;
                }
            }
            horse.setDistanceAdvanced(0);
            horse.setCount(0);
        }
        return horseProof;
    }
}
