package study.following.tutorial.youtube.thenewboston.dataSource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {
    @Test
    fun `should provide a collection of all banks`() {
        val mockBankDataSource = MockBankDataSource()

        // when
        val banks = mockBankDataSource.retrieveBanks()

        // then
        Assertions.assertThat(banks).hasSizeGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        val mockBankDataSource = MockBankDataSource()

        // when
        val banks = mockBankDataSource.retrieveBanks()

        // then
        Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).anyMatch { it.transactionFee != 0 }
        Assertions.assertThat(banks).anyMatch { it.trust != 0.0 }
    }
}
