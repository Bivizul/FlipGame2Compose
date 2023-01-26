package aaa.admin.flipgame2compose.data

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
object Gaflimu {

    private const val GAFLIMIH = "http://65.109.10.118/games/FlipGame/h.jpg"
    private const val GAFLIMT = "Oops, error connection game network"
    private const val GAFLIMIV = "http://65.109.10.118/games/FlipGame/v.jpg"
    private const val GAFLIMM = "Please reload game"
    private const val GAFLIMK = "gaflimk"
    private const val NOGAFLIM = "nogaflim"
    private const val GAFLIMGMT = "GMT"
    private const val GAFLIMPB = "Exit"
    private const val AFPREFGAFLIM = "appsflyer-data"
    private const val GAFLIMAI = "attributionId"
    const val GAFLIMFOS = "af_status"
    const val GAFLIMAF = "VdkuAEYGy3tZxMUc6xgshQ"
    const val GAFLIMDOR = "https://www.google.com/"
    const val GAFLIMKOR = "gaflimkor"
    const val GAFLIMNOS = "campaign"
    const val GAFLIMOV = "Organic"
    const val GAFLIM = "gaflim"
    const val GAFLIMRC = 100
    const val GAFLIMFL = "gaflimfl"
    const val GAFLIMOS = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
    const val GAFLIMD = "default"
    const val GAFLIMG = "gaflimg"
    const val GAFLIMEJ = "[]"
    const val APPPREFGAFLIM = "appprefgaflim"
    const val GAFLIMNP = "nopush"

    fun setGaflimb(gaflimc: Context) {
        val gaflimsp =
            gaflimc.getSharedPreferences(APPPREFGAFLIM, Context.MODE_PRIVATE)
        gaflimsp.edit().putBoolean(GAFLIMFL, false).apply()
    }

    fun getGafliml() = Locale.getDefault().language


    fun setGaflimcb(gaflimc: Context, gaflims: String) {
        val gaflimafsp =
            gaflimc.getSharedPreferences(AFPREFGAFLIM, Context.MODE_PRIVATE)
        gaflimafsp.edit().putString(GAFLIM, gaflims).apply()
    }

    fun getGaflimcb(gaflimc: Context): Boolean {
        val gaflimafsp =
            gaflimc.getSharedPreferences(AFPREFGAFLIM, Context.MODE_PRIVATE)
        return gaflimafsp.getBoolean(GAFLIMFL, true)
    }

    fun getGaflimdlg(gaflimact: Activity) {
        AlertDialog.Builder(gaflimact).apply {
            setTitle(GAFLIMT)
            setMessage(GAFLIMM)
            setPositiveButton(GAFLIMPB) { _, _ ->
                gaflimact.finish()
                System.exit(0)
            }
            setCancelable(true)
        }.create().show()
    }

    fun setGaflimosdp() = OneSignal.disablePush(true)

    fun getGaflimt(): String {
        val gaflimtz: String = SimpleDateFormat("z", Locale.getDefault()).format(
            Calendar.getInstance(
                TimeZone.getTimeZone(GAFLIMGMT), Locale.getDefault()
            ).time
        ).replace(GAFLIMGMT, "")
        val gaflimzone = if (gaflimtz.contains(":")) gaflimtz else GAFLIMD
        return gaflimzone
    }

    fun getGaflimi(gaflimc: Context): String {
        val gaflimsp = gaflimc.getSharedPreferences(APPPREFGAFLIM, Context.MODE_PRIVATE)
        var gaflimid = gaflimsp.getString(GAFLIMK, NOGAFLIM) ?: NOGAFLIM
        if (gaflimid == NOGAFLIM) {
            val gaflimd = Date()
            val gaflimsdf = SimpleDateFormat("yyMMddhhmmssMs")
            val gaflimdt = gaflimsdf.format(gaflimd)
            val gaflimrn = (10000 until 100000).random()
            gaflimid = gaflimdt + gaflimrn
            gaflimsp.edit().putString(GAFLIMK, gaflimid).apply()
        }
        return gaflimid
    }

    fun getGaflimafd(gaflimc: Context): String {
        val gaflimafsp =
            gaflimc.getSharedPreferences(AFPREFGAFLIM, Context.MODE_PRIVATE)
        return gaflimafsp.getString(GAFLIMAI, GAFLIMEJ) ?: GAFLIMEJ
    }

    fun setGaflimlu(gaflimjo: JSONObject) {
        CoroutineScope(Dispatchers.IO).launch {
            Gaflimnet.gaflimnet().setGaflimr(
                gaflimjo
            )
        }
    }

    fun getGaflims(gaflimc: Context) =
        (gaflimc.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).simCountryIso

    fun getGaflimj(gaflimc: Context): JSONObject {
        val gaflimsp =
            gaflimc.getSharedPreferences(AFPREFGAFLIM, Context.MODE_PRIVATE)
        val gaflimd = gaflimsp.getString(GAFLIMAI, GAFLIMEJ) ?: GAFLIMEJ
        return try {
            JSONObject(gaflimd)
        } catch (e: Exception) {
            JSONObject()
        }
    }

    fun getGaflimn(gaflimc: Context): String {
        val gaflimsp =
            gaflimc.getSharedPreferences(APPPREFGAFLIM, Context.MODE_PRIVATE)
        return gaflimsp.getString(GAFLIM, GAFLIMD) ?: GAFLIMD
    }

    fun getGaflimm() = "${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}"

    @SuppressLint("MissingPermission")
    fun getGaflimnet(gaflimc: Context): Boolean {
        val conmangaflim =
            gaflimc.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netinfgaflim = conmangaflim.activeNetworkInfo
        return netinfgaflim != null && netinfgaflim.isConnected
    }

    fun getGaflimf(gaflimc: Context, gaflimsec: Int): Int {
        val gaflimsp =
            gaflimc.getSharedPreferences(AFPREFGAFLIM, Context.MODE_PRIVATE)
        return if (gaflimsp.getBoolean(GAFLIMFL, true)) gaflimsec else -1
    }

    fun getGaflimimg(gaflimc: Context): String {
        val gaflimc = gaflimc.resources.configuration.orientation
        val gaflimi = if (gaflimc == Configuration.ORIENTATION_PORTRAIT) {
            GAFLIMIV
        } else {
            GAFLIMIH
        }
        return gaflimi
    }

    fun getGamflitpvi(noofits: String): String {
        val noofitmin = noofits.indexOf("view_id=") + 8
        val noofitmax = noofits.indexOf("&stream")
        return noofits.substring(noofitmin, noofitmax)
    }
}