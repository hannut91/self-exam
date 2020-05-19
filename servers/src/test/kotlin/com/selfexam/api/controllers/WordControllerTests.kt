package com.selfexam.api.controllers

import com.selfexam.api.applications.WordService
import com.selfexam.api.domains.Word
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(WordController::class)
internal class WordControllerTests {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var wordService: WordService

    @Test
    fun `isCorrect with correct word responses true`() {
        val wordId = 1L
        val word = Word(word = "관계")
        given(wordService.getWord(wordId)).willReturn(word)

        mvc.perform(get("/words/$wordId?word=${word.word}"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("true")))
    }

    @Test
    fun `isCorrect with incorrect word responses false`() {
        val wordId = 1L
        val word = Word(word = "관계")
        given(wordService.getWord(wordId)).willReturn(word)

        mvc.perform(get("/words/$wordId?word=OTHER"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("false")))
    }

    @Test
    fun `isCorrect not existing word responses 404 error`() {
        val wordId = 1L
        given(wordService.getWord(wordId)).willReturn(null)

        mvc.perform(get("/words/$wordId?word=word"))
                .andExpect(status().isNotFound)
    }
}
