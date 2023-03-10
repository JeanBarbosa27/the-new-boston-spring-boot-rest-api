package study.following.tutorial.youtube.thenewboston.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import study.following.tutorial.youtube.thenewboston.model.Bank
import study.following.tutorial.youtube.thenewboston.service.BankService
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(exception: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(exception.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(java.lang.IllegalArgumentException::class)
    fun handleBadRequest(exception: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun index(): Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun show(@PathVariable accountNumber: String): Bank = service.getBank(accountNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody bank: Bank): Bank = service.addBank(bank)

    @PatchMapping
    fun update(@RequestBody bank: Bank): Bank = service.updateBank(bank)

    @DeleteMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun destroy(@PathVariable accountNumber: String): Unit = service.deleteBank(accountNumber)
}