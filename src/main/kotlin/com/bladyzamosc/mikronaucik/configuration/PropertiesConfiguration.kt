package com.bladyzamosc.mikronaucik.configuration

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("mikronaucik")
class PropertiesConfiguration {

    var processingTime: Long = 0
    var threads: Long = 0
    var returnMessage: String = ""

}