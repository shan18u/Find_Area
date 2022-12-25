package com.example.find_my_class

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView: ListView = findViewById(R.id.listview);


/*
            // getting the recyclerview by its id
            val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(this)


            // ArrayList of class ItemsViewModel
            val data = ArrayList<ItemsViewModel>()

            // This loop will create 20 Views containing
            // the image with the count of view
          /**  for (i in 1..20) {
                data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24, "Item " + i))
            }*/


            fetchJaosn()

    }
        fun fetchJaosn(){
            println("fetching")


            val request = Request.Builder()
                .url("https://catalog.sjsu.edu/preview_program.php?catoid=10&poid=2524")
                .build()

            val client = OkHttpClient()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                for ((name, value) in response.headers) {
                    println("$name: $value")
                }

                val body = response.body!!.string()
                println(body)
                val gson = GsonBuilder().create()
              //  val homeFeed = gson.fromJson(body, HomeFeed::class.java)

            }

        }

}
class HomeFeed(val areas : List<texts>)
class texts (val id: Int, val name: String )


*/

        var rf = Retrofit.Builder().baseUrl(RetrofitInterface.BASE_Url).addConverterFactory(GsonConverterFactory.create()).build()

        var API = rf.create(RetrofitInterface::class.java)
        var call = API.post

        call?.enqueue(object: Callback<List<PostModel?>?>{
            override fun onResponse(
                call: Call<List<PostModel?>?>,
                response: Response<List<PostModel?>?>
            ) {
                var postlist : List<PostModel>? = response.body() as List<PostModel>
                var post : Array<String?> = arrayOfNulls<String>(postlist!!.size)
                for (i:Int in postlist!!.indices)
                    post[i]=postlist!![i]!!.core_41826

                var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)
                listView.adapter = adapter

            }

            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {
            }

        })

    }
}