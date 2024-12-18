package com.example.magicadvisor.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material.icons.outlined.Mood
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.VolunteerActivism
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.magicadvisor.utils.MagicAdvisorNavigationType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magicadvisor.R
import com.example.magicadvisor.data.DataProvider
import com.example.magicadvisor.ui.theme.MagicAdvisorTheme
import com.example.magicadvisor.utils.MagicAdvisorLayoutType
import kotlinx.coroutines.launch

@Composable
fun MagicAdvisorApp(
    windowSize: WindowWidthSizeClass,
    viewModel: MainViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()
    val navigationType: MagicAdvisorNavigationType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = MagicAdvisorNavigationType.BOTTOM_NAVIGATION
            viewModel.layoutType = MagicAdvisorLayoutType.LIST
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = MagicAdvisorNavigationType.NAVIGATION_RAIL
            viewModel.layoutType = MagicAdvisorLayoutType.LIST
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = MagicAdvisorNavigationType.PERMANENT_NAVIGATION_DRAWER
            viewModel.layoutType = MagicAdvisorLayoutType.LIST_AND_DETAILS
        }
        else -> {
            navigationType = MagicAdvisorNavigationType.BOTTOM_NAVIGATION
            viewModel.layoutType = MagicAdvisorLayoutType.LIST
        }
    }
    val navigationItems = listOf(
        NavigationItemContent(
            title = "Ask a question",
            selectedIcon = Icons.Filled.QuestionMark,
            unselectedIcon = Icons.Outlined.QuestionMark
        ),
        NavigationItemContent(
            title = "Get a quote",
            selectedIcon = Icons.Filled.Mood,
            unselectedIcon = Icons.Outlined.Mood
        ),
        NavigationItemContent(
            title = "Get an advice",
            selectedIcon = Icons.Filled.VolunteerActivism,
            unselectedIcon = Icons.Outlined.VolunteerActivism
        ),
        NavigationItemContent(
            title = "Achievements",
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.StarOutline
        )
    )

    Scaffold (
        topBar = {
            if(navigationType != MagicAdvisorNavigationType.PERMANENT_NAVIGATION_DRAWER){
                MagicAdvisorTopBar(
                    currentRoute = uiState.currentRoute,
                    modifier = Modifier
                        .fillMaxWidth(),
                    uiState = uiState,
                    viewModel = viewModel
                )
            }
        },
        bottomBar = {
            if (navigationType == MagicAdvisorNavigationType.BOTTOM_NAVIGATION) {
                MagicAdvisorBottomNavigationBar(
                    currentRoute = uiState.currentRoute,
                    onTabPressed = {
                        navController.navigate(it)
                    },
                    navigationItems = navigationItems
                )
            }
        },

    ){ innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            if (navigationType == MagicAdvisorNavigationType.NAVIGATION_RAIL){
                MagicAdvisorNavigationRail(
                    navigationItems = navigationItems,
                    currentRoute = uiState.currentRoute,
                    onTabPressed = {
                        navController.navigate(it)
                    }
                )
            }else if (navigationType == MagicAdvisorNavigationType.PERMANENT_NAVIGATION_DRAWER){
                PermanentNavigationDrawer(
                    drawerContent = {
                        PermanentDrawerSheet(
                            modifier = Modifier
                                .width(220.dp),
                            drawerContainerColor = MaterialTheme.colorScheme.inverseOnSurface
                        ) {
                            MagicAdvisorNavigationDrawer(
                                currentRoute = uiState.currentRoute,
                                onTabPressed = {
                                    navController.navigate(it)
                                },
                                navigationItems = navigationItems,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .fillMaxHeight()
                                    .padding(horizontal = 8.dp)
                            )
                        }
                    }
                ) {
                    MagicAdvisorAppContent(
                        viewModel = viewModel,
                        modifier = Modifier
                            .fillMaxSize(),
                        navController = navController,
                        uiState = uiState
                    )
                }
            }
            MagicAdvisorAppContent(
                viewModel = viewModel,
                modifier = Modifier
                    .fillMaxSize(),
                navController = navController,
                uiState = uiState
            )
        }
    }
}

