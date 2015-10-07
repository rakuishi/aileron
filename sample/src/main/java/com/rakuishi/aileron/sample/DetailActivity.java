package com.rakuishi.aileron.sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rakuishi.aileron.Aileron;
import com.rakuishi.aileron.annotations.Extra;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_USER_ID = "user_id";

    @Extra(EXTRA_USER_ID) int mUserId;

    public static Intent create(Context context, int userId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_USER_ID, userId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Aileron.roll(this);

        String text = EXTRA_USER_ID + ": " + mUserId;

        TextView textView = (TextView) findViewById(R.id.detail_textview);
        textView.setText(text);
    }
}
