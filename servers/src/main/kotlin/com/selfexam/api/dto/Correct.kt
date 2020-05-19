package com.selfexam.api.dto

data class Correct(
        val wordId: Long,
        val isCorrect: Boolean,
        val word: String = ""
)
