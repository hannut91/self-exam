package com.selfexam.api.domains

import com.selfexam.api.dto.Correct

class Words(val words: List<Word> = listOf()) {

    fun checkCorrects(other: Words): List<Correct> = words.map {
        val word = other.words.find { w -> w.id == it.id }
        if (word == null) {
            Correct(wordId = it.id, isCorrect = false)
        } else {
            Correct(
                    wordId = it.id,
                    isCorrect = it.isCorrect(word.word),
                    word = if (it.isCorrect(word.word)) it.word else ""
            )
        }
    }

}
