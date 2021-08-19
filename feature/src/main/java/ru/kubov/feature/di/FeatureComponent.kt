package ru.kubov.feature.di

import dagger.BindsInstance
import dagger.Component
import ru.kubov.common.di.CommonApi
import ru.kubov.common.di.scope.FeatureScope
import ru.kubov.feature.FeatureRouter
import ru.kubov.feature.character_detail.di.CharacterDetailComponent
import ru.kubov.feature.characters.di.CharactersComponent

@Component(
    dependencies = [
        FeatureDependencies::class,
    ],
    modules = [
        FeatureModule::class,
        FeatureDataModule::class
    ]
)
@FeatureScope
interface FeatureComponent {

    fun provideCharactersComponentFactory(): CharactersComponent.Factory
    fun provideCharacterDetailComponentFactory(): CharacterDetailComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance featureRouter: FeatureRouter,
            deps: FeatureDependencies
        ): FeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
        ]
    )
    interface FeatureDependenciesComponent : FeatureDependencies
}