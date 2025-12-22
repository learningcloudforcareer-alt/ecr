package com.example.auth.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*

object JwtUtil {

    private val secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    private const val EXPIRATION_TIME = 60 * 60 * 1000

    fun generateToken(username: String): String {
        val now = Date()
        val expiryDate = Date(now.time + EXPIRATION_TIME)

        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(secretKey)
            .compact()
    }
}
