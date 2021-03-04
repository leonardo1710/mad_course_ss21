package at.ac.fhcampus.numbermaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val guessList: ArrayList<GuessItem>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return guessList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val guess: GuessItem = guessList[position]
        holder.textViewOrder.text = guess.order.toString()
        holder.textViewGuess.text = guess.guess
        holder.symbolImg1.setImageResource(guess.firstSymbolSrc)
        holder.symbolImg2.setImageResource(guess.secondSymbolSrc)
        holder.symbolImg3.setImageResource(guess.thirdSymbolSrc)
        holder.symbolImg4.setImageResource(guess.fourthSymbolSrc)
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewOrder: TextView = itemView.findViewById(R.id.guess_order)
        val textViewGuess: TextView = itemView.findViewById(R.id.guess_textView)
        val symbolImg1: ImageView = itemView.findViewById(R.id.imageView1)
        val symbolImg2: ImageView = itemView.findViewById(R.id.imageView2)
        val symbolImg3: ImageView = itemView.findViewById(R.id.imageView3)
        val symbolImg4: ImageView = itemView.findViewById(R.id.imageView4)
    }

}