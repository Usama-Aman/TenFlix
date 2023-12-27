package com.sam.tenflix.data.remote.dto

import com.sam.tenflix.domain.model.MoviesModel
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Serializable
data class MoviesResponseDTO(
    @SerialName("dates")
    var dates: DatesDTO? = null,
    @SerialName("page")
    var page: Int? = null,
    @SerialName("results")
    var results: List<MoviesDTO> = emptyList(),
    @SerialName("total_pages")
    var totalPages: Int? = null,
    @SerialName("total_results")
    var totalResults: Int? = null
)

@Serializable
data class MoviesDTO(
    @SerialName("adult")
    var adult: Boolean? = null,
    @SerialName("backdrop_path")
    var backdropPath: String? = null,
    @SerialName("genre_ids")
    var genreIds: List<Int?>? = null,
    @SerialName("id")
    var id: Int? = null,
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
    @SerialName("release_date")
    var releaseDate: String? = null,
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
data class DatesDTO(
    @SerialName("maximum")
    var maximum: String? = null,
    @SerialName("minimum")
    var minimum: String? = null
)
