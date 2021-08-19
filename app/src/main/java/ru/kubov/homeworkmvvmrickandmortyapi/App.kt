package ru.kubov.homeworkmvvmrickandmortyapi

import android.app.Application
import ru.kubov.common.di.CommonApi
import ru.kubov.common.di.FeatureContainer
import ru.kubov.homeworkmvvmrickandmortyapi.di.app.AppComponent
import ru.kubov.homeworkmvvmrickandmortyapi.di.app.DaggerAppComponent
import ru.kubov.homeworkmvvmrickandmortyapi.di.deps.FeatureHolderManager
import javax.inject.Inject

/**
 * Class of main application
 */
open class App: Application(), FeatureContainer {

    @Inject
    lateinit var featureHolderManager: FeatureHolderManager

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()

        appComponent.inject(this)
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }

    override fun commonApi(): CommonApi {
        return appComponent
    }
}