package com.example.auth.controller

import com.example.auth.model.LoginRequest
import com.example.auth.model.LoginResponse
import com.example.auth.security.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        return if (request.username == "admin" && request.password == "admin123") {
            val token = JwtUtil.generateToken(request.username)
            ResponseEntity.ok(LoginResponse(token, "Admin login successful"))
        } else {
            ResponseEntity.status(401).body(mapOf("message" to "Invalid credentials"))
        }
    }
}
