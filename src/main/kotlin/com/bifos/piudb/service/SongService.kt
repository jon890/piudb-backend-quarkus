package com.bifos.piudb.service

import com.bifos.piudb.domain.entity.Song
import com.bifos.piudb.domain.repository.SongRepository
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped

interface SongService {

    fun findOne(id: Long) : Uni<Song>
    fun findAll() : Uni<List<Song>>
}

@ApplicationScoped
class DefaultSongService(private val songRepository: SongRepository) : SongService {

    @ReactiveTransactional
    override fun findOne(id: Long) : Uni<Song> {
        return songRepository.findById(id)
    }

    @ReactiveTransactional
    override fun findAll() : Uni<List<Song>> {
         return songRepository.findAll().list()
    }
}