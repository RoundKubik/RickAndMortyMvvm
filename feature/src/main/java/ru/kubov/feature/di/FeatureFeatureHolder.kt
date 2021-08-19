package ru.kubov.feature.di

import ru.kubov.common.di.FeatureApiHolder
import ru.kubov.common.di.FeatureContainer
import ru.kubov.common.di.scope.ApplicationScope
import ru.kubov.feature.FeatureRouter
import javax.inject.Inject

@ApplicationScope
class FeatureFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val featureRouter: FeatureRouter
) : FeatureApiHolder(featureContainer) {
    override fun initializeDependencies(): Any {
        val deps = DaggerFeatureComponent_FeatureDependenciesComponent.builder()
            .commonApi(commonApi())
            .build()
        return DaggerFeatureComponent.factory()
            .create(featureRouter, deps)
    }
}