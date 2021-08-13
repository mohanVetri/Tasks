package com.classFiles;

import javax.servlet.http.HttpServletResponse;

public class ReloadingWithoutCache {

    public static void reloadPage(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
    }

}
