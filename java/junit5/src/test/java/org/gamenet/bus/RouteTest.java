package org.gamenet.bus;

import org.gamenet.bus.Route;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RouteTest {

    public static final Stop STOP_1 = Stop.of(1);
    public static final Stop STOP_3 = Stop.of(3);
    public static final Stop STOP_4 = Stop.of(4);

    @Nested
    class Route_with_one_stop_of_one {
        private Route route;

        @Test
        void should_throw_exception_when_route_is_created_without_stop() {
            assertThatThrownBy(Route::new);
        }

        @BeforeEach
        void setup() {
            route = new Route(STOP_1);
        }

        @Nested
        class At_start_point {
            @Test
            void should_have_current_stop_of_one() {
                assertThat(route.getCurrentStop()).isEqualTo(STOP_1);
            }
        }

        @Nested
        class After_proceeding_to_next_stop {
            @BeforeEach
            void setup() {
                route.proceedToNextStop();
            }

            @Test
            void should_have_current_stop_of_one() {
                assertThat(route.getCurrentStop()).isEqualTo(STOP_1);
            }
        }
    }

    @Nested
    class Route_with_two_stops_of_three_and_four {
        private Route route;

        @BeforeEach
        void setup() {
            route = new Route(STOP_3, STOP_4);
        }

        @Nested
        class At_start_point {
            @Test
            void should_have_current_stop_of_three() {
                assertThat(route.getCurrentStop()).isEqualTo(STOP_3);
            }
        }

        @Nested
        class After_proceeding_to_next_stop {
            @BeforeEach
            void setup() {
                route.proceedToNextStop();
            }

            @Test
            void should_have_current_stop_of_four() {
                assertThat(route.getCurrentStop()).isEqualTo(STOP_4);
            }
        }
    }
}
