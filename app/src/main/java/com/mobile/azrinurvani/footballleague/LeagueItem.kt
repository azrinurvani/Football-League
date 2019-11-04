package com.mobile.azrinurvani.footballleague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItem(val name:String?, val image: Int?, val desc:String?): Parcelable

