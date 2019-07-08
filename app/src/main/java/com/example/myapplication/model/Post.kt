package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable

class Post() : Parcelable {
    var userId: Int? = null
    var id: Int? = null
    var title: String? = null
    var body: String? = null

    constructor(userId: Int, id: Int, title: String, body: String) : this() {
        this.userId = userId
        this.id = id
        this.title = title
        this.body = body
    }

    constructor(parcel: Parcel) : this() {
        userId = parcel.readInt()
        id = parcel.readInt()
        title = parcel.readString()
        body = parcel.readString()
    }

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