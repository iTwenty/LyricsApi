package net.thetranquilpsychonaut

import com.google.inject.Module
import com.squarespace.jersey2.guice.JerseyGuiceServletContextListener
import net.thetranquilpsychonaut.modules.ApiModule
import net.thetranquilpsychonaut.modules.DataModule
import java.util.*

/**
 * Created by Jaydeep Joshi on 04 Jan 2016.
 */
class ServletConfig : JerseyGuiceServletContextListener() {

    override fun modules(): List<Module> {
        val modules = ArrayList<Module>()
        modules.add(ApiModule())
        modules.add(DataModule())
        return modules
    }
}