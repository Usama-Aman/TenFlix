package com.sam.tenflix.data.remote.dto
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class MovieDetailDTO(
    @SerialName("adult")
    var adult: Boolean? = null,
    @SerialName("backdrop_path")
    var backdropPath: String? = null,
    @SerialName("belongs_to_collection")
    var belongsToCollection: BelongsToCollectionDTO? = null,
    @SerialName("budget")
    var budget: Int? = null,
    @SerialName("genres")
    var genres: List<GenreDTO> = listOf(),
    @SerialName("homepage")
    var homepage: String? = null,
    @SerialName("id")
    var id: Int? = null,
    @SerialName("imdb_id")
    var imdbId: String? = null,
    @SerialName("original_language")
    var originalLanguage: String? = null,
    @SerialName("original_title")
    var originalTitle: String? = null,
    @SerialName("overview")
    var overview: String? = null,
    @SerialName("popularity")
    var popularity: Double? = null,
    @SerialName("poster_path")
    var posterPath: String? = null,
    @SerialName("production_companies")
    var productionCompanies: List<ProductionCompanyDTO> = listOf(),
    @SerialName("production_countries")
    var productionCountries: List<ProductionCountryDTO> = listOf(),
    @SerialName("release_date")
    var releaseDate: String? = null,
    @SerialName("revenue")
    var revenue: Int? = null,
    @SerialName("runtime")
    var runtime: Int? = null,
    @SerialName("spoken_languages")
    var spokenLanguages: List<SpokenLanguageDTO> = listOf(),
    @SerialName("status")
    var status: String? = null,
    @SerialName("tagline")
    var tagline: String = "",
    @SerialName("title")
    var title: String? = null,
    @SerialName("video")
    var video: Boolean? = null,
    @SerialName("vote_average")
    var voteAverage: Double? = null,
    @SerialName("vote_count")
    var voteCount: Int? = null
)

@Serializable
data class BelongsToCollectionDTO(
    @SerialName("backdrop_path")
    var backdropPath: String? = null,
    @SerialName("id")
    var id: Int? = null,
    @SerialName("name")
    var name: String? = null,
    @SerialName("poster_path")
    var posterPath: String? = null
)

@Serializable
data class GenreDTO(
    @SerialName("id")
    var id: Int? = null,
    @SerialName("name")
    var name: String = ""
)

@Serializable
data class ProductionCompanyDTO(
    @SerialName("id")
    var id: Int? = null,
    @SerialName("logo_path")
    var logoPath: String? = null,
    @SerialName("name")
    var name: String? = null,
    @SerialName("origin_country")
    var originCountry: String? = null
)

@Serializable
data class ProductionCountryDTO(
    @SerialName("iso_3166_1")
    var iso31661: String? = null,
    @SerialName("name")
    var name: String? = null
)

@Serializable
data class SpokenLanguageDTO(
    @SerialName("english_name")
    var englishName: String? = null,
    @SerialName("iso_639_1")
    var iso6391: String? = null,
    @SerialName("name")
    var name: String? = null
)