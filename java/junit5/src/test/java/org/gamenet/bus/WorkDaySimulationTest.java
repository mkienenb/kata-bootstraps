package org.gamenet.bus;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WorkDaySimulationTest {

    @Nested
    class A_work_day {
        @Nested
        class Is_at_start_point {
            @Test
            void should_have_three_total_gossips_with_three_drivers() {
                Driver driver1 = new Driver();
                Driver driver2 = new Driver();
                Driver driver3 = new Driver();
                WorkDaySimulation workDaySimulation = new WorkDaySimulation(driver1, driver2, driver3);
                assertThat(workDaySimulation.getTotalGossip()).as("total gossip").containsOnly(
                        driver1.getStartingGossip(), driver2.getStartingGossip(), driver3.getStartingGossip());
            }
        }
    }
}
