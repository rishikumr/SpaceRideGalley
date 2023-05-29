package com.sample.imagefeaturelibrary.common.util

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Constants {
    const val MediaTypeImage = "image"
    const val SelectedPositionKey = "selectedPosition"
    const val ColumnCount = 2

    inline fun <reified T> readRawJson(appContext: Context, @RawRes rawResId: Int): T {
        appContext.resources.openRawResource(rawResId).bufferedReader().use {
            return Gson().fromJson<T>(it, object : TypeToken<T>() {}.type)
        }
    }
}
