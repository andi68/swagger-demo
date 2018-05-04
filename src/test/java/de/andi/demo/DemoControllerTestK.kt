package de.andi.demo

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTestK {

    @Autowired
    internal var restTemplate: TestRestTemplate? = null

    @Test
    fun testHelloWorld() {
        val entity = restTemplate!!.getForEntity<String>("/hello")
        assertEquals("hello world", entity.body)
    }

}
