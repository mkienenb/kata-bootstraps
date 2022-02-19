package org.gamenet.bus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DriverTest {
    public static final Stop STOP1 = Stop.of(1);
    public static final Stop STOP2 = Stop.of(2);
    public static final Stop STOP3 = Stop.of(3);
    public static final Stop STOP4 = Stop.of(4);
    public static final Stop STOP5 = Stop.of(5);

    public static final Route ROUTE1 = new Route(STOP3, STOP1, STOP2, STOP3);
    public static final Route ROUTE2 = new Route(STOP3, STOP2, STOP3, STOP1);
    public static final Route ROUTE3 = new Route(STOP4, STOP2, STOP3, STOP4, STOP5);

    @Nested
    class A_driver {
        private Driver driver;

        @BeforeEach
        void setup() {
            driver = new Driver(ROUTE1);
        }

        @Nested
        class Is_at_start_point {
            @Test
            void should_have_one_gossip() {
                assertThat(driver.getKnownGossipSet()).hasSize(1);
            }

            @Test
            void should_have_two_gossip_when_told_by_another_starting_driver() {
                Driver anotherDriver = new Driver(null);
                driver.isToldGossipBy(anotherDriver);
                assertThat(driver.getKnownGossipSet()).hasSize(2);
            }

            @Test
            void should_have_same_route_when_first_route_is_same_as_route2_starting_driver() {
                Driver anotherDriver = new Driver(ROUTE2);
                assertThat(driver.hasSameCurrentStopAs(anotherDriver)).as("has same current stop as route2").isTrue();
            }

            @Test
            void should_not_have_same_route_when_first_route_is_same_as_route3_starting_driver() {
                Driver anotherDriver = new Driver(ROUTE3);
                assertThat(driver.hasSameCurrentStopAs(anotherDriver)).as("has same current stop as route3").isFalse();
            }
        }
    }
}
