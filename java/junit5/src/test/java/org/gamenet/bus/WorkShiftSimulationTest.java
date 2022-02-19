package org.gamenet.bus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WorkShiftSimulationTest {
    public static final Stop STOP1 = Stop.of(1);
    public static final Stop STOP2 = Stop.of(2);
    public static final Stop STOP3 = Stop.of(3);
    public static final Stop STOP4 = Stop.of(4);
    public static final Stop STOP5 = Stop.of(5);

    public static final Route ROUTE1 = new Route(STOP3, STOP1, STOP2, STOP3);
    public static final Route ROUTE2 = new Route(STOP3, STOP2, STOP3, STOP1);
    public static final Route ROUTE3 = new Route(STOP4, STOP2, STOP3, STOP4, STOP5);

    @Nested
    class A_work_day {
        @Nested
        class Is_at_start_point {

            private Driver driver1;
            private Driver driver2;
            private Driver driver3;
            private WorkShiftSimulation workShiftSimulation;

            @BeforeEach
            void setUp() {
                driver1 = new Driver(ROUTE1);
                driver2 = new Driver(ROUTE2);
                driver3 = new Driver(ROUTE3);
                workShiftSimulation = new WorkShiftSimulation(driver1, driver2, driver3);
            }

            @Test
            void should_have_three_total_gossips_with_three_drivers() {
                assertThat(workShiftSimulation.getTotalGossip()).as("total gossip").containsOnly(
                        driver1.getStartingGossip(), driver2.getStartingGossip(), driver3.getStartingGossip());
            }
        }
    }
}
