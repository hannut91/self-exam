package com.selfexam.api.applications

import com.selfexam.api.domains.Word
import com.selfexam.api.domains.WordRepository
import com.selfexam.api.domains.Words
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class WordServiceTests {

    private lateinit var wordService: WordService

    @Mock
    private lateinit var wordRepository: WordRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        wordService = WordService(wordRepository)
    }

    @Test
    fun `getWord returns word by word string`() {
        val mockWord = Word(word = "단어")

        given(wordRepository.findOne(1)).willReturn(mockWord)

        val word = wordService.getWord(1)

        assertThat(word?.word).isEqualTo("단어")
    }

    @Test
    fun `getWordsWith returns words`() {
        val questionId = 1L

        val mockWords = Words(listOf(Word(word = "단어")))
        given(wordRepository.findWith(questionId)).willReturn(mockWords)

        val words = wordService.getWordsWith(questionId)

        assertThat(words).isEqualTo(mockWords)
    }
}
