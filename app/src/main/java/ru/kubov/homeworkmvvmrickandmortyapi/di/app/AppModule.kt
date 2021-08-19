package ru.kubov.homeworkmvvmrickandmortyapi.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.homeworkmvvmrickandmortyapi.App


/**
 * Interface for declaration di for main module
 */
@Module
class AppModule {

    /**
     * Method for provide context
     *
     * @param application [App]
     *
     * @return [Context]
     */
    @Provides
    @ApplicationScope
    fun provideContext(application: App): Context {
        return application
    }
}