package com.selfexam.api.domains

import org.springframework.data.repository.Repository

interface AnswerWithoutWordRepository : Repository<AnswerWithoutWord, Long> {

    fun findAll(): List<AnswerWithoutWord>

}
