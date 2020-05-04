package com.selfexam.api.domains

class Word(
        val id: Long = 0,

        val word: String = ""
) {
    fun isCorrect(w: String) = w == word
}
