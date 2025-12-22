package com.example.auth.controller

import com.example.auth.model.LoginRequest
import com.example.auth.model.LoginResponse
import com.example.auth.security.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("test")
class GetController {

    @GetMapping("/1")
    fun login(): ResponseEntity<Any> {
           return ResponseEntity.ok("Admin login successful")
        }
    }