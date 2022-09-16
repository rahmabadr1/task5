package com.iittii.task5.model

import kotlin.Array
import kotlin.Boolean
import kotlin.Number
import kotlin.String

data class Filmresponse(
    val page: Int,
    val results: Array<Results>,
    val total_pages: Int,
    val total_results: Int
)

data class Results(

    val backdrop_path: String,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val vote_average: Double,
    val title: String,



)