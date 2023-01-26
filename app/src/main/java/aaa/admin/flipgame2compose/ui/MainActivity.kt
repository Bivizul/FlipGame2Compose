package aaa.admin.flipgame2compose.ui

import aaa.admin.flipgame2compose.data.Gaflimu.Gaflimimg
import aaa.admin.flipgame2compose.ui.theme.FlipGame2ComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipGame2ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Gaflimimg()
                    GaflimNavHost()
                }
            }
        }
    }
}