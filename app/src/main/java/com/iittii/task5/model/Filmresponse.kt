package com.iittii.task5.model

import kotlin.Array
import kotlin.Boolean
import kotlin.Number
import kotlin.String

data class Filmresponse(
    val page: Number,
    val results: Array<Results>,
    val total_pages: Number,
    val total_results: Number
)

data class Results(

    val backdrop_path: String,
    val id: Number,
    val overview: String,
    val poster_path: String,
    val vote_average: Number,
    val title: String,



)