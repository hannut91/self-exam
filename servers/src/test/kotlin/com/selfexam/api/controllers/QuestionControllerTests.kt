package com.selfexam.api.controllers

import com.google.gson.Gson
import com.selfexam.api.applications.QuestionService
import com.selfexam.api.applications.WordService
import com.selfexam.api.domains.Question
import com.selfexam.api.domains.Word
import com.selfexam.api.domains.Words
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(QuestionsController::class)
internal class QuestionControllerTests {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var questionService: QuestionService

    @MockBean
    private lateinit var wordService: WordService

    @Test
    fun `questions responses questions`() {
        val question = "질문1"
        val questions = arrayListOf(Question(question = question))
        given(questionService.getQuestions()).willReturn(questions)

        mvc.perform(get("/questions"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString(question)))
    }

    @Test
    fun `corrects responses corrects`() {
        val questionId = 1L
        val words = Words(listOf(Word(word = "단어"), Word(word = "시험")))

        given(wordService.getWordsWith(questionId)).willReturn(words)

        mvc.perform(post("/questions/$questionId/corrects")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"words\": ${Gson().toJson(words.words)}}"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("true")))
    }

}
