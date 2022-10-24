package domain;

public class Horse {

    private int numberId;
    private String name;
    private final int velocity = (int) Math.floor(Math.random()*15+1);
    private final int experience = (int) Math.floor(Math.random()*15+1);
    private final int ageHorse = (int) Math.floor(Math.random()*10+1);
    private int distanceAdvanced;
    private int count;

    public Horse(int numberId, String name) {
        this.numberId = numberId;
        this.name = name;
    }

    public Horse() {
    }

    public int getNumberId() {
        return numberId;
    }

    public String getName() {
        return name;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getExperience() {
        return experience;
    }

    public int getAgeHorse() {
        return ageHorse;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDistanceAdvanced() {
        return distanceAdvanced;
    }

    public void setDistanceAdvanced(int distance) {
        this.distanceAdvanced = distance;
    }

    public int runHorse(){
        return velocity + experience - ageHorse + ((int) Math.floor(Math.random()*10+1));
    }

}

