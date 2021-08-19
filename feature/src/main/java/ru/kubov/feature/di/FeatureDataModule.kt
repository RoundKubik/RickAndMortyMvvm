package ru.kubov.feature.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kubov.common.di.scope.FeatureScope
import ru.kubov.feature.data.remote.api.FeatureApiService
import ru.kubov.feature.data.remote.api.OkHttpFeatureApiImpl
import ru.kubov.feature.data.remote.source.FeatureDataSourceImpl
import ru.kubov.feature.data.repository.FeatureRepositoryImpl
import ru.kubov.feature.domain.repository.FeatureRepository
import ru.kubov.feature.domain.source.FeatureDataSource

@Module
abstract class FeatureDataModule {
    @Binds
    @FeatureScope
    abstract fun bindFeatureRepository(featureRepositoryImpl: FeatureRepositoryImpl): FeatureRepository

    @Binds
    @FeatureScope
    abstract fun bindFeatureDataSource(featureDataSourceImpl: FeatureDataSourceImpl): FeatureDataSource

    @Binds
    @FeatureScope
    abstract fun bindFeatureApiService(okHttpFeatureApiImpl: OkHttpFeatureApiImpl): FeatureApiService

}