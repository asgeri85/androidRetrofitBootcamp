package net.btpro.client.bootcamp25may

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import net.btpro.client.bootcamp25may.adapter.ProductAdapter
import net.btpro.client.bootcamp25may.api.ApiUtils
import net.btpro.client.bootcamp25may.databinding.ActivityMainBinding
import net.btpro.client.bootcamp25may.model.ProductsReponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val api = ApiUtils.getStoreApi()
    private val productAdapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        getProductData()
    }

    private fun setRecycler() {
        binding.rvProduct.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvProduct.adapter = productAdapter
    }

    private fun getProductData() {
        binding.progressBar.visibility=View.VISIBLE
        api.getAllProducts().enqueue(object : Callback<List<ProductsReponseItem>> {
            override fun onResponse(
                call: Call<List<ProductsReponseItem>>,
                response: Response<List<ProductsReponseItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { productAdapter.updateList(it) }
                }else{
                    Toast.makeText(applicationContext,"Beklenmeyen hata oluştu",Toast.LENGTH_LONG).show()
                }
                binding.progressBar.visibility=View.GONE
            }

            override fun onFailure(call: Call<List<ProductsReponseItem>>, t: Throwable) {
                binding.progressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"İnternet bağlantınızı kontrol edin",Toast.LENGTH_LONG).show()
            }

        })
    }
}