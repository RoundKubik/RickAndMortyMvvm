package ru.kubov.common.di

interface FeatureContainer {

    fun <T> getFeature(key: Class<*>): T

    fun releaseFeature(key: Class<*>)

    fun commonApi(): CommonApi
}
