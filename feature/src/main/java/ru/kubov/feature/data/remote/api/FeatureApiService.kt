package ru.kubov.feature.data.remote.api

/**
 * Interface with declaration methods for backend connection, used in feature module
 */
interface FeatureApiService {

    /**
     * Method for load characters from backend
     * @return [String] - body of response with information about characters
     */
    fun getCharacters(): String

    companion object {
        val BASE_URL: String
            get() = "https://rickandmortyapi.com/api/"
        val CHARACTER_ENDPOINT: String
            get() = "character"
    }
}