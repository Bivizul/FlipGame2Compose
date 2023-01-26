package aaa.admin.flipgame2compose.data

import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Gaflimser {

    @POST("gaflimr.php")
    suspend fun setGaflimr(@Body gaflimr: JSONObject)

    @POST("gaflim.php")
    suspend fun getGaflimg(@Body gaflim: Gaflim): Response<Gaflimg>


}