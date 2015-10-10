package com.rakuishi.aileron.sample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.rakuishi.aileron.Aileron;
import com.rakuishi.aileron.annotations.Extra;

public class SampleFragment extends DialogFragment {

    private static final String EXTRA_MESSAGE = "message";

    @Extra(EXTRA_MESSAGE) String mMessage;

    public static SampleFragment create(String message) {
        SampleFragment fragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MESSAGE, message);
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Aileron.roll(this);

        return new AlertDialog.Builder(getActivity())
                .setMessage(mMessage)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
