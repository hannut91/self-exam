package com.selfexam.api.domains

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class AnswerRepositoryImpl : AnswerRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun findAll(questionId: Long): List<Answer> = jdbcTemplate.query(
            "SELECT * FROM answer_without_word "
    ) { rs, _ ->
        Answer(
                id = rs.getLong("id"),
                questionId = rs.getLong("questionId"),
                answer = rs.getString("answer"),
                wordOrder = rs.getInt("wordOrder")
        )
    }

}
