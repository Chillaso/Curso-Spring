package com.cgg.rentacar.controller

import javassist.NotFoundException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import java.lang.Exception
import java.lang.IllegalArgumentException

@ControllerAdvice("com.cgg.rentacar.controller")
class ControllerExceptionAdvicer
{
    val DICK_RESPONSE: String =
            """
....... ▄▄ ▄▄
......▄▌▒▒▀▒▒▐▄
.... ▐▒▒▒▒▒▒▒▒▒▌
... ▐▒▒▒▒▒▒▒▒▒▒▒▌
....▐▒▒▒▒▒▒▒▒▒▒▒▌
....▐▀▄▄▄▄▄▄▄▄▄▀▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
....▐░░░░░░░░░░░▌
...▄█▓░░░░░░░░░▓█▄
..▄▀░░░░░░░░░░░░░ ▀▄
.▐░░░░░░░▀▄▒▄▀░░░░░░▌
▐░░░░░░░▒▒▐▒▒░░░░░░░▌
▐▒░░░░░▒▒▒▐▒▒▒░░░░░▒▌
.▀▄▒▒▒▒▒▄▀▒▀▄▒▒▒▒▒▄▀
.. ▀▀▀▀▀ ▀▀▀▀▀
            """

    @ExceptionHandler(NotFoundException::class, NullPointerException::class, NoSuchElementException::class)
    fun notFoundException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message.plus("\n".plus(DICK_RESPONSE)),
                                                                        HttpStatus.BAD_REQUEST)
}









