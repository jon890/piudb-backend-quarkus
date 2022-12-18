package com.bifos.piudb.domain.repository

import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@QuarkusTest
class SongRepositoryTest {

    @InjectMock
    private lateinit var repository: SongRepository

    @Test
    fun testPanacheRepositoryMocking() {
        Assertions.assertEquals(0, repository.count().await().indefinitely())
    }
}