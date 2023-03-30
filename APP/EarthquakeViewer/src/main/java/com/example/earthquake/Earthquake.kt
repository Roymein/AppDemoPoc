package com.example.earthquake

import android.location.Location
import java.util.Date

data class Earthquake(
    val id: String,
    val date: Date,
    val details: String,
    val location: Location?,
    val magnitude: Double,
    val link: String?
)

