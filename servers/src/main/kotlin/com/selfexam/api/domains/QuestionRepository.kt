package com.selfexam.api.domains

interface QuestionRepository {

    fun findAll(): List<Question>

}
