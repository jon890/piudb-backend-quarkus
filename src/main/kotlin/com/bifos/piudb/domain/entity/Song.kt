package com.bifos.piudb.domain.entity

import com.bifos.piudb.domain.constants.PiuVersion
import javax.persistence.*

/**
 * 노래
 */
@Entity
class Song(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val title: String,

    @Column
    val artist: String,

    @Column
    val bpm : Double,

    @Column
    @Enumerated(EnumType.STRING)
    val version : PiuVersion

) {
}