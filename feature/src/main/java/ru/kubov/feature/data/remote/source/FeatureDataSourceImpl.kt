package ru.kubov.feature.data.remote.source

import org.json.JSONArray
import org.json.JSONObject
import ru.kubov.common.domain.model.RickAndMortyResult
import ru.kubov.feature.data.remote.api.FeatureApiService
import ru.kubov.feature.domain.source.FeatureDataSource
import javax.inject.Inject
import ru.kubov.feature.data.remote.model.CharacterResponse
import ru.kubov.feature.domain.model.CharactersError

/**
 * Implementation of data source for feature module
 * @constructor create data source with used feature api servise
 * @param featureApi
 */
class FeatureDataSourceImpl @Inject constructor(private val featureApi: FeatureApiService) : FeatureDataSource {

    override fun getCharacters(): RickAndMortyResult<List<CharacterResponse>?> {
        return try {
            val result = mapJsonToCharactersList(featureApi.getCharacters())
            RickAndMortyResult.Success(result)
        } catch (e: Exception) {
            RickAndMortyResult.Error(CharactersError.LoadingError)
        }
    }

    private fun mapJsonToCharactersList(json: String): List<CharacterResponse> {
        val jsonObject = JSONObject(json)
        val array: JSONArray = jsonObject.getJSONArray("results")
        val characters = mutableListOf<CharacterResponse>()
        for (i in 0 until array.length()) {
            val jsonObjectLocal = array.getJSONObject(i)
            val originName = jsonObjectLocal.getJSONObject("origin").getString("name")
            val locationName = jsonObjectLocal.getJSONObject("location").getString("name")
            val id = jsonObjectLocal.getInt("id")
            val name = jsonObjectLocal.getString("name")
            val status = jsonObjectLocal.getString("status")
            val species = jsonObjectLocal.getString("species")
            val type = jsonObjectLocal.getString("type")
            val gender = jsonObjectLocal.getString("gender")
            val image = jsonObjectLocal.getString("image")
            val created = jsonObjectLocal.getString("created")
            characters.add(
                CharacterResponse(
                    id,
                    name,
                    status,
                    species,
                    type,
                    gender,
                    originName,
                    locationName,
                    image,
                    created
                )
            )
        }
        return characters
    }

    companion object {
        val TAG = FeatureDataSourceImpl::class.simpleName
    }
}