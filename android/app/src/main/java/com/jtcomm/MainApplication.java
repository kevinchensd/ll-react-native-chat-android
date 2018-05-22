package com.jtcomm;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.horcrux.svg.SvgPackage;
import com.netease.im.RNNeteaseImPackage;
import cn.jiguang.imui.messagelist.ReactIMUIPackage;

import com.netease.nimlib.sdk.mixpush.MixPushConfig;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import cn.qiuxiang.react.amap3d.AMap3DPackage;
import me.ele.dodo.AMapLocationReactPackage;
import com.reactnativenavigation.bridge.NavigationReactPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.netease.im.IMApplication;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.StatusBarNotificationConfig;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.mixpush.MixPushService;
import com.netease.nimlib.sdk.mixpush.NIMPushClient;
import com.netease.nimlib.sdk.msg.MessageNotifierCustomization;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.model.CustomNotification;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.RevokeMsgNotification;
import com.netease.nimlib.sdk.uinfo.UserInfoProvider;
import com.netease.nimlib.sdk.util.NIMUtil;

import java.util.Arrays;
import java.util.List;

import com.reactnativenavigation.NavigationApplication;

import android.content.Context;
import android.support.annotation.Nullable;

public class MainApplication extends NavigationApplication {

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new SvgPackage(),
                new RNNeteaseImPackage(),
                new ReactIMUIPackage(),
                new PickerPackage(),
                new AMap3DPackage(),
                new AMapLocationReactPackage()
        );
    }

    @Nullable
    @Override
    public List<ReactPackage> createAdditionalReactPackages() {
        return getPackages();
    }


  @Override
  public void onCreate() {
    super.onCreate();
    // 小米push
    IMApplication.init(this, MainActivity.class, R.drawable.ic_stat_notify_msg, new IMApplication.MiPushConfig("mipushcer","2882303761517793300","5311779331300"));

    // 此处 certificate 请传入开发者自身的华为证书名称
    //NIMPushClient.registerHWPush(this, "huaweipushcer");
    //IMApplication.init(this, MainActivity.class, R.drawable.ic_stat_notify_msg, null);
    SoLoader.init(this, /* native exopackage */ false);
  }

  // 如果返回值为 null，则全部使用默认参数。
  /*
     private SDKOptions options() {
         SDKOptions options = new SDKOptions();
          MixPushConfig config = new MixPushConfig();
          config.xmAppId = "2882303761517793300";
          config.xmAppKey = "5311779331300";
          config.xmCertificateName = "mipushcer";
          options.mixPushConfig = config;
         return options;
      }
      */
/*
    @Nullable
    @Override
    public String getJSMainModuleName() {
        return "index";
    }
    */
}