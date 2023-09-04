package com.bahardev.submission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroIndonesia(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable
