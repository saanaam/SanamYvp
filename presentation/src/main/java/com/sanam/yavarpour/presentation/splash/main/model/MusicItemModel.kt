package com.sanam.yavarpour.presentation.splash.main.model

import android.content.res.AssetFileDescriptor
import android.os.Parcel
import android.os.Parcelable
import com.sanam.yavarpour.common.PresentationModel

data class MusicItemModel(
     val id: Int? = null,
     val file: AssetFileDescriptor? = null
) : PresentationModel , Parcelable {
     constructor(parcel: Parcel) : this(
          parcel.readValue(Int::class.java.classLoader) as? Int,
          parcel.readParcelable(AssetFileDescriptor::class.java.classLoader)
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
          parcel.writeValue(id)
          parcel.writeParcelable(file, flags)
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