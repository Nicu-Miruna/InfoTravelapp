package com.fmi.app;

import android.os.Bundle;
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

        switch(position) {
            case 0:
                titleTextView.setText("TURKEY");
                break;
            case 1:
                titleTextView.setText("FRANCE");
                break;
                case 2:
                    titleTextView.setText("SPAIN");
                break;
            case 3:
                titleTextView.setText("GREECE");
                break;
            case 4:
                titleTextView.setText("JAPAN");
                break;
        }

    }

}
