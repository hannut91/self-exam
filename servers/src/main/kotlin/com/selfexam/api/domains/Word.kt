package com.selfexam.api.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Word(
        @Id
        @GeneratedValue
        var id: Long = 0,

        var answerId: Long = 0,

        var word: String = ""
)
