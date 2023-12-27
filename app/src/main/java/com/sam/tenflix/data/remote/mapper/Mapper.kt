package com.sam.tenflix.data.remote.mapper

import com.sam.tenflix.data.remote.dto.MovieDetailDTO
import com.sam.tenflix.data.remote.dto.MoviesDTO
import com.sam.tenflix.domain.model.Genre
import com.sam.tenflix.domain.model.MovieDetail
import com.sam.tenflix.domain.model.MoviesModel
import com.sam.tenflix.domain.model.ProductionCompany
import com.sam.tenflix.domain.model.SpokenLanguage

fun MoviesDTO.toMovies(): MoviesModel {
    return MoviesModel(
        adult = adult,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
    )
}


fun MovieDetailDTO.toMovieDetail(): MovieDetail {
    return MovieDetail(
        adult = adult ?: false,
        backdropPath = backdropPath,
//        belongsToCollection = belongsToCollection,
        budget = budget,
        genres = genres
            .map {
                Genre(
                    id = it.id,
                    name = it.name
                )
            },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies
            .map {
                ProductionCompany(
                    id = it.id,
                    logoPath = it.logoPath,
                    name = it.name,
                    originCountry = it.originCountry,
                )
            },
//        productionCountries = productionCountries,
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages
            .map {
                SpokenLanguage(
                    englishName = it.englishName,
                    iso6391 = it.iso6391,
                    name = it.name,
                )
            },
        status = status,
        tagline = tagline,
        title = title ?: "",
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}