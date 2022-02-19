package org.gamenet.bus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WorkShiftSimulationTest {

    @Nested
    class A_work_day {
        @Nested
        class Is_at_start_point {

            private Driver driver1;
            private Driver driver2;
            private Driver driver3;
            private WorkShiftSimulation workShiftSimulation;

            @Test
            void should_have_three_total_gossips_with_three_drivers() {
                driver1 = new Driver();
                driver2 = new Driver();
                driver3 = new Driver();
                workShiftSimulation = new WorkShiftSimulation(driver1, driver2, driver3);
                assertThat(workShiftSimulation.getTotalGossip()).as("total gossip").containsOnly(
                        driver1.getStartingGossip(), driver2.getStartingGossip(), driver3.getStartingGossip());
            }
        }
    }
}
