package ru.kubov.homeworkmvvmrickandmortyapi.root.presentation.di

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import ru.kubov.common.di.scope.ScreenScope
import ru.kubov.homeworkmvvmrickandmortyapi.root.di.RootComponent
import ru.kubov.homeworkmvvmrickandmortyapi.root.presentation.MainActivity

/**
 * Interface of component with deps for main activity
 */
@Subcomponent(
    modules = [
        RootActivityModule::class
    ]
)
@ScreenScope
interface RootActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        /**
         * Method for create main activity component
         *
         * @param activity - main activity [MainActivity]
         * @return [RootActivityComponent]
         */
        fun create(
            @BindsInstance activity: AppCompatActivity
        ): RootActivityComponent
    }

    fun inject(rootActivity: MainActivity)
}
