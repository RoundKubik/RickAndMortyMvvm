package ru.kubov.feature.character_detail.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.kubov.common.di.scope.ScreenScope
import ru.kubov.feature.character_detail.presentation.CharacterDetailFragment
import ru.kubov.feature.characters.di.CharactersComponent
import ru.kubov.feature.characters.presentation.CharactersFragment

@Subcomponent(
    modules = [
        CharacterDetailModule::class
    ]
)

@ScreenScope
interface CharacterDetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: Fragment): CharacterDetailComponent
    }

    fun inject(registrationFragment: CharacterDetailFragment)
}