package com.selfexam.api.applications

import com.selfexam.api.domains.WordRepository
import org.springframework.stereotype.Service

@Service
class WordService(private val wordRepository: WordRepository) {

    fun getWord(id: Long) = wordRepository.findOne(id)

    fun getWordsWith(questionId: Long) = wordRepository.findWith(questionId)

}
