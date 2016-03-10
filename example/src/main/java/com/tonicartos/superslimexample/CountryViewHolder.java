package com.tonicartos.superslimexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Simple view holder for a single text view.
 */
class CountryViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;

    private TextView mFriendName;
    private int mOriginalHeight = 0;
    private boolean mIsViewExpanded = false;

    CountryViewHolder(final View view) {
        super(view);

        mTextView = (TextView) view.findViewById(R.id.text);
        mButton1 = (Button) view.findViewById(R.id.button_1);
        mButton2 = (Button) view.findViewById(R.id.button_2);
    }

    public void bindItem(String text) {
        mTextView.setText(text);
    }

    @Override
    public String toString() {
        return mTextView.getText().toString();
    }

    public Button getmButton1() {
        return mButton1;
    }

    public Button getmButton2() {
        return mButton2;
    }
}
