package com.example.gt_5m_2.model

import android.os.Parcel
import android.os.Parcelable

data class LoveModel(
    var fname: String,
    var sname: String,
    var percentage: String,
    var result: String,

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<LoveModel> {
        override fun createFromParcel(parcel: Parcel): LoveModel {
            return LoveModel(parcel)
        }

        override fun newArray(size: Int): Array<LoveModel?> {
            return arrayOfNulls(size)
        }
    }
}
