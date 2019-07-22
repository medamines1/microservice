package com.proxym.api;

import javax.servlet.http.HttpSession;


public class Utils {
    public static void saveDataInSession(String dataName, Object data) {
        HttpSession session = SystemInfoLocalThreadHolder.getUserSession();
        if (session != null) {
            session.setAttribute(dataName, data);
        }
    }


    public static Object getDataFromSession(String dataName) {
        HttpSession session = SystemInfoLocalThreadHolder.getUserSession();
        Object data = null;
        if (session != null) {
            data = session.getAttribute(dataName);
        }
        return data;
    }

    public static void removeDataFromSession(String dataName) {
        HttpSession session = SystemInfoLocalThreadHolder.getUserSession();
        Object data = null;
        if ((session != null)) {
            session.removeAttribute(dataName);
        }
    }

}
