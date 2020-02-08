package com.testers.exam.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @PostMapping("/data")
    fun greeting(@RequestBody input: Input): ResponseEntity<Response> {
        val goodResponse = ResponseEntity.ok().body(Response("Good request"))
        val badResponse = ResponseEntity.badRequest().body(Response("Damn BUG Here!"))
        val containOnlyDigits = input.numbers.chars().allMatch(Character::isDigit) && input.numbers.isNotBlank()

        return if (containOnlyDigits) goodResponse else badResponse
    }

}

data class Input(val numbers: String)
data class Response(val message: String)