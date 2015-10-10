package com.rakuishi.aileron.sample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity activity = this;

        {
            Button button = (Button) findViewById(R.id.main_activity_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(SampleActivity.create(activity, 1207));
                }
            });
        }

        {
            Button button = (Button) findViewById(R.id.main_fragment_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SampleFragment fragment = SampleFragment.create(getString(R.string.app_name));
                    fragment.show(getSupportFragmentManager(), "dialog");
                }
            });
        }
    }
}
