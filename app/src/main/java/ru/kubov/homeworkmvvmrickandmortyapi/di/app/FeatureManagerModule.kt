package ru.kubov.homeworkmvvmrickandmortyapi.di.app

import dagger.Module
import dagger.Provides
import ru.kubov.common.di.FeatureApiHolder
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.homeworkmvvmrickandmortyapi.di.deps.FeatureHolderManager

/**
 * Holder for features
 */
@Module
class FeatureManagerModule {

    /**
     * Method for providing feature holder manager [FeatureHolderManager]
     *
     * @param featureApiHolderMap map of pair class and feature api holder [FeatureApiHolder]
     * @return [FeatureHolderManager]
     */
    @ApplicationScope
    @Provides
    fun provideFeatureHolderManager(featureApiHolderMap: @JvmSuppressWildcards Map<Class<*>, FeatureApiHolder>): FeatureHolderManager {
        return FeatureHolderManager(featureApiHolderMap)
    }
}
