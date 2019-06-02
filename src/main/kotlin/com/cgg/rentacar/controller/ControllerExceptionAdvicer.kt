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
import java.time.format.DateTimeParseException

@ControllerAdvice("com.cgg.rentacar.controller")
class ControllerExceptionAdvicer
{
    @ExceptionHandler(NotFoundException::class, NullPointerException::class, NoSuchElementException::class)
    fun notFoundException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    /**
     * Excepcion para cuando recibimos unos argumentos que no corresponden con el metodo que estamos usando.
     */
    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message,HttpStatus.BAD_REQUEST)

    @ExceptionHandler(DateTimeParseException::class)
    fun dateTimeParseException(e: Exception): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
}









