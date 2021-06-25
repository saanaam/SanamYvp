package com.sanam.yavarpour.presentation.splash.main.model

import android.os.Parcel
import android.os.Parcelable
import com.sanam.yavarpour.common.PresentationModel

data class MusicItemModel(
     val id: Int? = null,
) : PresentationModel , Parcelable {
     constructor(parcel: Parcel) : this(
          parcel.readValue(Int::class.java.classLoader) as? Int,
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
          parcel.writeValue(id)
     }

     override fun describeContents(): Int {
          return 0
     }

     companion object CREATOR : Parcelable.Creator<MusicItemModel> {
          override fun createFromParcel(parcel: Parcel): MusicItemModel {
               return MusicItemModel(parcel)
          }

          override fun newArray(size: Int): Array<MusicItemModel?> {
               return arrayOfNulls(size)
          }
     }
}