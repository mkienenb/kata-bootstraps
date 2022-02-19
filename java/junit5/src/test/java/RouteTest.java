import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RouteTest {

    @Nested
    class Route_with_one_stop_of_one {
        private Route route;

        @BeforeEach
        void setup() {
            route = new Route(1);
        }

        @Nested
        class Is_at_start_point {
            @Test
            void should_have_current_stop_of_one() {
                assertThat(route.getCurrentStop()).isEqualTo(1);
            }
        }
    }

    @Nested
    class Route_with_two_stops_of_three_and_four {
        private Route route;

        @BeforeEach
        void setup() {
            route = new Route(3, 4);
        }

        @Nested
        class Is_at_start_point {
            @Test
            void should_have_current_stop_of_three() {
                assertThat(route.getCurrentStop()).isEqualTo(3);
            }
        }
    }
}
