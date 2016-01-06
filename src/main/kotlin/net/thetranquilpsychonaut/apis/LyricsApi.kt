package net.thetranquilpsychonaut.apis

import net.thetranquilpsychonaut.config.KeyProps
import net.thetranquilpsychonaut.models.GetLyricsRequestItem
import net.thetranquilpsychonaut.models.acoustid.GetLyricsResponseItem
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Entity
import javax.ws.rs.core.Form
import javax.ws.rs.core.MediaType

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
            @FormParam("fingerprint") fingerprint: String): GetLyricsResponseItem {

        val requestItem = GetLyricsRequestItem(duration, fingerprint)
        val client = ClientBuilder.newClient()
        val target = client.target("http://api.acoustid.org/v2/lookup")
        val form = Form()
        form.param("duration", requestItem.duration.toString())
        form.param("fingerprint", requestItem.fingerprint)
        form.param("client", mKeyProps.getAcoustidApiKey())
        val entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED)
        val response = target.request(MediaType.APPLICATION_JSON)
                .post(entity, GetLyricsResponseItem::class.java)
        return response
    }
}
