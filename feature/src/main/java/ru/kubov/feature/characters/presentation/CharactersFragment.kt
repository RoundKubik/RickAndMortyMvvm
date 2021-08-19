package ru.kubov.feature.characters.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kubov.common.di.FeatureUtils
import ru.kubov.feature.R
import ru.kubov.feature.characters.presentation.adapters.CharactersAdapter
import ru.kubov.feature.di.FeatureApi
import ru.kubov.feature.di.FeatureComponent
import ru.kubov.feature.databinding.FragmentCharactersBinding
import ru.kubov.feature.domain.model.CharactersError
import javax.inject.Inject

/**
 * Class for show list information about characters
 *
 */
class CharactersFragment : Fragment() {

    @Inject
    lateinit var viewModel: CharactersViewModel

    private lateinit var charactersAdapter: CharactersAdapter
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        inject()
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        initCharactersRecycler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribe()
    }

    private fun initCharactersRecycler() {
        charactersAdapter = CharactersAdapter { character ->
            viewModel.goToCharacterDetailScreen(character)
        }
        binding.frgCharactersRvCharacters.adapter = charactersAdapter
        binding.frgCharactersRvCharacters.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun subscribe() {
        viewModel.characters.observe(this.viewLifecycleOwner) { characters ->
            charactersAdapter.submitList(characters)
        }
        viewModel.state.observe(this.viewLifecycleOwner) {
            handleUiState(it)
        }
    }

    private fun handleUiState(state: CharactersViewModel.State) {
        when(state) {
            is CharactersViewModel.State.Done -> {
                binding.frgCharactersRvCharacters.visibility = View.VISIBLE
                binding.frgCharactersPbLoading.visibility = View.GONE
            }
            is CharactersViewModel.State.Loading -> {
                binding.frgCharactersRvCharacters.visibility = View.GONE
                binding.frgCharactersPbLoading.visibility = View.VISIBLE
            }
            is CharactersViewModel.State.Error -> {
                when(state.entity) {
                    is CharactersError.LoadingError -> {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.error_loading_characters),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun inject() {
        FeatureUtils.getFeature<FeatureComponent>(this, FeatureApi::class.java)
            .provideCharactersComponentFactory()
            .create(this)
            .inject(this)
    }
}