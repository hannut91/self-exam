package com.selfexam.api.domains

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class WordRepositoryImpl : WordRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun findOne(id: Long): Word? {
        val words = jdbcTemplate.query(
                "SELECT * FROM words WHERE id = ?",
                arrayOf<Any>(id)
        ) { rs, _ ->
            Word(id = rs.getLong("id"), word = rs.getString("word"))
        }
        if (words.isEmpty()) {
            return null
        }

        return words.first()
    }

    override fun findWith(questionId: Long): Words {
        val words = jdbcTemplate.query(
                """
SELECT  
	words.id as word_id,     
    word  
FROM (  
	SELECT   
		*  
	FROM   
		answers_with_word  
	WHERE   
		question_id = ? 
	) f0 
JOIN  
	words 
ON  
	f0.word_id = words.id;	

""",
                arrayOf<Any>(questionId)
        ) { rs, _ ->
            Word(
                    id = rs.getLong("word_id"),
                    word = rs.getString("word")
            )
        }
        return Words(words)
    }
}
