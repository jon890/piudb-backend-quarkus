package com.bifos.piudb.web.dto

import java.time.LocalDateTime

/**
 * Api 기본 응답 객체
 * 필요한 데이터, 코드, 메시지를 담아서 응답으로 반환할 때 사용한다
 *
 * @author BiFoS
 * @since 2022-12-18
 */
class ApiResponse<T>(
    val code: Int,
    val timestamp: LocalDateTime,
    val data: T?,
    val message: String?
) {

    companion object {
        fun <T> ok(code: Int = 200, data: T?, message: String?): ApiResponse<T> {
            return ApiResponse(
                code = code,
                timestamp = LocalDateTime.now(),
                data = data,
                message = message
            )
        }
    }
}