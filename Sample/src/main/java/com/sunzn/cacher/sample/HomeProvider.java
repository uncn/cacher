package com.sunzn.cacher.sample;

import com.sunzn.cacher.library.CacheProvider;

public class HomeProvider {

    public static class Base extends CacheProvider {

        public static final String HOME = "home.txt";

        @Override
        public String initUser() {
            return "sunzn";
        }

        @Override
        public String initMenu() {
            return "home";
        }

        @Override
        public String initAuth() {
            return "base";
        }

    }

    public static class User extends CacheProvider {

        public static final String DISK = "disk.txt";

        @Override
        public String initUser() {
            return "sunzn";
        }

        @Override
        public String initMenu() {
            return "home";
        }

        @Override
        public String initAuth() {
            return "user";
        }

    }

}
