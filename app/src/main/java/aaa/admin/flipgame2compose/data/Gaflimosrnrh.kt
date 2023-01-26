package aaa.admin.flipgame2compose.data

import aaa.admin.flipgame2compose.data.Gaflimu.GAFLIM
import android.content.Context
import com.appsflyer.AppsFlyerLib
import com.onesignal.OSNotificationReceivedEvent
import com.onesignal.OneSignal.OSRemoteNotificationReceivedHandler

class Gaflimosrnrh : OSRemoteNotificationReceivedHandler {

    override fun remoteNotificationReceived(p0: Context?, p1: OSNotificationReceivedEvent?) {
        val gaflimonre = p1!!.notification.additionalData.get(GAFLIM).toString()
        if (gaflimonre.isNotEmpty()) {
            p0.let {
                AppsFlyerLib.getInstance().logEvent(p0, gaflimonre, null)
                p1.complete(null)
            }
        }
    }
}