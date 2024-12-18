package com.example.magicadvisor.ui

data class MagicAdvisorUiState(
    val currentRoute: String = "Ask a question",
    val lastQuestion: String = "",
    val detailsShowing: Boolean = false,
    val achievementType: AchievementType = AchievementType.ANSWER,
)

enum class AchievementType {
    ANSWER,
    QUOTE,
    ADVICE
}