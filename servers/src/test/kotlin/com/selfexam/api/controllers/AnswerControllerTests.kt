package com.selfexam.api.controllers

import com.selfexam.api.applications.AnswerService
import com.selfexam.api.domains.Answer
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

@WebMvcTest(AnswerController::class)
internal class AnswerControllerTests {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var answerService: AnswerService

    @Test
    fun `Answer responses answers`() {
        val questionId = 1L
        val answers = listOf(
                Answer(
                        answer = "관계형 모델은 실제 세계의 데이터를",
                        answerOrder = 1
                ),
                Answer(
                        answerId = 1,
                        answer = "라는 개념을 사용해 구현한 데이터 모델이다.",
                        answerOrder = 2,
                        word = "관계"
                )
        )
        given(answerService.getAnswers(questionId)).willReturn(answers)

        mvc.perform(get("/answers/$questionId"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("관계형 모델")))
    }

}
