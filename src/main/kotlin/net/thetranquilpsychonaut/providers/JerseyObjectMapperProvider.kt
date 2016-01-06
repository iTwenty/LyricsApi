package net.thetranquilpsychonaut.providers

import com.fasterxml.jackson.databind.ObjectMapper

import javax.inject.Inject
import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider

/**
 * Created by Jaydeep Joshi on 06 Jan 2016.
 */
@Provider
class JerseyObjectMapperProvider
@Inject
constructor(private val mObjectMapper: ObjectMapper) : ContextResolver<ObjectMapper> {

    override fun getContext(type: Class<*>): ObjectMapper {
        return mObjectMapper
    }
}
