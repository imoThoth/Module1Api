package com.BootcampApi.openApi

import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OpenApiControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Before
    fun init() {
    }

    @Test
    @Throws(Exception::class)
    fun testGetContent() {
        mockMvc.perform(MockMvcRequestBuilders.get("/airports/1"))
            .andExpect(
                MockMvcResultMatchers.content()
                    .string("00AK\" \"\", \"Lowel Field\", \"Anchor-point\", \"Alaska\", \"US\", \"450\", \"5.959\", \"-151.695999\", \"America")
            )
    }

    @Test
    @Throws(Exception::class)
    fun testGetStatusCode() {
        mockMvc.perform(MockMvcRequestBuilders.get("/airports/1"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun testPutStatusCode() {
        mockMvc.perform(MockMvcRequestBuilders.put("/airports/1"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun doesDataMatch() {
        mockMvc.perform(MockMvcRequestBuilders.put("/airports/1"))
            .andExpect(
                MockMvcResultMatchers.content()
                    .string("\"00AB\", \"\", \"Iawo Field\", \"Anchor-point\", \"Pennsylvania\", \"US\", \"780\", \"5.95912\", \"-150.695999\", \"America\"")
            )
    }

    @Test
    fun deleteAirport() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/airports/1"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun deleteBodyResponse() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/airports/1"))
            .andExpect(
                MockMvcResultMatchers.content()
                    .string("SUCCESS")
            )
    }

    @Test
    fun noIdGiven() {
        mockMvc.perform(MockMvcRequestBuilders.get("/airports"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }
}