package net.thetranquilpsychonaut.models.acoustid

import java.io.Serializable
import java.util.*

/**
 * Created by Jaydeep Joshi on 04 Jan 2016.
 */
class GetLyricsResponseItem(var status: String = "", var results: List<ResultItem> = ArrayList()) : Serializable

class ResultItem(var score: Float = 0.0f, var id: String = "") : Serializable