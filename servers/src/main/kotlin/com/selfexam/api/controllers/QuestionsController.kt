package com.selfexam.api.controllers

import com.selfexam.api.applications.QuestionService
import com.selfexam.api.applications.WordService
import com.selfexam.api.domains.Words
import com.selfexam.api.dto.Correct
import org.springframework.web.bind.annotation.*

@RestController
class QuestionsController(
        private val questionService: QuestionService,
        private val wordService: WordService
) {

    @GetMapping("/questions")
    fun questions() = questionService.getQuestions()

    @PostMapping("/questions/{questionId}/corrects")
    fun corrects(
            @PathVariable("questionId") questionId: Long,
            @RequestBody resource: Words
    ): List<Correct> {
        val words = wordService.getWordsWith(questionId)
        return words.checkCorrects(resource)
    }

}
