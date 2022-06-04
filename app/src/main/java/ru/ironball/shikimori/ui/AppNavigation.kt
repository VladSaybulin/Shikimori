package ru.ironball.shikimori.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.ironball.shikimori.ui.screens.animeauthors.AnimeAuthorsScreen
import ru.ironball.shikimori.ui.screens.animecharacters.AnimeCharactersScreen
import ru.ironball.shikimori.ui.screens.animedetails.AnimeDetails
import ru.ironball.shikimori.ui.screens.animesearch.AnimeSearch
import ru.ironball.shikimori.ui.screens.home.Home
import ru.ironball.shikimori.ui.screens.mangaauthors.MangaAuthorsScreen
import ru.ironball.shikimori.ui.screens.mangacharacters.MangaCharactersScreen
import ru.ironball.shikimori.ui.screens.mangadetails.MangaDetails
import ru.ironball.shikimori.ui.screens.mangasearch.MangaSearch
import ru.ironball.shikimori.ui.screens.ranobeauthors.RanobeAuthorsScreen
import ru.ironball.shikimori.ui.screens.ranobecharacters.RanobeCharactersScreen
import ru.ironball.shikimori.ui.screens.ranobesearch.RanobeSearch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        addHome(navController)
        addAnimeSearch(navController)
        addAnimeDetails(navController)
        addAnimeCharacters(navController)
        addAnimeAuthors(navController)
        addMangaSearch(navController)
        addMangaDetails(navController)
        addMangaCharacters(navController)
        addMangaAuthors(navController)
        addRanobeSearch(navController)
        addRanobeDetails(navController)
        addRanobeCharacters(navController)
        addRanobeAuthors(navController)
    }
}

private fun NavGraphBuilder.addRanobeAuthors(navController: NavHostController) {
    composable(Screen.RanobeCharacters.route) {
        RanobeCharactersScreen(viewModel = hiltViewModel(), onNavigateUp = navController::navigateUp)
    }
}

private fun NavGraphBuilder.addRanobeCharacters(navController: NavHostController) {
    composable(Screen.RanobeAuthors.route) {
        RanobeAuthorsScreen(viewModel = hiltViewModel(), onNavigateUp = navController::navigateUp)
    }
}

private fun NavGraphBuilder.addRanobeDetails(navController: NavHostController) {
    composable(
        route = Screen.RanobeDetails.route,
        arguments = listOf(navArgument("id") { NavType.LongType })
    ) {
        MangaDetails(
            viewModel = hiltViewModel(),
            openMangaDetails = { id ->
                navController.navigate(Screen.RanobeDetails.createRoute(id))
            },
            openCharacters = { id ->
                navController.navigate(Screen.RanobeCharacters.createRoute(id))
            },
            navigateUp = {
                navController.navigateUp()
            },
            openAuthors = { id ->
                navController.navigate(Screen.RanobeAuthors.createRoute(id))
            }
        )
    }
}

private fun NavGraphBuilder.addRanobeSearch(navController: NavHostController) {
    composable(
        route = Screen.RanobeSearch.route,
        arguments = listOf(
            navArgument("order") { defaultValue = "popularity" },
            nullableNavArgument("kind"),
            nullableNavArgument("status"),
            nullableNavArgument("season"),
            nullableNavArgument("score"),
            nullableNavArgument("publisher"),
            nullableNavArgument("franchise"),
            nullableNavArgument("censored"),
            nullableNavArgument("mylist"),
        )
    ) {
        RanobeSearch(
            viewModel = hiltViewModel(),
            openMangaDetails = { id ->
                navController.navigate(Screen.RanobeDetails.createRoute(id))
            },
            navigateUp = {
                navController.navigateUp()
            }
        )
    }
}

private fun NavGraphBuilder.addMangaCharacters(navController: NavHostController) {
    composable(Screen.MangaCharacters.route) {
        MangaCharactersScreen(viewModel = hiltViewModel(), onNavigateUp = navController::navigateUp)
    }
}

private fun NavGraphBuilder.addMangaAuthors(navController: NavHostController) {
    composable(Screen.MangaAuthors.route) {
        MangaAuthorsScreen(viewModel = hiltViewModel(), onNavigateUp = navController::navigateUp)
    }
}

