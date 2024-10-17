package com.example.cursoSBP.controller

import com.example.cursoSBP.model.Banco
import com.example.cursoSBP.servicios.ServicioBanco
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/api/bank")
class ControllerBanco(private val service: ServicioBanco) {
    @GetMapping fun getbanco():Collection<Banco> = service.getBancos()

    @GetMapping("/{accountNumber}") fun getbanco(@PathVariable accountNumber:String):Banco=service.getBanco(accountNumber)

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    fun insertarBancos(@RequestBody banco: Banco):Banco=service.insertarBanco(banco)

    @PatchMapping fun modificarBanco(@RequestBody banco: Banco):Banco=service.modificarBanco(banco)

    @DeleteMapping("/{accountNumber}") @ResponseStatus(HttpStatus.NO_CONTENT)
    fun eliminarBanco(@PathVariable accountNumber: String):Unit=service.eliminarBanco(accountNumber)
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e:NoSuchElementException):
            ResponseEntity<String> = ResponseEntity(e.message,HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e:NoSuchElementException):
            ResponseEntity<String> = ResponseEntity(e.message,HttpStatus.BAD_REQUEST)

}