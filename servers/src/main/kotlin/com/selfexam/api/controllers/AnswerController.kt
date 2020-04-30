package com.selfexam.api.controllers

import com.selfexam.api.applications.AnswerService
import com.selfexam.api.domains.Answer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AnswerController(private val answerService: AnswerService) {

    @GetMapping("/answers/{questionId}")
    fun getAnswers(
            @PathVariable("questionId") questionId: Long
    ): List<Answer> = answerService.getAnswers(questionId)

}
