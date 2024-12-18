package com.example.magicadvisor.ui

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.magicadvisor.data.UserAchievementsRepository

private const val ACHIEVEMENTS_PREFERENCES_NAME = "achievements"

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = ACHIEVEMENTS_PREFERENCES_NAME
)

class MyApplication: Application() {
    lateinit var userAchievementsRepository: UserAchievementsRepository

    override fun onCreate() {
        super.onCreate()
        userAchievementsRepository = UserAchievementsRepository(dataStore)
    }

}