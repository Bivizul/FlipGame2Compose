package aaa.admin.flipgame2compose.ui

import aaa.admin.flipgame2compose.data.Gaflim
import aaa.admin.flipgame2compose.data.Gaflimnet
import aaa.admin.flipgame2compose.data.Gaflimu
import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.util.*

var gaflimsec = 0

@Composable
fun GaflimashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val gaflimc = LocalContext.current as Activity

    Gaflimu.Gaflimimg()

    LaunchedEffect(null) {
        CoroutineScope(Dispatchers.Main).launch {
            if (Gaflimu.getGaflimn(gaflimc) == Gaflimu.GAFLIMD) gaflimcn(gaflimc, navController)
            else gaflimsuc(gaflimc, navController)
        }
    }
}

private fun gaflimsuc(
    gaflimc: Activity,
    navController: NavHostController,
) {
    CoroutineScope(Dispatchers.Main).launch {
        val gaflimgr = Gaflimnet.gaflimnet().getGaflimg(
            Gaflim(
                Gaflimu.getGaflimm(),
                Gaflimu.getGaflimi(gaflimc),
                Gaflimu.getGaflimf(gaflimc, gaflimsec),
                Gaflimu.getGaflimj(gaflimc),
                Gaflimu.getGaflims(gaflimc),
                Gaflimu.getGaflimn(gaflimc),
                Gaflimu.getGaflimt(),
                Gaflimu.getGafliml(),
            )
        )
        if (gaflimgr.isSuccessful) {
            if (gaflimgr.body() != null) {
                gaflimgr.body()?.let { gaflimg ->
                    when (gaflimg.gaflimg) {
                        Gaflimu.GAFLIMG -> {
                            navController.navigate(Screen.Gaflimame.route)
                        }
                        Gaflimu.GAFLIMNP -> {
                            Gaflimu.setGaflimosdp()
                            navController.navigate(Screen.Gaflimame.route)
                        }
                        else -> {
                            Gaflimu.setGaflimb(gaflimc)
                            OneSignal.setExternalUserId(Gaflimu.getGamflitpvi(gaflimg.gaflimg))
                            AppsFlyerLib.getInstance()
                                .setCustomerUserId(Gaflimu.getGamflitpvi(gaflimg.gaflimg))
                            val gaflimi = Intent(gaflimc, GaflimActivity::class.java)
                            gaflimi.putExtra(Gaflimu.GAFLIMKOR, gaflimg.gaflimg)
                            startActivity(gaflimc, gaflimi, null)
                            gaflimc.finish()
                        }
                    }
                }
            } else {
                Gaflimu.getGaflimdlg(gaflimc)
            }
        } else {
            Gaflimu.getGaflimdlg(gaflimc)
        }
    }
}

private fun gaflimtimer(
    gaflimc: Activity,
    navController: NavHostController,
) {
    val gaflimtimer = Timer()
    gaflimtimer.schedule(object : TimerTask() {
        override fun run() {
            if (Gaflimu.getGaflimafd(gaflimc) != Gaflimu.GAFLIMEJ) {
                try {
                    val gaflimafd = JSONObject(Gaflimu.getGaflimafd(gaflimc))
                    if (gaflimafd.get(Gaflimu.GAFLIMFOS) == Gaflimu.GAFLIMOV) {
                        Gaflimu.setGaflimcb(
                            gaflimc,
                            gaflimafd.get(Gaflimu.GAFLIMFOS) as String
                        )
                        gaflimtimer.cancel()
                        gaflimsuc(gaflimc, navController)
                    } else if (gaflimafd.get(Gaflimu.GAFLIMNOS).toString().isNotEmpty()) {
                        Gaflimu.setGaflimcb(
                            gaflimc,
                            gaflimafd.get(Gaflimu.GAFLIMNOS) as String
                        )
                        gaflimtimer.cancel()
                        gaflimsuc(gaflimc, navController)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    gaflimtimer.cancel()
                    gaflimsuc(gaflimc, navController)
                }
            }
            gaflimsec++
            if (gaflimsec == 10) {
                gaflimtimer.cancel()
                gaflimsuc(gaflimc, navController)
            }
        }
    }, 0, 1000)
}

private fun gaflimcn(
    gaflimc: Activity,
    navController: NavHostController,
) {
    if (!Gaflimu.getGaflimcb(gaflimc)) {
        if (Gaflimu.getGaflimafd(gaflimc) != Gaflimu.GAFLIMEJ) {
            val gaflimafd = JSONObject(Gaflimu.getGaflimafd(gaflimc))
            if (gaflimafd.get(Gaflimu.GAFLIMFOS) == Gaflimu.GAFLIMOV) {
                Gaflimu.setGaflimcb(gaflimc, gaflimafd.get(Gaflimu.GAFLIMFOS) as String)
                Gaflimu.setGaflimlu(gaflimafd)
            } else if (gaflimafd.get(Gaflimu.GAFLIMNOS).toString().isNotEmpty()) {
                Gaflimu.setGaflimcb(gaflimc, gaflimafd.get(Gaflimu.GAFLIMNOS) as String)
                Gaflimu.setGaflimlu(gaflimafd)
            }
        }
        gaflimsuc(gaflimc, navController)
    } else {
        gaflimtimer(gaflimc, navController)
    }
}
