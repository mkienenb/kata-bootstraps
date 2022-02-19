package org.gamenet.bus;

import java.util.Arrays;

public class Route {
    private Stop[] stops;
    private int currentStopIndex = 0;

    public Route(Stop... stops) {
        this.stops = Arrays.copyOf(stops, stops.length);
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
