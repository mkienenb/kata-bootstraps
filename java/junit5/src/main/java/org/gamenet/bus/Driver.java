package org.gamenet.bus;

import java.util.Collections;
import java.util.Set;

public class Driver {
    public Set<Gossip> getKnownGossip() {
        return Collections.singleton(new Gossip());
    }
}
