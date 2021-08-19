package ru.kubov.homeworkmvvmrickandmortyapi.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.kubov.common.di.FeatureApiHolder
import ru.kubov.common.di.FeatureContainer
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.feature.di.FeatureApi
import ru.kubov.feature.di.FeatureFeatureHolder
import ru.kubov.homeworkmvvmrickandmortyapi.App
import ru.kubov.homeworkmvvmrickandmortyapi.root.di.RootApi
import ru.kubov.homeworkmvvmrickandmortyapi.root.di.RootFeatureHolder

/**
 * Holder of components
 */
@Module
interface ComponentHolderModule {

    /**
     * Method for provide feature container
     *
     * @param application [App] main feature container [App] - implementation of feature container
     * @return [FeatureContainer]
     */
    @ApplicationScope
    @Binds
    fun provideFeatureContainer(application: App): FeatureContainer

    /**
     * Method for provide main feature
     *
     * @param rootFeatureHolder
     * @return [FeatureApiHolder]
     */
    @ApplicationScope
    @Binds
    @ClassKey(RootApi::class)
    @IntoMap
    fun provideMainFeature(rootFeatureHolder: RootFeatureHolder): FeatureApiHolder

    /**
     * Method for provide feature holder [FeatureFeatureHolder]
     *
     * @param featureHolder
     * @return [FeatureApiHolder]
     */
    @ApplicationScope
    @Binds
    @ClassKey(FeatureApi::class)
    @IntoMap
    fun provideFeatureFeature(featureHolder: FeatureFeatureHolder): FeatureApiHolder
}