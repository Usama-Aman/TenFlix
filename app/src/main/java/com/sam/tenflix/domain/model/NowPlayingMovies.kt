package com.sam.tenflix.domain.model

data class NowPlayingMovies(
    var adult: Boolean? = null,
    var genreIds: List<Int?>? = null,
    var id: Int? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
)