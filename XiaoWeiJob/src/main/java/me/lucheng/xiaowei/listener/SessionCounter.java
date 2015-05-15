package me.lucheng.xiaowei.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounter
 *
 */
public class SessionCounter implements HttpSessionListener {

	private static int activeSessions = 0;

	public static int getActiveSessions() {
		return activeSessions;
	}

	/**
	 * Default constructor.
	 */
	public SessionCounter() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@\n\n@@@@@@############");
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Create Session");
		activeSessions++;
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Destory Session");
		activeSessions--;
	}

}
