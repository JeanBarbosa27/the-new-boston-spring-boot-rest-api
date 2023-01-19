package study.following.tutorial.youtube.thenewboston.dataSource.mock

import org.springframework.stereotype.Repository
import study.following.tutorial.youtube.thenewboston.dataSource.BankDataSource
import study.following.tutorial.youtube.thenewboston.model.Bank

@Repository
class MockBankDataSource: BankDataSource {
    private val banks = listOf(
        Bank("0001", 3, 30.0),
        Bank("0002", 0, 73.0),
        Bank("0003", 15, 0.0),
    )
    override fun retrieveBanks() = banks

    override fun retrieveBank(accountNumber: String) =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Couldn't find a bank with the account number $accountNumber")
}
