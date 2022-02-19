package org.gamenet.bus;

import java.util.Arrays;

public class Route {
    private Stop[] stops;
    private int currentStopIndex = 0;

    public Route(Stop... stops) {
        verifyStops(stops);
        this.stops = Arrays.copyOf(stops, stops.length);
    }

    private void verifyStops(Stop[] stops) {
        if (0 == stops.length) {
            throw new NullPointerException("stops");
        }
    }

    public Stop getCurrentStop() {
        return stops[currentStopIndex];
    }

    public void proceedToNextStop() {
        currentStopIndex++;
        if (currentStopIndex >= stops.length) {
            currentStopIndex = 0;
        }
    }
}
