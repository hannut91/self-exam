package com.selfexam.api.domains

class WordNotFoundException(id: Long) :
        RuntimeException("Could not find Word $id")
