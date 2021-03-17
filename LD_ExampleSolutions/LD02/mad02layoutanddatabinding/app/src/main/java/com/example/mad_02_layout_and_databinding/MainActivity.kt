package com.example.mad_02_layout_and_databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mad_02_layout_and_databinding.databinding.ActivityMainBinding
import com.example.mad_02_layout_and_databinding.models.Movie
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val movieDescription = "The Queen\'s Gambit follows the life of an orphan chess prodigy, Elizabeth Harmon, during her quest to become the world\'s greatest chess player while struggling with emotional problems and drug and alcohol dependency. The title of the series refers to a chess opening of the same name. The story begins in the mid-1950s and proceeds into the 1960s.[5]\n\n" + "The story begins in Lexington, Kentucky, where a nine-year-old Beth, having lost her mother in a car crash, is taken to an orphanage where she is taught chess by the building\'s custodian, Mr. Shaibel. As was common during the 1950s, the orphanage dispenses daily tranquilizer pills to the girls,[6][7] which turns into an addiction for Beth. She quickly becomes a strong chess player due to her visualization skills, which are enhanced by the tranquilizers. A few years later, Beth is adopted by Alma Wheatley and her husband from Lexington. As she adjusts to her new home, Beth enters a chess tournament and wins despite having no prior experience in competitive chess. She develops friendships with several people, including former Kentucky State Champion Harry Beltik, United States National Champion Benny Watts, and journalist and fellow player D.L. Townes. As Beth rises to the top of the chess world and reaps the financial benefits of her success, her drug and alcohol dependency becomes worse."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.movie = createMovieObject()

        binding.addToFavorites.setOnClickListener {
           Toast.makeText(this, "Movie saved to favorites.", Toast.LENGTH_LONG).show()
        }
    }

    private fun createMovieObject(): Movie{
        var movie = Movie("The Queen's Gambit", movieDescription)
        movie.actors.add("Anya Taylor-Joy")
        movie.actors.add("Chloe Pirrie")
        movie.genres = listOf("Drama", "Sport")
        movie.creators.add("Scott Frank")
        movie.creators.add("Alan Scott")
        movie.rating = 4.5F

        return movie
    }
}