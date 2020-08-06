package com.sunzn.cacher.library;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CacheManager {

    public static void save(Context context, String content, String filename, CacheProvider provider) {
        if (context != null && !TextUtils.isEmpty(content) && provider != null) {
            try {
                File file = new File(context.getExternalFilesDir(initMenu(provider)), initFile(filename));
                CacheHelper.save(file, content, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String read(Context context, String filename, CacheProvider provider) {
        if (context != null && provider != null) {
            try {
                File file = new File(context.getExternalFilesDir(initMenu(provider)), initFile(filename));
                String content = CacheHelper.read(file, "UTF-8");
                if (!TextUtils.isEmpty(content)) {
                    return content;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Value.EMPTY;
    }

    public static int count(Context context, CacheProvider provider) {
        if (context != null && provider != null) {
            try {
                File dir = context.getExternalFilesDir(initMenu(provider));
                if (dir != null) {
                    File file = new File(dir.toURI());
                    if (file.isDirectory()) {
                        String[] list = file.list();
                        return list == null ? 0 : list.length;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static List<String> files(Context context, CacheProvider provider) {
        if (context != null && provider != null) {
            try {
                File dir = context.getExternalFilesDir(initMenu(provider));
                if (dir != null) {
                    File file = new File(dir.toURI());
                    if (file.isDirectory()) {
                        String[] list = file.list();
                        if (list == null) {
                            return new ArrayList<>();
                        } else {
                            return Arrays.asList(list);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static void clear(Context context, CacheProvider provider) {
        try {
            File dir = context.getExternalFilesDir(initMenu(provider));
            if (dir != null && dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(Context context, String filename, CacheProvider provider) {
        try {
            File file = new File(context.getExternalFilesDir(initMenu(provider)), initFile(filename));
            if (file.exists()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String initMenu(CacheProvider provider) {
        StringBuilder cache = new StringBuilder(".").append("cache");
        if (!TextUtils.isEmpty(provider.initUser())) {
            cache.append("/").append(".").append(provider.initUser());
        }
        if (!TextUtils.isEmpty(provider.initMenu())) {
            cache.append("/").append(".").append(provider.initMenu());
        }
        if (!TextUtils.isEmpty(provider.initAuth())) {
            cache.append("/").append(".").append(provider.initAuth());
        }
        return new String(cache);
    }

    private static String initFile(String filename) {
        return new String(new StringBuilder(".").append(filename));
    }

}
