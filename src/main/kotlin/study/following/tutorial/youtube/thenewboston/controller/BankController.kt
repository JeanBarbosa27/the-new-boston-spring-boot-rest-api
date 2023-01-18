package study.following.tutorial.youtube.thenewboston.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.following.tutorial.youtube.thenewboston.model.Bank
import study.following.tutorial.youtube.thenewboston.service.BankService

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {
    @GetMapping
    fun listAllBanks(): Collection<Bank> = service.getBanks()
}