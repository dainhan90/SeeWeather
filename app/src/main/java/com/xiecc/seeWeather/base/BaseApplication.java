package com.xiecc.seeWeather.base;

import android.app.Application;
import android.content.Context;
import com.xiecc.seeWeather.component.RetrofitSingleton;

/**
 * Created by xcc on 2015/12/16.
 */
public class BaseApplication extends Application {

    public static String cacheDir = "";
    public static Context mAppContext = null;


    @Override public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        // 初始化 retrofit
        RetrofitSingleton.init(getApplicationContext());
        //
        //SharedPreferencesUtil.init(getApplicationContext());
        //
        //CrashHandler.init(new CrashHandler(getApplicationContext()));
        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        }
        else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }
}