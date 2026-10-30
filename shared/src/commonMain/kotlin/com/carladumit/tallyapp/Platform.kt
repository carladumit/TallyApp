package com.carladumit.tallyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform