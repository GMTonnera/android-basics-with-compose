package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val numPeople: Int,
    @DrawableRes val image: Int
)
