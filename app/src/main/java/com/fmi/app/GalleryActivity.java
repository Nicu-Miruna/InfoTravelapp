package com.fmi.app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        int position = getIntent().getIntExtra("position", 0);
        TextView titleTextView = (TextView) findViewById(R.id.titleView);
        TextView textView = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        switch(position) {
            case 0:
                titleTextView.setText("SPAIN");
                textView.setText("Mostly located on the Iberian Peninsula, Spain is the second most visited country in Europe. Around 82.7 million travellers stepped into Spain in 2018 alone, 1 million more than in the previous year.\n" +
                        "\n" +
                        "Spain has 47 UNESCO world heritage sites, numerous beaches on the Atlantic and Mediterranean, and numerous festivals that bring together people from all across the world. Many have compared the coastal part of Spain with tropical islands.");
                imageView.setImageResource(R.drawable.spain);
                break;
            case 1:
                titleTextView.setText("FRANCE");
                textView.setText("The world’s most visited country, France, is not all about the Eifel Tower, museums and wine. For more than a decade now, the country has lured the highest number of visitors, more than any other European or world country. The reasons for that are not few. The country has such a variety of tourism attractions that a year would not be enough to see and experience everything that it has to offer.");
                imageView.setImageResource(R.drawable.france);
                break;
                case 2:
                    titleTextView.setText("TURKEY");
                    textView.setText("Packed to the brim with ancient monuments left over from a parade of empires, and endowed with showcase scenery that never fails to impress, Turkey is a dazzling destination that straddles Asia and Europe.\n" +
                            "\n" +
                            "Its vibrant culture, famous food, and vast history wow all who venture here, while its glorious landscapes, from the sun-soaked Mediterranean to the mighty mountains and arid steppe, are tourist attractions in themselves..");
                    imageView.setImageResource(R.drawable.turkey);
                break;
            case 3:
                titleTextView.setText("JAPAN");
                textView.setText(" A land of unique culture and contrasts, Japan is a mix of fast-paced, modern life and ancient traditions. It offers a depth worth exploring so be sure to plan enough time in Japan to experience both ends of the spectrum.");
                imageView.setImageResource(R.drawable.japan);
                break;
            case 4:
                titleTextView.setText("GREECE");
                textView.setText("Among the most famous spots for visitors are the Acropolis, the monasteries of Meteora, the mystical Delphi ruins, the Temple of Hephaestus and many more. The capital of Athens, Thessaloniki, Corfu, Santorini and Crete are among the most visited cities and islands. There are more than 200 Greek islands that you can visit, each more beautiful than the other.");
                imageView.setImageResource(R.drawable.greece);
                break;
        }

    }

}
