package ru.kubov.common.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.kubov.common.di.scope.ApplicationScope

/**
 * Common module that used in other modules
 */
@Module
abstract class CommonModule {

    companion object {

        private const val SHARED_PREFERENCES_FILE = "pumity.preferences"

        /**
         * Method for provide shared preferences
         *
         * @param context
         * @return [SharedPreferences]
         */
        @Provides
        @ApplicationScope
        fun provideSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE)
        }
    }
}
