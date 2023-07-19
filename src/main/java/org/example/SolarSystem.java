package org.example;

public enum SolarSystem {
    MERCURY(0L, 2439),
    VENUS(57910000L, 6052),
    EARTH(108200000L, 6371),
    MARS(78330000L, 3389),
    JUPITER(628730000L, 69911),
    SATURN(1285000000L, 58232),
    URANUS(2723950000L, 25362),
    NEPTUNE(2724395200L, 24622);

    private final long distanceFromPrevious;
    private final int radius;
    private long distanceFromSun;
    private SolarSystem previousPlanet;
    private SolarSystem nextPlanet;
    private int orderFromSun;

    SolarSystem(long prevDistance, int radius) {
        this.distanceFromPrevious = prevDistance;
        this.radius = radius;
    }

    static {
        SolarSystem[] planets = SolarSystem.values();
        for (int i = 0; i < planets.length; i++) {
            SolarSystem planet = planets[i];
            planet.distanceFromSun = planet.calculateDistanceFromSun(planet.distanceFromPrevious, i > 0 ? planets[i - 1] : null);
            planet.previousPlanet = i > 0 ? planets[i - 1] : null;
            planet.orderFromSun = i;
            planet.nextPlanet = i < planets.length - 1 ? planets[i + 1] : null;
        }
    }

    private long calculateDistanceFromSun(long prevDistance, SolarSystem previous) {
        if (previous == null) {
            return prevDistance;
        } else {
            return previous.distanceFromSun + prevDistance;
        }
    }

    public int getOrderFromSun() {
        return orderFromSun;
    }

    public long getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public long getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public SolarSystem getPreviousPlanet() {
        return previousPlanet;
    }

    public SolarSystem getNextPlanet() {
        return nextPlanet;
    }
}

