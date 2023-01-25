package study.following.tutorial.youtube.thenewboston.service

import org.springframework.stereotype.Service
import study.following.tutorial.youtube.thenewboston.dataSource.BankDataSource
import study.following.tutorial.youtube.thenewboston.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)
}
