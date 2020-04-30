package com.selfexam.api.domains

interface AnswerRepository {

    fun findAll(questionId: Long): List<Answer>

}
