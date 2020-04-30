package com.selfexam.api.domains

class Answer(
        var id: Long = 0,

        var questionId: Long = 0,

        var answer: String = "",

        var wordOrder: Int = 0,

        var word: String = ""
)
