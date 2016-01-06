package net.thetranquilpsychonaut.modules

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.AbstractModule
import com.google.inject.Provides

/**
 * Created by Jaydeep Joshi on 06 Jan 2016.
 */
class DataModule : AbstractModule() {

    override fun configure() {
    }

    @Provides
    fun provideObjectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        return mapper
    }
}
