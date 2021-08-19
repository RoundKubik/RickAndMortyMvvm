package ru.kubov.homeworkmvvmrickandmortyapi.root.di

import ru.kubov.common.di.FeatureApiHolder
import ru.kubov.common.di.FeatureContainer
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.homeworkmvvmrickandmortyapi.navigation.Navigator
import javax.inject.Inject

@ApplicationScope
class RootFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val navigator: Navigator
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val rootFeatureDependencies = DaggerRootComponent_RootFeatureDependenciesComponent.builder()
            .commonApi(commonApi())
            .build()
        return DaggerRootComponent.factory()
            .create(navigator, rootFeatureDependencies)
    }
}
