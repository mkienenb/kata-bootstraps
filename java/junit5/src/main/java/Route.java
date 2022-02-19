import java.util.Arrays;

public class Route {
    private int[] stops;
    private int currentStopIndex = 0;

    public Route(int... stops) {
        this.stops = Arrays.copyOf(stops, stops.length);
    }

    public int getCurrentStop() {
        return stops[currentStopIndex];
    }

    public void proceedToNextStop() {
        currentStopIndex++;
        if (currentStopIndex >= stops.length) {
            currentStopIndex = 0;
        }
    }
}
