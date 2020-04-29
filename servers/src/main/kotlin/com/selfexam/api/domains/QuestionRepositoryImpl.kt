package com.selfexam.api.domains

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class QuestionRepositoryImpl : QuestionRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun findAll(): List<Question> = jdbcTemplate.query(
            "SELECT * FROM question"
    ) { rs, _ ->
        Question(
                id = rs.getLong("id"),
                question = rs.getString("question")
        )
    }

}
