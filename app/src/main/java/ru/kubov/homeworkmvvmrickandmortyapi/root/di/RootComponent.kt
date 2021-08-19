package ru.kubov.homeworkmvvmrickandmortyapi.root.di

import dagger.BindsInstance
import dagger.Component
import ru.kubov.common.di.CommonApi
import ru.kubov.common.di.scope.FeatureScope
import ru.kubov.homeworkmvvmrickandmortyapi.navigation.Navigator
import ru.kubov.homeworkmvvmrickandmortyapi.root.presentation.di.RootActivityComponent


/**
 *
 * Interface for declaration di for root component
 *
 */
@Component(
    dependencies = [
        RootDependencies::class
    ],
    modules = [
        RootFeatureModule::class
    ]
)
@FeatureScope
interface RootComponent {

    /**
     * Method for provide component factory for creation main activity
     *
     * @return [RootActivityComponent.Factory]
     */
    fun mainActivityComponentFactory(): RootActivityComponent.Factory

    @Component.Factory
    interface Factory {

        /**
         * Method for create root component
         *
         * @param navigator - main navigation in app
         * @param deps - dependencies for provide another modules
         * @return [RootComponent]
         */
        fun create(
            @BindsInstance navigator: Navigator,
            deps: RootDependencies
        ): RootComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
        ]
    )
    interface RootFeatureDependenciesComponent : RootDependencies
}
