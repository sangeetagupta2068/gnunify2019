package com.sangeetagupta.gnunify_test_app;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int colorResourceIds[];
    TextView textView;
    View layout;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setListener();

    }

    public void initialize(){

        colorResourceIds = new int[]{R.color.colorGreen, R.color.colorBlue, R.color.colorOrange, R.color.colorPurpler, R.color.colorAccent};

        textView = findViewById(R.id.textView);
        layout = findViewById(R.id.layout);

        random = new Random();

    }

    public void setListener(){

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int colorId = random.nextInt(colorResourceIds.length);

                layout.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,
                        new int[]{getResources().getColor(colorResourceIds[colorId]),
                                getResources().getColor(R.color.colorWhite),
                                getResources().getColor(colorResourceIds[colorId])}));

                colorId = random.nextInt(colorResourceIds.length);
                textView.setTextColor(getResources().getColor(colorResourceIds[colorId]));

            }
        });
    }
}