@Composable
fun MagicAdvisorAppContent(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    navController: NavHostController,
    uiState: MagicAdvisorUiState
){
    NavHost(
        navController = navController,
        startDestination = "Ask a question",
        modifier = modifier,
    ){
        composable("Ask a question") {
            viewModel.updateCurrentRoute("Ask a question")
            AskQuestionScreen(viewModel = viewModel)
        }
        composable("Get a quote") {
            viewModel.updateCurrentRoute("Get a quote")
            MotivationScreen(viewModel = viewModel)
        }
        composable("Get an advice") {
            viewModel.updateCurrentRoute("Get an advice")
            AdviceScreen(viewModel = viewModel)
        }
        composable("Achievements") {
            viewModel.updateCurrentRoute("Achievements")
            AchievementsScreen(viewModel = viewModel, uiSate = uiState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MagicAdvisorTopBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    viewModel: MainViewModel,
    uiState: MagicAdvisorUiState
){
    val achievement = if(uiState.detailsShowing){
        when (uiState.achievementType) {
            AchievementType.ANSWER -> "Answers"
            AchievementType.QUOTE -> "Quotes"
            AchievementType.ADVICE -> "Advices"
        }
    } else {
        "Achievements"
    }
    val text: String = when (currentRoute) {
        "Ask a question" -> "Ask a question"
        "Get a quote" -> "Get a quote"
        "Get an advice" -> "Get an advice"
        "Achievements" -> achievement
        else -> ""
    }
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        navigationIcon = {
            if(uiState.detailsShowing && currentRoute == "Achievements"){
                IconButton(onClick = { viewModel.hideDetails() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

@Composable
fun AskQuestionScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Click on the magic sphere",
            style = MaterialTheme.typography.titleSmall
        )


        IconButton(
            onClick = {
                viewModel.answerTheQuestion()
                scope.launch {
                    viewModel.saveFoundAnswer(viewModel.answer.id)
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .size(280.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.magicball_1),
                contentDescription = "Magic Ball"
            )
        }

        Text(
            modifier = Modifier
                .padding(vertical = 12.dp),
            text = viewModel.answer.text,
            style = MaterialTheme.typography.titleMedium
        )

        TextField(
            value = viewModel.userQuestion,
            onValueChange = {
                viewModel.userQuestion = it
            },
            label = { Text("Your question...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )


    }
}

@Composable
fun MotivationScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Click on the magic sphere",
            style = MaterialTheme.typography.titleSmall
        )


        IconButton(
            onClick = {
                viewModel.giveQuote()
                scope.launch {
                    viewModel.saveFoundQuote(viewModel.quote.id)
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .size(280.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.magicsphere1),
                contentDescription = "Magic Ball"
            )
        }

        Text(
            modifier = Modifier
                .padding(vertical = 12.dp),
            text = if(viewModel.quote.id == 0) "" else "${viewModel.quote.quote} — ${viewModel.quote.author}",
            style = MaterialTheme.typography.titleMedium
        )

    }
}

@Composable
fun AdviceScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Click on the magic sphere",
            style = MaterialTheme.typography.titleSmall
        )


        IconButton(
            onClick = {
                viewModel.giveAdvice()
                scope.launch {
                    viewModel.saveFoundAdvice(viewModel.advice.id)
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .size(280.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.magicball_2),
                contentDescription = "Magic Ball"
            )
        }

        Text(
            modifier = Modifier
                .padding(vertical = 12.dp),
            text = viewModel.advice.text,
            style = MaterialTheme.typography.titleMedium
        )

    }
}

@Composable
fun AchievementsScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    uiSate: MagicAdvisorUiState,
) {
    if (viewModel.layoutType != MagicAdvisorLayoutType.LIST_AND_DETAILS){
        if(!uiSate.detailsShowing){
            AchievementsList(
                modifier = modifier,
                viewModel = viewModel,
                onClick = {
                    viewModel.showDetails(it)
                }
            )
        }
        
        if(uiSate.detailsShowing){
            AchievementsDetails(
                modifier = modifier,
                viewModel = viewModel,
                achievementType = uiSate.achievementType,
                onBackClick = {
                    viewModel.hideDetails()
                }
            )
        }
    }else{
        AchievementsListAndDetails(
            modifier = modifier,
            viewModel = viewModel,
            uiState = uiSate
        )
    }
}

@Composable
fun AchievementsListAndDetails(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    uiState: MagicAdvisorUiState
){
    Row(
        modifier = modifier
            .fillMaxWidth()
    ){
        AchievementsList(
            modifier = Modifier
                .weight(1f),
            viewModel = viewModel,
            onClick = {
                viewModel.showDetails(it)
            }
        )
        AchievementsDetails(
            modifier = Modifier
                .weight(1f),
            viewModel = viewModel,
            achievementType = uiState.achievementType,
        )
    }
}

@Composable
fun AchievementsList(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    onClick: (AchievementType) -> Unit = {}
){
    val foundAnswers by viewModel.foundAnswers.collectAsState()
    val foundQuotes by viewModel.foundQuotes.collectAsState()
    val foundAdvices by viewModel.foundAdvices.collectAsState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(vertical = 8.dp),
            onClick = { onClick(AchievementType.ANSWER) }
        ){

            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        text = "Found answers: ${foundAnswers.size}/${DataProvider.answersSize}",
                        style = MaterialTheme.typography.titleLarge

                    )

                    Icon(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Arrow"
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(vertical = 8.dp),
            onClick = { onClick(AchievementType.QUOTE) }
        ){

            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        text = "Found quotes: ${foundQuotes.size}/${DataProvider.quotesSize}",
                        style = MaterialTheme.typography.titleLarge

                    )

                    Icon(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Arrow"
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(vertical = 8.dp),
            onClick = { onClick(AchievementType.ADVICE) }
        ){

            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        text = "Found advices: ${foundAdvices.size}/${DataProvider.advicesSize}",
                        style = MaterialTheme.typography.titleLarge

                    )

                    Icon(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Arrow"
                    )
                }
            }
        }
    }
}

@Composable
fun AchievementsDetails(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    achievementType: AchievementType,
    onBackClick: () -> Unit = {}
){
    BackHandler {
        onBackClick()
    }
    val foundAchievements: Set<Int> = when (achievementType) {
        AchievementType.ANSWER -> {
            viewModel.foundAnswers.collectAsState().value
        }
        AchievementType.QUOTE -> {
            viewModel.foundQuotes.collectAsState().value
        }
        AchievementType.ADVICE -> {
            viewModel.foundAdvices.collectAsState().value
        }

    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        foundAchievements.forEach {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                val achievement = DataProvider.getAchievement(it, achievementType)
                Box(
                    modifier = Modifier
                        .fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        text = achievement,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

        }
    }
}

data class NavigationItemContent(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

