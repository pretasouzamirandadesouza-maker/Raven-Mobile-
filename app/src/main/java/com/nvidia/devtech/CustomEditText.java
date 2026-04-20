package com.nvidia.devtech;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class CustomEditText extends EditText {

    private Context mContext;

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public CustomEditText(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                ((NvEventQueueActivity) mContext).onEventBackPressed();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
