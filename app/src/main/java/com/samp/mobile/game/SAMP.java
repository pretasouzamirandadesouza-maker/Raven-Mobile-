package com.samp.mobile.game;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.joom.paranoid.Obfuscate;
import com.samp.mobile.game.ui.AttachEdit;
import com.samp.mobile.game.ui.CustomKeyboard;
import com.samp.mobile.game.ui.LoadingScreen;
import com.samp.mobile.game.ui.dialog.DialogManager;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Obfuscate
public class SAMP extends GTASA implements CustomKeyboard.InputListener {

    private static final String TAG = "SAMP";
    private static SAMP instance;

    private CustomKeyboard mKeyboard;
    private DialogManager mDialog;
    private AttachEdit mAttachEdit;
    private LoadingScreen mLoadingScreen;

    public static SAMP getInstance() {
        return instance;
    }

    public native void sendDialogResponse(int i, int i2, int i3, byte[] str);

    private native void onInputEnd(byte[] str);
    private native void initializeSAMP();
    public native void onEventBackPressed();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "**** onCreate");
        super.onCreate(savedInstanceState);

        instance = this;

        try {
            mKeyboard = new CustomKeyboard(this);
            mDialog = new DialogManager(this);
            mAttachEdit = new AttachEdit(this);
            mLoadingScreen = new LoadingScreen(this);

            initializeSAMP();

        } catch (Exception e) {
            Log.e(TAG, "Erro ao iniciar SAMP", e);
        }
    }

    public void showDialog(int dialogId, int dialogTypeId, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        final String caption = new String(bArr, StandardCharsets.UTF_8);
        final String content = new String(bArr2, StandardCharsets.UTF_8);
        final String leftBtnText = new String(bArr3, StandardCharsets.UTF_8);
        final String rightBtnText = new String(bArr4, StandardCharsets.UTF_8);

        runOnUiThread(() -> mDialog.show(dialogId, dialogTypeId, caption, content, leftBtnText, rightBtnText));
    }

    private void showKeyboard() {
        runOnUiThread(() -> mKeyboard.ShowInputLayout());
    }

    private void hideKeyboard() {
        runOnUiThread(() -> mKeyboard.HideInputLayout());
    }

    private void showEditObject() {
        runOnUiThread(() -> mAttachEdit.show());
    }

    private void hideEditObject() {
        runOnUiThread(() -> mAttachEdit.hide());
    }

    private void hideLoadingScreen() {
        runOnUiThread(() -> mLoadingScreen.hide());
    }

    public void setPauseState(boolean pause) {
        runOnUiThread(() -> {
            if (pause) {
                mDialog.hideWithoutReset();
                mAttachEdit.hideWithoutReset();
            } else {
                if (mDialog.isShow) {
                    mDialog.showWithOldContent();
                }

                if (mAttachEdit.isShow) {
                    mAttachEdit.showWithoutReset();
                }
            }
        });
    }

    public void exitGame() {
        finishAndRemoveTask();
        System.exit(0);
    }

    @Override
    public void OnInputEnd(String str) {
        byte[] toReturn = null;

        try {
            toReturn = str.getBytes("windows-1251");
        } catch (UnsupportedEncodingException ignored) {
        }

        try {
            onInputEnd(toReturn);
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Erro em onInputEnd", e);
        }
    }

    @Override
    public void onStart() {
        Log.i(TAG, "**** onStart");
        super.onStart();
    }

    @Override
    public void onRestart() {
        Log.i(TAG, "**** onRestart");
        super.onRestart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "**** onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "**** onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "**** onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "**** onDestroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onEventBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onEventBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }
                }
