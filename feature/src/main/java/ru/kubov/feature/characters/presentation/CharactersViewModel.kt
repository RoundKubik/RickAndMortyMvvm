package ru.kubov.feature.characters.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.kubov.common.domain.model.RickAndMortyResult
import ru.kubov.common.error.ErrorEntity
import ru.kubov.feature.FeatureRouter
import ru.kubov.feature.character_detail.presentation.CharacterDetailFragment
import ru.kubov.feature.domain.model.Character
import ru.kubov.feature.domain.usecase.LoadCharactersUseCase
import java.util.concurrent.TimeUnit

/**
 * View model in screen showing list information of character update information for [CharactersFragment]
 *
 * @constructor creates view model with router and use case for load characters
 *
 * @param router [FeatureRouter] - router for navigation in feture module
 * @param loadCharactersUseCase - use case aka interactor for loading list of characters
 */
class CharactersViewModel(
    private val router: FeatureRouter,
    private val loadCharactersUseCase: LoadCharactersUseCase
) : ViewModel() {

    private val _characters: MutableLiveData<List<Character>> = MutableLiveData()
    val characters: LiveData<List<Character>> get() = _characters

    private val _state: MutableLiveData<State> = MutableLiveData(State.Loading)
    val state: LiveData<State> get() = _state

    private val disposable = CompositeDisposable()

    init {
        _state.value = State.Loading
        Single.fromCallable {
            loadCharactersUseCase.invoke()
        }.subscribeOn(Schedulers.io())
            .delay(DELAY_PROGRESS_BAR_TIME, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when (it) {
                    is RickAndMortyResult.Success -> {
                        _state.value = State.Done
                        _characters.value = it.data
                    }
                    is RickAndMortyResult.Error -> {
                        _state.value = State.Error(it.error)
                    }
                }
            }, {
                Log.d(TAG, it.toString())
            }).addTo(disposable)
    }

    /**
     * Method calls router method [router.openCharacterDetailsScreen()]
     *
     * @param character - some character that sends in details screen fragment
     */
    fun goToCharacterDetailScreen(character: Character) {
        router.openCharacterDetailsScreen(character)
    }

    /**
     * Sealed class. Use for update ui state of [CharactersFragment]
     *
     * [State.Loading] - use for show progress bar or shimmer. Current loading state
     * [State.Done] - use for mark, that data has been loaded
     * [State.Error] - use for show specified error on ui, like toast or snack view
     */
    sealed class State {
        object Loading : State()
        object Done : State()
        data class Error(val entity: ErrorEntity) : State()
    }

    companion object {
        private const val DELAY_PROGRESS_BAR_TIME = 3L
        private val TAG = CharactersViewModel::class.simpleName
    }

}