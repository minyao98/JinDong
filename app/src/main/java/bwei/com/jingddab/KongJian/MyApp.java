package bwei.com.jingddab.KongJian;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

    }
}
