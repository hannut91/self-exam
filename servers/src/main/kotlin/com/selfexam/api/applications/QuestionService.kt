package com.selfexam.api.applications

import com.selfexam.api.domains.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(
        private val questionRepository: QuestionRepository
) {

    fun getQuestions() = questionRepository.findAll()

}
