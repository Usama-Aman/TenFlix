package com.sam.tenflix.domain.model

import com.sam.tenflix.common.Constants
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


data class MovieDetail(
    var adult: Boolean = false,
    var backdropPath: String? = null,
    var belongsToCollection: BelongsToCollection? = null,
    var budget: Int? = null,
    var genres: List<Genre> = listOf(),
    var homepage: String? = null,
    var id: Int? = null,
    var imdbId: String? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var productionCompanies: List<ProductionCompany> = listOf(),
    var productionCountries: List<ProductionCountry> = listOf(),
    var releaseDate: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var spokenLanguages: List<SpokenLanguage> = listOf(),
    var status: String? = null,
    var tagline: String = "",
    var title: String = "",
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
) {
    val fullPosterPath = "${Constants.IMAGE_URL}/$posterPath"
}


data class BelongsToCollection(
    var backdropPath: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var posterPath: String? = null
)

data class Genre(
    var id: Int? = null,
    var name: String = ""
)

data class ProductionCompany(
    var id: Int? = null,
    var logoPath: String? = null,
    var name: String? = null,
    var originCountry: String? = null
)

data class ProductionCountry(
    var iso31661: String? = null,
    var name: String? = null
)

data class SpokenLanguage(
    var englishName: String? = null,
    var iso6391: String? = null,
    var name: String? = null
)