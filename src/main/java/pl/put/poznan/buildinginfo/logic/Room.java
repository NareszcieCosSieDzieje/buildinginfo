package pl.put.poznan.buildinginfo.logic;

import java.util.Random;

public class Room extends Location{
    private float area;
    private float cube;
    private float heating; //TODO: refactor??
    private float light;

    public Room(){
        super();
        Random generator = new Random();
        this.area = generator.nextFloat();
        this.cube = generator.nextFloat();
        this.heating = generator.nextFloat();
        this.light = generator.nextFloat();
    }

    public Room(String name, float area, float cube, float heating, float light){
        super(name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public String toString(){
        return ("Area: " + this.area + "Volume: " + this.cube + "Heating: " + this.heating + "Light: " + this.light);
    }

    public float getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    public float getHeating() {
        return heating;
    }

    public float getLight() {
        return light;
    }

    public float getLightPerSquareArea(){
        return this.light/this.area;
    }

    public float getHeatPerCubicArea(){
        return this.heating/this.cube;
    }

    public void setArea(float area) { this.area = area; }

    public void setCube(float cube) { this.cube = cube; }

    public void setHeating(float heating) { this.heating = heating; }

    public void setLight(float light) { this.light = light; }
}
