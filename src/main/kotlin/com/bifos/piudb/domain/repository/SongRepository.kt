package com.bifos.piudb.domain.repository

import com.bifos.piudb.domain.entity.Song
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SongRepository : PanacheRepository<Song> {

}