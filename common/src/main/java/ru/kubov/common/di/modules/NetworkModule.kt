package ru.kubov.common.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import ru.kubov.common.di.scope.ApplicationScope
import java.util.concurrent.TimeUnit

/**
 * Class with declaration of network module that uses in other modules
 */
@Module
class NetworkModule {

    /**
     * Method that provides okHttpClient
     * @return [OkHttpClient] - used for implementation rest api
     */
    @Provides
    @ApplicationScope
    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .readTimeout(3, TimeUnit.SECONDS)
            .writeTimeout(3, TimeUnit.SECONDS)
            .build()

    companion object {
        private val TAG = NetworkModule::class.simpleName
    }
}
