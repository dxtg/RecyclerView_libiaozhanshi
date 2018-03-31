package app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //用Fresco加载图片
        Fresco.initialize(this);
    }
}
