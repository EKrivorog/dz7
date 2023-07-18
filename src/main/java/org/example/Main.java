package org.example;

public class Main {

    public static void main(String[] args) {

        enum SolarSystem {
            MERCURY(0, 0, 2439, null, null),
            VENUS(57910000L, 6052, 2439, MERCURY, null),
            EARTH(108200000L, 6371, 2439, VENUS, null),
            MARS(78330000L, 3389, 2439, EARTH, null),
            JUPITER(628730000L, 69911, 2439, MARS, null),
            SATURN(1285000000L, 58232, 2439, JUPITER, null),
            URANUS(2723950000L, 25362, 2439, SATURN, null),
            NEPTUNE(2724395200L, 24622, 2439, URANUS, null);

            private final int orderFromSun;
            private final long distanceFromPrevious;
            private final long distanceFromSun;
            private final int radius;
            private final SolarSystem previousPlanet;
            private final SolarSystem nextPlanet;

            SolarSystem(long prevDistance, int radius, int i, SolarSystem previous, SolarSystem next) {
                this.orderFromSun = ordinal();
                this.distanceFromPrevious = prevDistance;
                this.distanceFromSun = calculateDistanceFromSun(prevDistance, previous);
                this.radius = radius;
                this.previousPlanet = previous;
                this.nextPlanet = next;
            }

            private long calculateDistanceFromSun(long prevDistance, SolarSystem previous) {
                if (previous == null) {
                    return 0;
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

    }
}