package study.following.tutorial.youtube.thenewboston.dataSource

import study.following.tutorial.youtube.thenewboston.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank
    fun updateBank(bank: Bank): Bank
    fun destroyBank(accountNumber: String)
}
