package study.following.tutorial.youtube.thenewboston.dataSource.mock

import org.springframework.stereotype.Repository
import study.following.tutorial.youtube.thenewboston.dataSource.BankDataSource
import study.following.tutorial.youtube.thenewboston.model.Bank

@Repository
class MockBankDataSource: BankDataSource {
    private val banks = mutableListOf(
        Bank("0001", 3, 30.0),
        Bank("0002", 0, 73.0),
        Bank("0003", 15, 0.0),
    )
    override fun retrieveBanks() = banks

    override fun retrieveBank(accountNumber: String) =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Couldn't find a bank with the account number $accountNumber.")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists.")
        }

        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber}
            ?: throw NoSuchElementException(
                "Couldn't update bank with account number ${bank.accountNumber}, because it doesn't exist")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun destroyBank(accountNumber: String) {
        val bankToDestroy = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException(
                "Couldn't destroy bank with account number $accountNumber, because it doesn't exist")

        banks.remove(bankToDestroy)
    }
}
