package study.following.tutorial.youtube.thenewboston.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Nested
    @DisplayName("Index: get all banks")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class Index {
        @Test
        fun `should return all banks`() {
            //when / then
            mockMvc.get("/api/banks")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountNumber") { value("0001") }
                }
        }
    }

    @Nested
    @DisplayName("Show: get a single bank")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class Show {
        @Test
        fun `should return an account for a given account number`() {
            //given
            val accountNumber = "0001"

            //when / then
            mockMvc.get("/api/banks/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.transactionFee") { value("3") }
                    jsonPath("$.trust") { value("30.0") }
                }
        }

        @Test
        fun `should return NOT_FOUND for an account number that doesn't exist`() {
            // given
            val accountNumber = "does_not_exist"

            // when / then
            mockMvc.get("/api/banks/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        }
    }
}
