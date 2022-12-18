package com.bifos.piudb.web.resource

import com.bifos.piudb.service.SongService
import com.bifos.piudb.web.dto.ApiResponse
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/api/v1/songs")
@Produces(MediaType.APPLICATION_JSON)
class SongsResource(
    private val songService: SongService
) {

    @GET
    @Path("/{id}")
    fun findOne(@QueryParam("id") id: Long): ApiResponse<*> {
        return ApiResponse.ok(data = songService.findOne(id), message = "find one song")
    }

    @GET
    fun findAll(): ApiResponse<*> {
        return ApiResponse.ok(data = songService.findAll(), message = "find all songs")
    }
}