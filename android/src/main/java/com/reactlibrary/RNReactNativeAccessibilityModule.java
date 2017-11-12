package com.reactlibrary;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNReactNativeAccessibilityModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNReactNativeAccessibilityModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNAccessibility";
    }

    @ReactMethod
    void announce(String message) {
        final AccessibilityManager accessibilityManager = (AccessibilityManager) this.reactContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }

        final int eventType = AccessibilityEventCompat.TYPE_ANNOUNCEMENT;
        final AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        event.getText().add(message);
        event.setClassName(RNReactNativeAccessibilityModule.class.getName());
        event.setPackageName(this.reactContext.getPackageName());

        accessibilityManager.sendAccessibilityEvent(event);
    }


}