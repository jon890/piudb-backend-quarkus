package com.bifos.piudb.web.resource

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test


import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`


@QuarkusTest
class SongsResource {

    @Test
    fun test_findOneSong_endpoint() {
        val id = 1

        given()
            .`when`().get("/api/v1/${id}")
            .then()
            .statusCode(200)
    }
}