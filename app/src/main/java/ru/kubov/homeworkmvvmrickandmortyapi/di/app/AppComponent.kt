package ru.kubov.homeworkmvvmrickandmortyapi.di.app

import dagger.BindsInstance
import dagger.Component
import ru.kubov.common.di.CommonApi
import ru.kubov.common.di.modules.CommonModule
import ru.kubov.common.di.modules.NetworkModule
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.homeworkmvvmrickandmortyapi.App
import ru.kubov.homeworkmvvmrickandmortyapi.di.deps.ComponentHolderModule

/**
 * Interface for declaration di for main component
 */
@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        ComponentHolderModule::class,
        FeatureManagerModule::class,
        NavigationModule::class
    ]
)
interface AppComponent : CommonApi {

    @Component.Builder
    interface Builder {

        /**
         * Method for provide component builder
         *
         * @return [Builder]
         */
        @BindsInstance
        fun application(application: App): Builder

        /**
         * Method for build main component
         *
         * @return [AppComponent]
         */
        fun build(): AppComponent
    }

    /**
     * Method for app injection
     *
     * @param app [App] main application class
     */
    fun inject(app: App)
}