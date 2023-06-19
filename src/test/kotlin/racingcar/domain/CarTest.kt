package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.move.StaticMoveStrategy

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car(name = "name", movable = StaticMoveStrategy())
    }

    @Test
    fun `자동차는 위치가 0으로 초기화`() {
        assertThat(car.location).isEqualTo(0)
    }

    @Test
    fun `자동차는 이름이 name으로 초기화`() {
        assertThat(car.name).isEqualTo("name")
    }

    @Test
    fun `자동차는 이름이 5글자 미만이여야 한다`() {
        assertThrows<IllegalArgumentException> {
            Car(name = "5글자넘어가는이름", movable = StaticMoveStrategy())
        }
    }

    @Test
    fun `자동차 이동 조건을 만족하면 0에서 1로 이동한다`() {
        car.move()
        assertThat(car.location).isEqualTo(1)
    }
}
