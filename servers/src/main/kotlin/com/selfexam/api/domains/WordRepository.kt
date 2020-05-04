package com.selfexam.api.domains

interface WordRepository {

    fun findOne(id: Long): Word?

}
