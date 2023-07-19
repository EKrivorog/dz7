package org.example;

public class Main {

    public static void main(String[] args) {
        SolarSystem earth = SolarSystem.EARTH;
        System.out.println("Planet: " + earth);
        System.out.println("Order from Sun: " + earth.getOrderFromSun());
        System.out.println("Distance from previous planet: " + earth.getDistanceFromPrevious());
        System.out.println("Distance from Sun: " + earth.getDistanceFromSun());
        System.out.println("Radius: " + earth.getRadius());
        System.out.println("Previous planet: " + earth.getPreviousPlanet());
        System.out.println("Next planet: " + earth.getNextPlanet());

    }
}