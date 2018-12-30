
package com.airship.customwebview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

public class CustomWebViewPackage implements ReactPackage {
  private CustomWebViewModule module;
  private CustomWebViewManager viewManager;

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
    module = new CustomWebViewModule(reactContext);
    module.setPackage(this);

    List<NativeModule> modules = new ArrayList<>();
    modules.add(module);

    return modules;
  }

  // Deprecated RN 0.47
  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Collections.emptyList();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    viewManager = new CustomWebViewManager();
    viewManager.setPackage(this);
    return Arrays.<ViewManager>asList(viewManager);
  }

  public CustomWebViewModule getModule() {
    return module;
  }

  public CustomWebViewManager getViewManager() {
    return viewManager;
  }
}
