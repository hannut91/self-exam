package com.selfexam.api.domains

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class AnswerWithoutWordRepositoryImpl : AnswerWithoutWordRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun findAll(): List<AnswerWithoutWord> = jdbcTemplate.query(
            "SELECT * FROM answer_without_word "
    ) { rs, _ ->
        AnswerWithoutWord(
                id = rs.getLong("id"),
                questionId = rs.getLong("questionId")
//                wordOrder = rs.getInt("wordOrder")
        )
    }

}
