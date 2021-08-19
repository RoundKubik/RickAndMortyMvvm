package ru.kubov.homeworkmvvmrickandmortyapi.root.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ru.kubov.common.di.FeatureUtils
import ru.kubov.homeworkmvvmrickandmortyapi.R
import ru.kubov.homeworkmvvmrickandmortyapi.databinding.ActivityMainBinding
import ru.kubov.homeworkmvvmrickandmortyapi.navigation.Navigator
import ru.kubov.homeworkmvvmrickandmortyapi.root.di.RootApi
import ru.kubov.homeworkmvvmrickandmortyapi.root.di.RootComponent
import javax.inject.Inject

/**
 * Main application host activity
 */
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inject()

    }

    override fun onStart() {
        super.onStart()
        initNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.detach()
    }

    private fun initNavigator() {
        if (!navigator.isAttached()) {
            val navController = findNavController(R.id.navHost)

            val navInflater = navController.navInflater
            val mainGraph = navInflater.inflate(R.navigation.main_nav_graph)
            navController.graph = mainGraph
            navigator.attach(findNavController(R.id.navHost))
        }
    }

    private fun inject() {
        FeatureUtils.getFeature<RootComponent>(this, RootApi::class.java)
            .mainActivityComponentFactory()
            .create(this)
            .inject(this)
    }

    private companion object {
        val TAG = MainActivity::class.simpleName
    }
}