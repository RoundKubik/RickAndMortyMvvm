package ru.kubov.feature.characters.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.kubov.common.di.scope.ScreenScope
import ru.kubov.feature.characters.presentation.CharactersFragment


@Subcomponent(
    modules = [
        CharactersModule::class
    ]
)
@ScreenScope
interface CharactersComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: Fragment): CharactersComponent
    }

    fun inject(charactersFragment: CharactersFragment)
}
