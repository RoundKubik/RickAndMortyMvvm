package ru.kubov.feature.character_detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import coil.load
import ru.kubov.common.di.FeatureUtils
import ru.kubov.feature.domain.model.Character
import ru.kubov.feature.di.FeatureApi
import ru.kubov.feature.di.FeatureComponent
import ru.kubov.feature.databinding.FragmentCharacterDetailBinding
import javax.inject.Inject

/**
 * Class for show detail information about character
 *
 */
class CharacterDetailFragment : Fragment() {

    @Inject
    lateinit var viewModel: CharacterDetailViewModel

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        inject()
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribe()
        setupFromArgs()
    }

    private fun setupFromArgs() {
        with(requireArguments()) {
            val character = getParcelable<Character>(CHARACTER_KEY)
            character?.let {
                viewModel.setCharacter(character)
            }
        }
    }

    private fun showCharacterDetails(character: Character) {
        with(character) {
            binding.frgCharactersDetailIvCharacterDetailImage.load(image)
            binding.frgCharactersDetailTvCharacterDetailName.text = name
            binding.frgCharactersDetailTvDetailGender.text = gender
            binding.frgCharactersDetailTvDetailOrigin.text = origin
            binding.frgCharactersDetailTvDetailSpecies.text = species
            binding.frgCharactersDetailTvDetailStatus.text = status
        }
    }

    private fun subscribe() {
        viewModel.character.observe(this.viewLifecycleOwner) {
            showCharacterDetails(it)
        }
    }

    private fun inject() {
        FeatureUtils.getFeature<FeatureComponent>(this, FeatureApi::class.java)
            .provideCharacterDetailComponentFactory()
            .create(this)
            .inject(this)
    }

    companion object {
        private const val CHARACTER_KEY = "ru.kubov.feature.CHARACTER_KEY"
        fun makeBundle(character: Character) = bundleOf(CHARACTER_KEY to character)
    }
}