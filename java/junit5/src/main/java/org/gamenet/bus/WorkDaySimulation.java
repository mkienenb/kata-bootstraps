package org.gamenet.bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkDaySimulation {
    private final List<Driver> driverList;
    private Set<Gossip> totalGossipSet;

    public WorkDaySimulation(Driver... drivers) {
        this.driverList = Arrays.asList(drivers);
        totalGossipSet = calculateTotalGossip();
    }

    private Set<Gossip> calculateTotalGossip() {
        totalGossipSet = new HashSet<>(driverList.size());
        for (Driver driver : driverList) {
            totalGossipSet.addAll(driver.getKnownGossipSet());
        }
        return totalGossipSet;
    }

    Set<Gossip> getTotalGossip() {
        return totalGossipSet;
    }
}
