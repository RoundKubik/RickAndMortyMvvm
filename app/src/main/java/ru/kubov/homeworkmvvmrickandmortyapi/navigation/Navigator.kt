package ru.kubov.homeworkmvvmrickandmortyapi.navigation

import androidx.navigation.NavController
import ru.kubov.feature.FeatureRouter
import ru.kubov.feature.character_detail.presentation.CharacterDetailFragment
import ru.kubov.feature.domain.model.Character
import ru.kubov.homeworkmvvmrickandmortyapi.R

class Navigator : FeatureRouter {

    private var navController: NavController? = null

    override fun openCharacterDetailsScreen(character: Character) {
        val bundle = CharacterDetailFragment.makeBundle(character)
        when (navController?.currentDestination?.id) {
            R.id.charactersFragment -> navController?.navigate(
                R.id.action_charactersFragment_to_characterDetailFragment,
                bundle
            )
        }
    }

    /**
     *  Method for attach navigation controller of current host activity
     *
     *  @param navController [NavController] navigation controller of current host activity
     */
    fun attach(navController: NavController) {
        this.navController = navController
    }

    /**
     *  Method for detach navigation controller of current host activity
     */
    fun detach() {
        navController = null
    }

    /**
     * Method for check is attached navigation controller
     */
    fun isAttached(): Boolean = navController != null

    private companion object {
        private val TAG = Navigator::class.simpleName
    }
}