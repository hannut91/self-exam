package com.selfexam.api.controllers

import com.selfexam.api.applications.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionsController(private val questionService: QuestionService) {

    @GetMapping("/questions")
    fun questions() = questionService.getQuestions()

}
