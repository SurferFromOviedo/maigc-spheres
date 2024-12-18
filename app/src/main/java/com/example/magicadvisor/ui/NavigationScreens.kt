package com.example.magicadvisor.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
 fun MagicAdvisorBottomNavigationBar(
    currentRoute: String,
    onTabPressed: (String) -> Unit,
    navigationItems: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItems) {
            NavigationBarItem(
                selected = currentRoute == navItem.title,
                onClick = { onTabPressed(navItem.title) },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == navItem.title) navItem.selectedIcon else navItem.unselectedIcon,
                        contentDescription = navItem.title
                    )
                }
            )
        }
    }
}

@Composable
 fun MagicAdvisorNavigationRail(
    currentRoute: String,
    onTabPressed: (String) -> Unit,
    navigationItems: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItems) {
            NavigationRailItem(
                selected = currentRoute == navItem.title,
                onClick = { onTabPressed(navItem.title) },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == navItem.title) navItem.selectedIcon else navItem.unselectedIcon,
                        contentDescription = navItem.title
                    )
                }
            )
        }
    }
}


@Composable
fun MagicAdvisorNavigationDrawer(
    currentRoute: String,
    onTabPressed: (String) -> Unit,
    navigationItems: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        for (navItem in navigationItems) {
            NavigationDrawerItem(
                label = { Text(text = navItem.title) },
                selected = currentRoute == navItem.title,
                onClick = { onTabPressed(navItem.title) },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == navItem.title) navItem.selectedIcon else navItem.unselectedIcon,
                        contentDescription = navItem.title
                    )
                },
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }
    }
}