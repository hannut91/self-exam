package com.selfexam.api.controllers

import com.selfexam.api.applications.QuestionService
import com.selfexam.api.domains.Question
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

@WebMvcTest(QuestionsController::class)
internal class QuestionControllerTests {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var questionService: QuestionService

    @Test
    fun `Questions responses questions`() {
        val question = "질문1"
        val questions = arrayListOf(Question(question = question))
        given(questionService.getQuestions()).willReturn(questions)

        mvc.perform(get("/questions"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString(question)))
    }

}