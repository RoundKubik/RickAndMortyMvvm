package ru.kubov.homeworkmvvmrickandmortyapi.root.presentation.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.kubov.common.di.viewmodel.ViewModelKey
import ru.kubov.common.di.viewmodel.ViewModelModule
import ru.kubov.homeworkmvvmrickandmortyapi.root.presentation.MainActivityViewModel

/**
 * Module with injection MainActivityViewModel [MainActivityViewModel]
 */
@Module(
    includes = [
        ViewModelModule::class
    ]
)
class RootActivityModule {

    /**
     * Method for provide viewModel
     * @return [ViewModel]
     */
    @Provides
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun provideViewModel(): ViewModel {
        return MainActivityViewModel()
    }

    /**
     * Method for provide view model from view model provider [ViewModelProvider]
     *
     * @param activity
     * @param viewModelFactory
     * @return [MainActivityViewModel]
     */
    @Provides
    fun provideViewModelCreator(
        activity: AppCompatActivity,
        viewModelFactory: ViewModelProvider.Factory
    ): MainActivityViewModel {
        return ViewModelProvider(activity, viewModelFactory).get(MainActivityViewModel::class.java)
    }
}
