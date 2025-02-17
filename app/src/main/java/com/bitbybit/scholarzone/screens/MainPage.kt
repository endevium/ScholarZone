package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.objects.BottomNavigationItem
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.objects.Routes.EditEmailPage
import com.bitbybit.scholarzone.objects.Routes.PersonalDetailsPage

@Composable
fun MainPage() {
    val nav = rememberNavController()

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            titleData = Routes.HomePage,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            title = "Dashboard",
            titleData = Routes.DashboardPage,
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu
        ),
        BottomNavigationItem(
            title = "Notifications",
            titleData = Routes.NotificationPage,
            selectedIcon = Icons.Filled.Notifications,
            unselectedIcon = Icons.Outlined.Notifications
        ),
        BottomNavigationItem(
            title = "Profile",
            titleData = Routes.ProfilePage,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val navBackStackEntry by nav.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val hideBottomNavRoutes = listOf(
        Routes.ScholarshipApplicationPage,
        Routes.ApplicationFormPage,
        Routes.EditFirstNamePage,
        Routes.EditLastNamePage,
        Routes.EditGenderPage,
        Routes.EditBirthdatePage,
        Routes.EditPhoneNumberPage,
        Routes.EditSchoolPage,
        Routes.EditProgramPage,
        Routes.EditRPCPage,
        Routes.EditBSBPage,
        Routes.EditUsernamePage,
        Routes.EditEmailPage,
        Routes.EditPasswordPage
    )

    val shouldShowBottomNav = currentRoute !in hideBottomNavRoutes

    Scaffold(
        bottomBar = {
            if (shouldShowBottomNav) {
                NavigationBar(
                    Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                nav.navigate(item.titleData)
                            },
                            label = {
                                Text(item.title)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (item.badgeCount != null) {
                                            Badge {
                                                Text(item.badgeCount.toString())
                                            }
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
            innerPadding -> Box(modifier = Modifier.padding(innerPadding)) {
        NavigationGraph(nav)
    }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.HomePage) {
        composable(Routes.HomePage) { HomePage(navController) }
        composable(Routes.DashboardPage) { DashboardPage(navController) }
        composable(Routes.NotificationPage) { NotificationPage(navController) }
        composable(Routes.ProfilePage) { ProfilePage(navController) }
        composable(Routes.SearchPage) { SearchPage(navController)  }
        composable(Routes.ScholarshipApplicationPage) { ScholarshipApplicationPage(navController) }
        composable(Routes.ApplicationFormPage) { ApplicationFormPage(navController) }

        composable(Routes.PersonalDetailsPage) { ProfileDetailsPage(navController) }
        composable(Routes.AccountDetailsPage) { AccountDetailsPage(navController)  }

        composable(Routes.EditFirstNamePage) { EditFirstNamePage(navController) }
        composable(Routes.EditLastNamePage) { EditLastNamePage(navController) }
        composable(Routes.EditGenderPage) { EditGenderPage(navController) }
        composable(Routes.EditBirthdatePage) { EditBirthdatePage(navController) }
        composable(Routes.EditPhoneNumberPage) { EditPhoneNumberPage(navController) }
        composable(Routes.EditSchoolPage) { EditSchoolPage(navController) }
        composable(Routes.EditProgramPage) { EditProgramPage(navController) }
        composable(Routes.EditRPCPage) { EditRPCPage(navController) }
        composable(Routes.EditBSBPage) { EditBSBPage(navController) }
        composable(Routes.EditUsernamePage) { EditUsernamePage(navController) }
        composable(Routes.EditEmailPage) { EditEmailPage(navController) }
        composable(Routes.EditPasswordPage) { EditPasswordPage(navController) }
    }
}