private fun NavGraphBuilder.addMangaDetails(navController: NavHostController) {
    composable(
        route = Screen.MangaDetails.route,
        arguments = listOf(navArgument("id") { NavType.LongType })
    ) {
        MangaDetails(
            viewModel = hiltViewModel(),
            openMangaDetails = { id ->
                navController.navigate(Screen.MangaDetails.createRoute(id))
            },
            openCharacters = { id ->
                navController.navigate(Screen.MangaCharacters.createRoute(id))
            },
            navigateUp = {
                navController.navigateUp()
            },
            openAuthors = { id ->
                navController.navigate(Screen.MangaAuthors.createRoute(id))
            }
        )
    }
}

private fun NavGraphBuilder.addMangaSearch(navController: NavHostController) {
    composable(
        route = Screen.MangaSearch.route,
        arguments = listOf(
            navArgument("order") { defaultValue = "popularity" },
            nullableNavArgument("kind"),
            nullableNavArgument("status"),
            nullableNavArgument("season"),
            nullableNavArgument("score"),
            nullableNavArgument("publisher"),
            nullableNavArgument("franchise"),
            nullableNavArgument("censored"),
            nullableNavArgument("mylist"),
        )
    ) {
        MangaSearch(
            viewModel = hiltViewModel(),
            openMangaDetails = { id ->
                navController.navigate(Screen.MangaDetails.createRoute(id))
            },
            navigateUp = {
                navController.navigateUp()
            }
        )
    }
}

private fun NavGraphBuilder.addAnimeAuthors(navController: NavHostController) {
    composable(Screen.AnimeAuthors.route) {
        AnimeAuthorsScreen(viewModel = hiltViewModel(), onNavigateUp = navController::navigateUp)
    }
}

fun NavGraphBuilder.addAnimeCharacters(navController: NavHostController) {
    composable(Screen.AnimeCharacters.route) {
        AnimeCharactersScreen(viewModel = hiltViewModel(), onNavigateUp = navController::navigateUp)
    }
}

private fun NavGraphBuilder.addHome(navController: NavController) {
    composable(Screen.Home.route) {
        Home(
            openAnimeSearch = {
                navController.navigate(Screen.AnimeSearch.createRoute())
            },
            openMangaSearch = {
                navController.navigate(Screen.MangaSearch.createRoute())
            },
            openRanobeSearch = {
                navController.navigate(Screen.RanobeSearch.createRoute())
            }
        )
    }
}

private fun NavGraphBuilder.addAnimeSearch(navController: NavController) {
    composable(
        route = Screen.AnimeSearch.route,
        arguments = listOf(
            navArgument("order") { defaultValue = "popularity" },
                nullableNavArgument("kind"),
                nullableNavArgument("status"),
                nullableNavArgument("season"),
                nullableNavArgument("score"),
                nullableNavArgument("duration"),
                nullableNavArgument("rating"),
                nullableNavArgument("studio"),
                nullableNavArgument("franchise"),
                nullableNavArgument("censored"),
                nullableNavArgument("mylist"),
        )
    ) {
        AnimeSearch(
            viewModel = hiltViewModel(),
            openAnimeDetails = { id ->
                navController.navigate(Screen.AnimeDetails.createRoute(id))
            },
            navigateUp = {
                navController.navigateUp()
            }
        )
    }
}

private fun NavGraphBuilder.addAnimeDetails(navController: NavController) {
    composable(
        route = Screen.AnimeDetails.route,
        arguments = listOf(navArgument("id") { NavType.LongType })
    ) {
        AnimeDetails(
            viewModel = hiltViewModel(),
            openAnimeDetails = { id ->
                navController.navigate(Screen.AnimeDetails.createRoute(id))
            },
            openCharacters = { id ->
                navController.navigate(Screen.AnimeCharacters.createRoute(id))
            },
            navigateUp = {
                navController.navigateUp()
            },
            openAuthors = { id ->
                navController.navigate(Screen.AnimeAuthors.createRoute(id))
            }
        )
    }
}

private fun nullableNavArgument(
    name: String,
    builder: (NavArgumentBuilder.() -> Unit)? = null
) = navArgument(name) {
    nullable = true
    defaultValue = null
    builder?.let {
        it()
    }
}
