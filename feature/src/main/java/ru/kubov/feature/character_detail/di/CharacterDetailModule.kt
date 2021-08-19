package ru.kubov.feature.character_detail.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.kubov.common.di.viewmodel.ViewModelKey
import ru.kubov.common.di.viewmodel.ViewModelModule
import ru.kubov.feature.FeatureRouter
import ru.kubov.feature.character_detail.presentation.CharacterDetailViewModel


@Module(
    includes = [
        ViewModelModule::class
    ]
)
class CharacterDetailModule {

    @Provides
    @IntoMap
    @ViewModelKey(CharacterDetailViewModel::class)
    fun provideViewModel(): ViewModel {
        return CharacterDetailViewModel()
    }

    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): CharacterDetailViewModel {
        return ViewModelProvider(fragment, viewModelFactory).get(CharacterDetailViewModel::class.java)
    }
}