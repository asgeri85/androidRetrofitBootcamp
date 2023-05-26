package net.btpro.client.bootcamp25may.api

import net.btpro.client.bootcamp25may.model.ProductsReponseItem
import retrofit2.Call
import retrofit2.http.GET

interface StoreApi {

    @GET("products")
    fun getAllProducts():Call<List<ProductsReponseItem>>

}