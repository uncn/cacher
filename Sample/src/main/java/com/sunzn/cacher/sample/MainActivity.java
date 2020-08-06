package com.sunzn.cacher.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.sunzn.cacher.library.CacheManager;
import com.sunzn.cacher.library.CacheProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String content = "应用访问文件和目录最便捷的方式是使用 Context 类提供的方法。Context 类是所有关键应用组件的超类，常见的几个应用组件有：Application、Activity 和 Service。因此，这些子类可使用 Context 类提供的方法（如下表所示）轻松访问文件和目录。";

        CacheManager.save(this, content, HomeProvider.Base.HOME, new HomeProvider.Base());

        CacheManager.save(this, content, HomeProvider.User.DISK, new HomeProvider.User());

        CacheManager.clear(this, new HomeProvider.Base());

        int count = CacheManager.count(this, new HomeProvider.User());
        Log.e("CacheManager", "count = " + count);

        String read = CacheManager.read(this, HomeProvider.User.DISK, new HomeProvider.User());
        Log.e("CacheManager", "read = " + read);

        CacheManager.delete(this, HomeProvider.User.DISK, new HomeProvider.User());

        int count1 = CacheManager.count(this, new HomeProvider.User());
        Log.e("CacheManager", "count = " + count1);

        CacheManager.save(this, content, "test.txt", new CacheProvider() {
            @Override
            public String initUser() {
                return null;
            }

            @Override
            public String initMenu() {
                return null;
            }

            @Override
            public String initAuth() {
                return null;
            }
        });

    }
}
