package org.gamenet.bus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DriverTest {
    @Nested
    class A_driver {
        private Driver driver;

        @BeforeEach
        void setup() {
            driver = new Driver();
        }

        @Nested
        class Is_at_start_point {
            @Test
            void should_have_one_gossip() {
                assertThat(driver.getKnownGossipSet()).hasSize(1);
            }

            @Test
            void should_have_two_gossip_when_told_by_another_starting_driver() {
                Driver anotherDriver = new Driver();
                driver.isToldGossipBy(anotherDriver);
                assertThat(driver.getKnownGossipSet()).hasSize(2);
            }
        }
    }
}