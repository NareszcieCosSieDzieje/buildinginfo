package main.java.pl.put.poznan.buildinginfo.logic;

public class Room extends Location{
    private float area;
    private float cube;
    private float heating; //TODO: refactor??
    private float light;

    public Room(){
        //this(); random_data
    }

    public Room(float area, float cube, float heating, float light){

    }

    public String toString(){
        return ("Area: " + this.area + "Volume: " + this.cube + "Heating: " + this.heating + "Light: " + this.light);
    }
    //jakies zarzadzanie tymi wartosciami

    //gettery settery


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

}
