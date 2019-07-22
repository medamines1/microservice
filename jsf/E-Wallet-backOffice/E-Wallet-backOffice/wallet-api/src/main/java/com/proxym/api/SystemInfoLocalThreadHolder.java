package com.proxym.api;

import javax.servlet.http.HttpSession;

/**
 * Created by med-amine.ben-ahmed on 01/11/2017.
 */
public class SystemInfoLocalThreadHolder {

    private static ThreadLocal storage = new ThreadLocal();
    public static String getUser()
    {
        String userId = null;
        UserInfoThread usrInfo = (UserInfoThread)storage.get();
        if(usrInfo != null)
        {
            userId = usrInfo.getUserId();
        }
        return userId;
    }

    public static String getUserIPAddress()
    {
        String ipAddress = null;
        UserInfoThread usrInfo = (UserInfoThread)storage.get();
        if(usrInfo != null)
        {
            ipAddress = usrInfo.getIpAddress();
        }
        return ipAddress;
    }

    public static String getUserSessionId()
    {
        String sessionId = null;
        UserInfoThread usrInfo = (UserInfoThread)storage.get();
        if(usrInfo != null)
        {
            HttpSession session = usrInfo.getSession();
            if(session != null)
                sessionId = session.getId();
        }
        return sessionId;
    }

    public static HttpSession getUserSession()
    {
        HttpSession session = null;
        UserInfoThread usrInfo = (UserInfoThread)storage.get();
        if(usrInfo != null)
        {
            session = usrInfo.getSession();
        }
        return session;
    }

    /*public static void setUser(String newUser)
    {
        // remove old value just in case
        storage.set(null);
        storage.set(newUser);
    }*/
    public static void setUserInfo(UserInfoThread usrInfo)
    {
        // remove old value just in case
        storage.set(null);
        storage.set(usrInfo);

    }
}
