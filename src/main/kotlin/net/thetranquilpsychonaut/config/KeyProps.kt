package net.thetranquilpsychonaut.config

import java.util.*

/**
 * Created by Jaydeep Joshi on 04 Jan 2016.
 */
class KeyProps {

    private val mKeyProperties: Properties

    constructor() {
        mKeyProperties = Properties()
        val input = javaClass.classLoader.getResourceAsStream("properties/key.properties")
        mKeyProperties.load(input)
    }

    fun getAcoustidApiKey() = mKeyProperties.getProperty(Keys.ACOUSTID_API_KEY)
}

object Keys {
    val ACOUSTID_API_KEY = "ACOUSTID_API_KEY"
}