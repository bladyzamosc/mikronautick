package com.bladyzamosc.mikronaucik.controller

import com.bladyzamosc.mikronaucik.service.PartyService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/parties")
class PartyController {

    @Inject
    lateinit var partyService: PartyService

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Get(value = "/", produces = [MediaType.TEXT_PLAIN])
    fun getTest(): String? {
        return "some string"
    }

    @Get(uri = "/{partyId}")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun loadSimulator(partyId: String): HttpResponse<Any> {
        val correlationId = UUID.randomUUID()
        val httpResponse: HttpResponse<Any>
        logger.info("Processing request {}", correlationId)
        // val validationResult = validator.validate(Party(resourceId))
        // validationResult.isValid
        val valid = true
        httpResponse = if (valid) {
            val response = partyService.processLoad(partyId)
            HttpResponse.status<Any>(HttpStatus.OK).body<Any>(response)
        } else {
            // validationResult.errors
            HttpResponse.status<Any>(HttpStatus.BAD_REQUEST).body<Any>("Errors")
        }
        logger.info("Finished Processing {}", correlationId)

        return httpResponse
    }
}