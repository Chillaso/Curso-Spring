package com.cgg.rentacar.controller

import javassist.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.format.DateTimeParseException

@ControllerAdvice("com.cgg.rentacar.controller")
@ResponseBody
class ControllerExceptionAdvicer
{
    @ExceptionHandler(NotFoundException::class, NullPointerException::class, NoSuchElementException::class)
    fun notFoundException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    /**
     * Excepcion para cuando recibimos unos argumentos que no corresponden con el metodo que estamos usando.
     */
    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message, HttpHeaders() ,HttpStatus.BAD_REQUEST)

    @ExceptionHandler(DateTimeParseException::class)
    fun dateTimeParseException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)
}









