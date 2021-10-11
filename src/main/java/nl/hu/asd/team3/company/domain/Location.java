package nl.hu.asd.team3.company.domain;

public class Location {
    private float coordX;
    private float coordY;

    public Location(float coordX, float coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }
}
