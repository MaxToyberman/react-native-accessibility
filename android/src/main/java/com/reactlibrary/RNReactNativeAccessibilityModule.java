
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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
      final AccessibilityManager accessibilityManager = (AccessibilityManager) mContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
      if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
          return;
      }

      final int eventType = AccessibilityEventCompat.TYPE_ANNOUNCEMENT;
      final AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
      event.getText().add(message);
      event.setClassName(AccessibilityModule.class.getName());
      event.setPackageName(mContext.getPackageName());

      accessibilityManager.sendAccessibilityEvent(event);
  }
  

}