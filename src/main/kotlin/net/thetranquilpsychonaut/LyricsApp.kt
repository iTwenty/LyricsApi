package net.thetranquilpsychonaut

import net.thetranquilpsychonaut.providers.JerseyObjectMapperProvider

import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig

/**
 * Created by Jaydeep Joshi on 06 Jan 2016.
 */
class LyricsApp : ResourceConfig(JerseyObjectMapperProvider::class.java, JacksonFeature::class.java) {

    init {
        packages("net.thetranquilpsychonaut.apis")
    }
}
