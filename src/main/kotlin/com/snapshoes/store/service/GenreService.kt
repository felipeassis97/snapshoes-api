package com.snapshoes.store.service

import org.springframework.stereotype.Service
import com.snapshoes.store.presentation.dtos.GenreDto
import com.snapshoes.store.presentation.mappers.GenreMapper
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.persistense.repositories.GenreRepository

@Service
class GenreService(
    private val genreRepository: GenreRepository,
    private val genreMapper: GenreMapper,

    ) {
    fun getGenres() : List<GenreDto> {
        val genres = genreRepository.findAll()
        return genres.map { e ->  genreMapper.map(e)}
    }

    fun getGenreById(id: Long): GenreDto {
        val genre = genreRepository.findById(id)
            .orElseThrow{NotFoundException("Genre NOT FOUND")}
        return genreMapper.map(genre)
    }
}