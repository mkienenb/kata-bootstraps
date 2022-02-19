package org.gamenet.bus;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Driver {
    private final Gossip MY_GOSSIP = new Gossip();
    private final Set<Gossip> knownGossipSet = new HashSet<>();

    public Driver() {
        knownGossipSet.add(MY_GOSSIP);
    }

    public Set<Gossip> getKnownGossipSet() {
        return Collections.unmodifiableSet(knownGossipSet);
    }

    public void isToldGossipBy(Driver driver) {
        knownGossipSet.addAll(driver.getKnownGossipSet());
    }

    public Gossip getStartingGossip() {
        return MY_GOSSIP;
    }
}
