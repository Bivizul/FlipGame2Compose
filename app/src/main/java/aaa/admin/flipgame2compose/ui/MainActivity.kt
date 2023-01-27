package aaa.admin.flipgame2compose.ui

import aaa.admin.flipgame2compose.data.Gaflimu
import aaa.admin.flipgame2compose.ui.theme.FlipGame2ComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipGame2ComposeTheme {
                if (Gaflimu.getGaflimnet(this)) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        GaflimNavHost()
                    }
                } else {
                    Gaflimu.getGaflimdlg(this)
                }

            }
        }
    }
}
