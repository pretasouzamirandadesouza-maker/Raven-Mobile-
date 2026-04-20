package com.samp.mobile.launcher.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import com.samp.mobile.game.SAMP;

@SuppressLint("AppCompatCustomView")
public class CustomEditText extends EditText {

    private Context mContext;

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setBackListener(Context context) {
        mContext = context;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                ((SAMP) mContext).onEventBackPressed();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
