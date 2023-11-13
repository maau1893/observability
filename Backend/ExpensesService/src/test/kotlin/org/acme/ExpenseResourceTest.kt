package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@QuarkusTest
class ExpenseResourceTest {

    @Test
    fun testExpensesEndpoint() {
        given()
          .`when`().get("/expenses")
          .then()
             .statusCode(200)
    }

}
