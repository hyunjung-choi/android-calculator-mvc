package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculateOrderTest {

    @Test
    fun getNextCalculateOrderFromNumberFirst() {
        assertThat(CalculateOrder.NUMBER_FIRST.getNextCalculateOrder()).isEqualTo(CalculateOrder.OPERATION)
    }

    @Test
    fun getNextCalculateOrderFromOperation() {
        assertThat(CalculateOrder.OPERATION.getNextCalculateOrder()).isEqualTo(CalculateOrder.NUMBER_SECOND)
    }

    @Test
    fun getNextCalculateOrderFromNumberSecond() {
        assertThat(CalculateOrder.NUMBER_SECOND.getNextCalculateOrder()).isEqualTo(CalculateOrder.CALCULATION)
    }

    @Test
    fun getNextCalculateOrderFromNumberCalculation() {
        assertThat(CalculateOrder.CALCULATION.getNextCalculateOrder()).isEqualTo(CalculateOrder.NUMBER_FIRST)
    }
}