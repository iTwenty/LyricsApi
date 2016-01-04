package net.thetranquilpsychonaut.modules

import com.google.inject.servlet.ServletModule
import net.thetranquilpsychonaut.config.KeyProps
import javax.inject.Singleton

/**
 * Created by Jaydeep Joshi on 04 Jan 2016.
 */
class ApiModule : ServletModule() {

    override fun configureServlets() {
        bind(KeyProps::class.java).`in`(Singleton::class.java)
    }
}
