package org.gamenet.bus;

import java.util.Objects;

public class Stop {
    int stopNumber;

    public static Stop of(int stopNumber) {
        return new Stop(stopNumber);
    }

    public Stop(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return stopNumber == stop.stopNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopNumber);
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopNumber=" + stopNumber +
                '}';
    }
}
