package study.following.tutorial.youtube.thenewboston.dataSource

import study.following.tutorial.youtube.thenewboston.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
}
