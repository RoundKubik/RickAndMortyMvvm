package ru.kubov.feature.characters.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.kubov.common.di.viewmodel.ViewModelKey
import ru.kubov.common.di.viewmodel.ViewModelModule
import ru.kubov.feature.FeatureRouter
import ru.kubov.feature.characters.presentation.CharactersViewModel
import ru.kubov.feature.domain.usecase.LoadCharactersUseCase


@Module(
    includes = [
        ViewModelModule::class
    ]
)
class CharactersModule {

    @Provides
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun provideViewModel(
        navigator: FeatureRouter,
        loadCharactersUseCase: LoadCharactersUseCase
    ): ViewModel {
        return CharactersViewModel(
            navigator,
            loadCharactersUseCase
        )
    }

    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): CharactersViewModel {
        return ViewModelProvider(fragment, viewModelFactory).get(CharactersViewModel::class.java)
    }
}
