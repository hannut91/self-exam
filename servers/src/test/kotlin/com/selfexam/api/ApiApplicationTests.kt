package com.selfexam.api

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
object CalculatorSpec : Spek({
    describe("A calculator") {
        describe("addition") {
            it("returns the sum of its arguments") {
                assertThat(1 + 2).isEqualTo(3)
            }
        }
    }
})
