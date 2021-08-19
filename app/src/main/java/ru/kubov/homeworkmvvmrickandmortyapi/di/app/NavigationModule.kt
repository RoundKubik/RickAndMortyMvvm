package ru.kubov.homeworkmvvmrickandmortyapi.di.app

import dagger.Module
import dagger.Provides
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.feature.FeatureRouter
import ru.kubov.homeworkmvvmrickandmortyapi.navigation.Navigator

/**
 * Navigation module for provide routers from different modules
 */
@Module
class NavigationModule {

    /**
     * Method for provide navigator
     *
     * @return [Navigator]
     */
    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    /**
     * Method for provide feature router with navigation between screens in feature module
     *
     * @return [FeatureRouter]
     */
    @ApplicationScope
    @Provides
    fun provideFeatureRouter(navigator: Navigator): FeatureRouter = navigator
}