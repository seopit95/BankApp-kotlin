package com.example.chap11drawerlayout2

import android.os.Parcel
import android.os.Parcelable

class PasswordParcel(val pw: String) : Parcelable {

    //parcelable 내용 읽기 정의
    constructor(parcel: Parcel) : this(
        parcel.readString().toString()
    )

    //parcelable 내용 쓰기 정의
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pw)
    }

    override fun describeContents(): Int {
        return 0
    }

    // Creator Parcelable
    companion object CREATOR : Parcelable.Creator<PasswordParcel> {
        override fun createFromParcel(parcel: Parcel): PasswordParcel {
            return PasswordParcel(parcel)
        }

        override fun newArray(size: Int): Array<PasswordParcel?> {
            return arrayOfNulls(size)
        }
    }
}
