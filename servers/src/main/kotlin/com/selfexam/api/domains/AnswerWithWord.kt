package com.selfexam.api.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class AnswerWithWord(
        @Id
        @GeneratedValue
        var id: Long = 0,

        @field:NotNull
        var questionId: Long = 0,

        var answer: String = "",

        @field:NotNull
        var wordId: Long = 0,

        @field:Positive
        var answerOrder: Int = 0
)
