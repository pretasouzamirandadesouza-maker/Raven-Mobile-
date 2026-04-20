package com.samp.mobile.game;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

import com.joom.paranoid.Obfuscate;
import com.wardrumstudios.utils.WarMedia;

@Obfuscate
public class GTASA extends WarMedia {
    static String vmVersion;
    private boolean once = false;

    static {
        vmVersion = null;
        System.out.println("**** Loading SO's");
        try {
            vmVersion = System.getProperty("java.vm.version");
            System.out.println("vmVersion " + vmVersion);
            System.loadLibrary("ImmEmulatorJ");
        } catch (ExceptionInInitializerError | UnsatisfiedLinkError ignored) {
        }

        System.loadLibrary("GTASA");
        System.loadLibrary("bass");
        System.loadLibrary("samp");
    }

    public static void staticEnterSocialClub() {
    }

    public static void staticExitSocialClub() {
    }

    public void AfterDownloadFunction() {
    }

    public void EnterSocialClub() {
    }

    public void ExitSocialClub() {
    }

    public boolean ServiceAppCommand(String str, String str2) {
        return false;
    }

    public int ServiceAppCommandValue(String str, String str2) {
        return 0;
    }

    public native void main();

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public void onDestroy() {
        System.out.println("**** onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override
    public void onPause() {
        System.out.println("**** onPause");
        super.onPause();
    }

    @Override
    public void onRestart() {
        System.out.println("**** onRestart");
        super.onRestart();
    }

    @Override
    public void onResume() {
        System.out.println("**** onResume");
        super.onResume();
    }

    @Override
    public void onStart() {
        System.out.println("**** onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        System.out.println("**** onStop");
        super.onStop();
    }

    public native void setCurrentScreenSize(int i, int i2);
}
