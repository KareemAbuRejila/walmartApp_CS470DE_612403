package edu.miu.cs473de.walmartapp_cs470de_612403

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473de.walmartapp_cs470de_612403.models.Category
import edu.miu.cs473de.walmartapp_cs470de_612403.models.Product

class MainActivity : AppCompatActivity(),Adapter.ListenerCategoryItem {
    private val catsList=ArrayList<Category>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUserName()
        getCategories()
        initCatRecycler()
    }

    private fun initCatRecycler() {
        val rv=findViewById<RecyclerView>(R.id.rv_categories)
        val catsAdapter=Adapter()
        catsAdapter.setAdapterType(Adapter.CATEGORY_TYPE)
        catsAdapter.setCategories(this.catsList.toList())
        catsAdapter.setListenerCategory(this)
        rv.adapter=catsAdapter
    }

    fun getUserName(){
        val fullName=intent.extras?.getString("fullName")
        if (fullName!=null)
            findViewById<TextView>(R.id.tv_welcome).text= "Welcome $fullName"
    }

    fun getCategories(){
        val product1=Product(1,"T-shirt",50.0,1,R.drawable.walmart_logo,"red")
        val product2=Product(2,"Jacket",250.0,1,R.drawable.walmart_logo,"red")
        val product3=Product(3,"Jeans",34.0,1,R.drawable.walmart_logo,"red")
        val product4=Product(4,"shoos",77.0,1,R.drawable.walmart_logo,"red")
        catsList.add(
            Category(1,"Clothes",R.drawable.walmart_logo, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(2,"Sport",
                androidx.appcompat.R.drawable.abc_dialog_material_background, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(3,"Games",R.drawable.ic_launcher_background, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(4,"Electric",
                androidx.constraintlayout.widget.R.drawable.abc_btn_check_material_anim, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(5,"Laptops",
                androidx.constraintlayout.widget.R.drawable.abc_btn_radio_material, arrayListOf(product1,product2,product3,product4))
        )
    }

    override fun itemOnClick(category: Category) {
        getToCategoryParoductsActivity(category)
    }

    private fun getToCategoryParoductsActivity(category: Category) {
        val intent= Intent(this,CategoryProductsActivity::class.java)
        intent.putExtra("categoryJson",category)
        startActivity(intent)
    }
}