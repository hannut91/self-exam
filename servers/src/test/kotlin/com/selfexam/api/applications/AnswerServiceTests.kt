package com.selfexam.api.applications

import com.selfexam.api.domains.Answer
import com.selfexam.api.domains.AnswerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class AnswerServiceTests {

    private lateinit var answerService: AnswerService

    @Mock
    private lateinit var answerRepository: AnswerRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        answerService = AnswerService(answerRepository)
    }

    @Test
    fun `getAnswers returns answers`() {
        val questionId = 1L
        val mockAnswers = listOf(
                Answer(
                        wordId = 0,
                        answer = "관계형 모델은 실제 세계의 데이터를",
                        answerOrder = 1
                ),
                Answer(
                        wordId = 1,
                        answer = "라는 개념을 사용해 구현한 데이터 모델이다.",
                        answerOrder = 2
                )
        )
        given(answerRepository.findAll(questionId)).willReturn(mockAnswers)

        val answers = answerService.getAnswers(questionId)

        assertThat(answers[0].wordId).isEqualTo(mockAnswers[0].wordId)
        assertThat(answers[1].wordId).isEqualTo(mockAnswers[1].wordId)
    }

}