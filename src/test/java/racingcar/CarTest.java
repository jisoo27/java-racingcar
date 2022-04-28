package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomStrategy;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car("jisu", 3);

    @Test
    @DisplayName("최대 이동거리 구하기 테스트")
    void calMaxMovement() {
        assertThat(car.getMaxPosition(2)).isEqualTo(3);
        assertThat(car.getMaxPosition(4)).isEqualTo(4);
    }

    @Test
    @DisplayName("최대 이동거리의 유무 테스트")
    void maxMovementTest() {
        int max = 3;
        assertThat(new Car("mina", 3).isWinner(max)).isTrue();
        assertThat(new Car("suji", 2).isWinner(max)).isFalse();
    }

    @Test
    @DisplayName("랜덤 전략을 사용한 자동차 전진 테스트")
    void moveTest() {
        car.moveOrStop(new RandomStrategy() {
            @Override
            public boolean checkCondition() {
                return true;
            }
        });
        assertThat(car.getMovement()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 전략을 사용한 자동차 멈춤 테스트")
    void stopTest() {
        car.moveOrStop(new RandomStrategy() {
            @Override
            public boolean checkCondition() {
                return false;
            }
        });
        assertThat(car.getMovement()).isEqualTo(0);
    }

}
