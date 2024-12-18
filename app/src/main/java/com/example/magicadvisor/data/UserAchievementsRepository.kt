package com.example.magicadvisor.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserAchievementsRepository(
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        val FOUND_ANSWERS_KEY = stringPreferencesKey("found_answers")
        val FOUND_QUOTES_KEY = stringPreferencesKey("found_quotes")
        val FOUND_ADVICES_KEY = stringPreferencesKey("found_advice")
    }

    suspend fun saveFoundAnswer(id: Int) {
        dataStore.edit { preferences ->
            val foundAnswers = preferences[FOUND_ANSWERS_KEY]?.split(",")?.toMutableSet() ?: mutableSetOf()
            foundAnswers.add(id.toString())
            preferences[FOUND_ANSWERS_KEY] = foundAnswers.joinToString(",")
        }
    }

    suspend fun saveFoundQuote(id: Int) {
        dataStore.edit { preferences ->
            val foundQuotes = preferences[FOUND_QUOTES_KEY]?.split(",")?.toMutableSet() ?: mutableSetOf()
            foundQuotes.add(id.toString())
            preferences[FOUND_QUOTES_KEY] = foundQuotes.joinToString(",")
        }
    }

    suspend fun saveFoundAdvice(id: Int) {
        dataStore.edit { preferences ->
            val foundAdvices = preferences[FOUND_ADVICES_KEY]?.split(",")?.toMutableSet() ?: mutableSetOf()
            foundAdvices.add(id.toString())
            preferences[FOUND_ADVICES_KEY] = foundAdvices.joinToString(",")
        }
    }

    val foundAnswers: Flow<Set<Int>> = dataStore.data.map { preferences ->
        preferences[FOUND_ANSWERS_KEY]?.split(",")?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    val foundQuotes: Flow<Set<Int>> = dataStore.data.map { preferences ->
        preferences[FOUND_QUOTES_KEY]?.split(",")?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    val foundAdvices: Flow<Set<Int>> = dataStore.data.map { preferences ->
        preferences[FOUND_ADVICES_KEY]?.split(",")?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }


}