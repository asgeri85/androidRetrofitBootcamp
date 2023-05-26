package net.btpro.client.bootcamp25may.api

class ApiUtils {
    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
        fun getStoreApi(): StoreApi {
            return RetrofitClient.getRetrofitClient(BASE_URL).create(StoreApi::class.java)
        }
    }
}