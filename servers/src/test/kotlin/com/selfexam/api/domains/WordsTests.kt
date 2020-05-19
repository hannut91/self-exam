package com.selfexam.api.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordsTests {

    @Test
    fun `checkCorrect returns corrects`() {
        val mockWords = listOf(
                Word(id = 1, word = "단어"),
                Word(id = 2, word = "답변")
        )

        val words = Words(mockWords)
        val corrects = words.checkCorrects(Words(mockWords))

        corrects.forEach { assertThat(it.isCorrect).isTrue() }
    }

    @Test
    fun `checkCorrect returns corrects has false`() {
        val mockWords = listOf(
                Word(id = 1, word = "단어"),
                Word(id = 2, word = "답변")
        )

        val targetWords = listOf(
                Word(id = 1, word = "DIFFERENT")
        )

        val words = Words(mockWords)
        val corrects = words.checkCorrects(Words(targetWords))

        corrects.forEach { assertThat(it.isCorrect).isFalse() }
    }
}