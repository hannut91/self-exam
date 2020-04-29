package com.selfexam.api.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Question(
        @Id
        @GeneratedValue
        var id: Long = 0,

        var question: String = ""
)
