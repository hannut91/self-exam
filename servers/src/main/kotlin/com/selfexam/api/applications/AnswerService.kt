package com.selfexam.api.applications

import com.selfexam.api.domains.AnswerRepository
import org.springframework.stereotype.Service

@Service
class AnswerService(
        private val answerRepository: AnswerRepository
) {

    fun getAnswers(questionId: Long) = answerRepository.findAll(questionId)

}
