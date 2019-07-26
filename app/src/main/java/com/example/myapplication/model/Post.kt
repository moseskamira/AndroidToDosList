package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable

data class Post(val userId: Int, val id: Int, val title: String?, val body: String?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString() )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(body)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post =
            Post(parcel)

        override fun newArray(size: Int): Array<Post?> = arrayOfNulls(size)
    }
}