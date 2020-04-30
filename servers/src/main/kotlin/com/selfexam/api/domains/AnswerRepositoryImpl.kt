package com.selfexam.api.domains

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class AnswerRepositoryImpl : AnswerRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun findAll(questionId: Long): List<Answer> = jdbcTemplate.query(
            """
SELECT 
	0 as answer_id, 
    answer_order, 
    answer, 
    "" as word 
FROM 
	answers_without_word
WHERE
    question_id = ?
UNION SELECT 
	answer_id, 
    answer_order, 
    answer, 
    word 
FROM (
    SELECT 
		answers_with_word.id as answer_id, 
		answer_order, 
		answer, 
        word_id
	FROM 
		answers_with_word 
	WHERE
		question_id = ?
) f0 
JOIN 
    words 
ON 
f0.word_id = words.id;

""", arrayOf<Any>(questionId, questionId)
    ) { rs, _ ->
        Answer(
                answerId = rs.getLong("answer_id"),
                answer = rs.getString("answer"),
                answerOrder = rs.getInt("answer_order"),
                word = rs.getString("word")
        )
    }

}
