package edu.miu.cs473de.walmartapp_cs470de_612403

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473de.walmartapp_cs470de_612403.models.Category
import edu.miu.cs473de.walmartapp_cs470de_612403.models.Product
import org.json.JSONObject
import org.xml.sax.Parser

class CategoryProductsActivity : AppCompatActivity(),Adapter.ListenerProductItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_products)
        getProducts()
    }

    private fun getProducts() {
        val category=intent.getSerializableExtra("categoryJson") as Category
        initProductsRecycler(category.products!!)

    }
    private fun initProductsRecycler(products:List<Product>) {
        val rv=findViewById<RecyclerView>(R.id.rv_products)
        val productsAdapter=Adapter()
        productsAdapter.setAdapterType(Adapter.PRODUCT_TYPE)
        productsAdapter.setProducts(products)
        productsAdapter.setListenerProduct(this)
        rv.adapter=productsAdapter
    }

    override fun itemOnClick(product: Product) {
        TODO("Not yet implemented")
    }
}