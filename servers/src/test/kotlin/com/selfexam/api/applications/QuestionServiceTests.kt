package com.selfexam.api.applications

import com.selfexam.api.domains.Question
import com.selfexam.api.domains.QuestionRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class QuestionServiceTests {

    private lateinit var questionService: QuestionService

    @Mock
    private lateinit var questionRepository: QuestionRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        questionService = QuestionService(questionRepository)
    }

    @Test
    fun `getQuestions returns all questions`() {
        val question = "질문1"
        val mockQuestions = arrayListOf(Question(id = 1L, question = question))
        given(questionRepository.findAll()).willReturn(mockQuestions)

        val questions = questionService.getQuestions()

        assertThat(questions[0].id).isEqualTo(1L)
        assertThat(questions[0].question).isEqualTo(question)
    }

}