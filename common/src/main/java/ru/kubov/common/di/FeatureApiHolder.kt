package ru.kubov.common.di

import java.util.concurrent.locks.ReentrantLock

/**
 * Feature holder
 */
@Suppress("UNCHECKED_CAST")
abstract class FeatureApiHolder(
    private val mFeatureContainer: FeatureContainer
) {
    private val mFeatureLocker = ReentrantLock()

    private var mFeatureApi: Any? = null

    /**
     * Generic method for provide feature api
     */
    fun <T> getFeatureApi(): T {
        mFeatureLocker.lock()
        if (mFeatureApi == null) {
            mFeatureApi = initializeDependencies()
        }
        mFeatureLocker.unlock()
        return mFeatureApi as T
    }

    /**
     * Method for release features api
     */
    fun releaseFeatureApi() {
        mFeatureLocker.lock()
        mFeatureApi = null
        destroyDependencies()
        mFeatureLocker.unlock()
    }

    /**
     * Method for provide common api
     */
    fun commonApi(): CommonApi {
        return mFeatureContainer.commonApi()
    }

    protected fun <T> getFeature(key: Class<T>): T {
        return mFeatureContainer.getFeature<T>(key) ?: throw RuntimeException()
    }

    protected fun releaseFeature(key: Class<*>) {
        mFeatureContainer.releaseFeature(key)
    }

    protected abstract fun initializeDependencies(): Any

    protected fun destroyDependencies() {
    }
}
