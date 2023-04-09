package com.example.gt_5m_2.remote.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "love")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var fname: String,
    var sname: String,
    var percentage: String,
    var result: String,

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
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
