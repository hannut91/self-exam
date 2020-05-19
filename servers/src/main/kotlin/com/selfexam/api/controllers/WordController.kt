package com.selfexam.api.controllers

import com.selfexam.api.applications.WordService
import com.selfexam.api.domains.WordNotFoundException
import com.selfexam.api.dto.Correct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WordController {

    @Autowired
    private lateinit var wordService: WordService

    @GetMapping("/words/{wordId}")
    fun isCorrect(
            @PathVariable("wordId") wordId: Long,
            @RequestParam("word") word: String
    ): Correct {
        val w = wordService.getWord(wordId)
                ?: throw WordNotFoundException(wordId)

        return Correct(wordId = wordId, isCorrect = w.isCorrect(word))
    }

}
