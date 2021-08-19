package ru.kubov.common.di

import android.content.Context
import android.content.SharedPreferences
import okhttp3.OkHttpClient

/**
 * Interface for declaration of common providing entities
 */
interface CommonApi {

    /**
     * Fun for declaration providing context in [CommonApi]
     *
     * @return [Context]
     */
    fun context(): Context

    /**
     *  Fun for declaration providing shared preferences context in [CommonApi]
     *
     *  @return [SharedPreferences]
     */
    fun provideSharedPreferences(): SharedPreferences

    /**
     * Fun for declaration providing OkHttpClient in [CommonApi]
     *
     * @return [OkHttpClient]
     */
    fun provideOkHttpClient(): OkHttpClient

}
