package restassured

import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.*
import io.restassured.response.ValidatableResponse
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

class RestAssuredExamples {

    private val baseUrl: String = "https://automationintesting.online/room/"
    private var roomNumbers = mutableListOf(101, 102, 201, 301)

    @Test
    fun getRoomTest() {
        val rooms: ValidatableResponse =
            Given {
                queryParam("1")
                accept(ContentType.JSON)
            } When {
                get(baseUrl)
            } Then {
                statusCode(200)
                contentType(ContentType.JSON)
                body("rooms.roomNumber", equalTo(roomNumbers))
            }
    }
}