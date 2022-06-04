package com.fmi.app

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val position = intent.getIntExtra("position", 0)
        val titleTextView = findViewById<View>(R.id.titleView) as TextView
        val textView = findViewById<View>(R.id.textView) as TextView
        val imageView = findViewById<View>(R.id.imageView) as ImageView
        when (position) {
            0 -> {
                titleTextView.text = "SPAIN"
                textView.text =
                    """
                Mostly located on the Iberian Peninsula, Spain is the second most visited country in Europe. Around 82.7 million travellers stepped into Spain in 2018 alone, 1 million more than in the previous year.
                
                Spain has 47 UNESCO world heritage sites, numerous beaches on the Atlantic and Mediterranean, and numerous festivals that bring together people from all across the world. Many have compared the coastal part of Spain with tropical islands.
                """.trimIndent()
                imageView.setImageResource(R.drawable.spain)
            }
            1 -> {
                titleTextView.text = "FRANCE"
                textView.text =
                    "The world’s most visited country, France, is not all about the Eifel Tower, museums and wine. For more than a decade now, the country has lured the highest number of visitors, more than any other European or world country. The reasons for that are not few. The country has such a variety of tourism attractions that a year would not be enough to see and experience everything that it has to offer."
                imageView.setImageResource(R.drawable.france)
            }
            2 -> {
                titleTextView.text = "TURKEY"
                textView.text =
                    """
                    Packed to the brim with ancient monuments left over from a parade of empires, and endowed with showcase scenery that never fails to impress, Turkey is a dazzling destination that straddles Asia and Europe.
                    
                    Its vibrant culture, famous food, and vast history wow all who venture here, while its glorious landscapes, from the sun-soaked Mediterranean to the mighty mountains and arid steppe, are tourist attractions in themselves..
                    """.trimIndent()
                imageView.setImageResource(R.drawable.turkey)
            }
            3 -> {
                titleTextView.text = "JAPAN"
                textView.text =
                    " A land of unique culture and contrasts, Japan is a mix of fast-paced, modern life and ancient traditions. It offers a depth worth exploring so be sure to plan enough time in Japan to experience both ends of the spectrum."
                imageView.setImageResource(R.drawable.japan)
            }
            4 -> {
                titleTextView.text = "GREECE"
                textView.text =
                    "Among the most famous spots for visitors are the Acropolis, the monasteries of Meteora, the mystical Delphi ruins, the Temple of Hephaestus and many more. The capital of Athens, Thessaloniki, Corfu, Santorini and Crete are among the most visited cities and islands. There are more than 200 Greek islands that you can visit, each more beautiful than the other."
                imageView.setImageResource(R.drawable.greece)
            }
        }
    }

    companion object {
        private const val TAG = "GalleryActivity"
    }
}