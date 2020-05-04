package com.selfexam.api.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordTests {

    val word = "단어"

    @Test
    fun `isCorrect with string equal to word returns true`() {
        val w = Word(word = word)

        assertThat(w.isCorrect(word)).isTrue()
    }

    @Test
    fun `isCorrect with string not equal to word returns false`() {
        val w = Word(word = word)

        assertThat(w.isCorrect("DIFFERENT")).isFalse()
    }

}
