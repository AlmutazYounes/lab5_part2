import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5_part2.DetailActivity
import com.example.lab5_part2.R
import Product

class MyAdapter(
    private val context: Context,
    private val list: ArrayList<Product>,
    private val onAddToCart: (Product) -> Unit
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource(list[position].image)
        holder.textView.text = list[position].productName
        holder.addToCartButton.setOnClickListener {
            onAddToCart(list[position])
        }
        holder.imageView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("image", list[position].image)
            intent.putExtra("name", list[position].productName)
            intent.putExtra("detail", list[position].productDescription)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image1)
        var textView: TextView = itemView.findViewById(R.id.item)
        var addToCartButton: Button = itemView.findViewById(R.id.cart)
    }
}
