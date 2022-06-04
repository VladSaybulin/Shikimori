package ru.ironball.shikimori

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.ironball.shikimori.ui.AppNavigation
import ru.ironball.shikimori.ui.theme.ShikimoriTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShikimoriTheme {

                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !MaterialTheme.colors.isLight
                val systemUiColor = MaterialTheme.colors.primary

                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavigation()
                }

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = systemUiColor,
                        darkIcons = useDarkIcons,
                    )
                }
            }
        }
    }
}
