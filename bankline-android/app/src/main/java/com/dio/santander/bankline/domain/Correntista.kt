package com.dio.santander.bankline.domain

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Correntista(
    val id: Int
) : Parcelable
