package net.thetranquilpsychonaut.apis

import com.google.inject.Inject
import net.thetranquilpsychonaut.config.KeyProps
import org.glassfish.jersey.server.ClientBinding
import javax.ws.rs.*
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Entity
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.Form
import javax.ws.rs.core.MediaType
import kotlin.collections.forEach

@Path("lyrics")
class LyricsApi {

    val mKeyProps: KeyProps

    @Inject
    constructor(keyProps: KeyProps) {
        mKeyProps = keyProps
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    fun getLyrics(
            @FormParam("duration") duration: Long,
            @FormParam("fingerprint") fingerprint: String): String {

        val client = ClientBuilder.newClient()
        val target = client.target("http://api.acoustid.org/v2/lookup")
        val form = Form()
        form.param("duration", duration.toString())
        form.param("fingerprint", fingerprint)
        form.param("client", mKeyProps.getAcoustidApiKey())
        form.asMap().forEach { entry -> print("${entry.key} -> ${entry.value}") }
        val response = target.request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String::class.java)
        return response
    }
}
