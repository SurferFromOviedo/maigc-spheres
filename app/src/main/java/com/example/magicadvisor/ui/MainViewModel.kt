package com.example.magicadvisor.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.magicadvisor.data.DataProvider
import com.example.magicadvisor.data.UserAchievementsRepository
import com.example.magicadvisor.utils.MagicAdvisorLayoutType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    private val userAchievementsRepository: UserAchievementsRepository
): ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                MainViewModel(application.userAchievementsRepository)
            }
        }
    }

    private val _uiState = MutableStateFlow(MagicAdvisorUiState())
    val uiState: StateFlow<MagicAdvisorUiState> = _uiState.asStateFlow()

    var layoutType: MagicAdvisorLayoutType = MagicAdvisorLayoutType.LIST

    var userQuestion by mutableStateOf("")
    var answer by mutableStateOf(DataProvider.defaultAnswer)
    var quote by mutableStateOf(DataProvider.defaultQuote)
    var advice by mutableStateOf(DataProvider.defaultAdvice)


    val foundAnswers = userAchievementsRepository.foundAnswers.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptySet()
    )

    val foundQuotes = userAchievementsRepository.foundQuotes.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptySet()
    )

    val foundAdvices = userAchievementsRepository.foundAdvices.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptySet()
    )

    fun updateCurrentRoute(route: String) {
        _uiState.value = _uiState.value.copy(
            currentRoute = route
        )
    }

    fun answerTheQuestion(){
        if (userQuestion.isEmpty() || userQuestion.isBlank()) {
            answer = DataProvider.getNoQuestionAnswer()
        }else{
            if (userQuestion == uiState.value.lastQuestion){
                answer = DataProvider.getRepeatAnswer()
            }else{
                answer = DataProvider.getNormalAnswer()
                _uiState.value = _uiState.value.copy(lastQuestion = userQuestion)
            }

        }
    }

    fun giveQuote(){
        quote = DataProvider.getQuote()
    }

    fun giveAdvice(){
        advice = DataProvider.getAdvice()
    }

    suspend fun saveFoundAnswer(id: Int) {
        userAchievementsRepository.saveFoundAnswer(id)
    }

    suspend fun saveFoundQuote(id: Int) {
        userAchievementsRepository.saveFoundQuote(id)
    }

    suspend fun saveFoundAdvice(id: Int) {
        userAchievementsRepository.saveFoundAdvice(id)

    }

    fun showDetails(achievementType: AchievementType){
        _uiState.value = _uiState.value.copy(
            detailsShowing = true,
            achievementType = achievementType
        )
    }

    fun hideDetails(){
        _uiState.value = _uiState.value.copy(
            detailsShowing = false
        )
    }
}