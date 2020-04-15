package com.pc.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

public class MySessionListener extends SessionListenerAdapter {

    /**
     * 作用于session创建之初
     * @param session
     */
    @Override
    public void onStart(Session session) {
        super.onStart(session);
        System.out.println("====>session create");
    }

    /**
     * 作用于session停止之时  subject.logout()   session.stop()
     * @param session
     */
    @Override
    public void onStop(Session session) {
        super.onStop(session);
        System.out.println("===>session stop");
    }

    @Override
    public void onExpiration(Session session) {
        super.onExpiration(session);
        System.out.println("===>session expiration");
    }
}
