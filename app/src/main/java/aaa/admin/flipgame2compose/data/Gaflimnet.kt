package aaa.admin.flipgame2compose.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Gaflimnet {

    fun gaflimnet(): Gaflimser {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://65.109.10.118/games/FlipGame2Compose/")
            .build()
        return retrofit.create(Gaflimser::class.java)
    }
}