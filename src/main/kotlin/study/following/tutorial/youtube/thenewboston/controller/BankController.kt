package study.following.tutorial.youtube.thenewboston.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import study.following.tutorial.youtube.thenewboston.model.Bank
import study.following.tutorial.youtube.thenewboston.service.BankService

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(exception: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(exception.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun index(): Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun show(@PathVariable accountNumber: String): Bank = service.getBank(accountNumber)
}