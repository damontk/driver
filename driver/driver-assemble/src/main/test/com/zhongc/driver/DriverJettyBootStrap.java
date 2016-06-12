//package com.zhongc.driver;
//
//import org.eclipse.jetty.security.HashLoginService;
//import org.eclipse.jetty.server.Connector;
//import org.eclipse.jetty.server.Handler;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.handler.DefaultHandler;
//import org.eclipse.jetty.server.handler.HandlerCollection;
//import org.eclipse.jetty.server.nio.SelectChannelConnector;
//import org.eclipse.jetty.server.session.AbstractSessionManager;
//import org.eclipse.jetty.util.thread.QueuedThreadPool;
//import org.eclipse.jetty.webapp.WebAppContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// *
// *
// * @Filename DriverJettyBootStrap.java
// *
// * @Description
// *
// * @Version 1.0
// *
// * @Author zhongc
// *
// * @Email
// *
// * @History
// *<li>Author: zhongc<>
// *<li>Date:  2015-6-1<>
// *<li>Version: 1.0<>
// *<li>Content: create<>
// *
// */
//public class DriverJettyBootStrap {
//
//	private static final String					PROJECT_NAME	 = "driver-assemble";
//
//	private static final String					WEB_SRC			= PROJECT_NAME + "/src/main/webapp";
//
//	private static Logger logger			= LoggerFactory.getLogger(DriverJettyBootStrap.class);
//
//	private static String						WEBAPP_PATH		= getWebPath();
//
//	private final static int					port			= 80;
//
//	//使用者
//	private final static Map<String, String>	hostNameMapping	= new HashMap<String, String>();
//
//	public DriverJettyBootStrap() {
//		hostNameMapping.put("WEBAPP_PATH", WEBAPP_PATH);
//	}
//
//	public static void main(String[] args) throws Exception {
////		System.setProperty("spring.profiles.active", "dev");
////		System.setProperty("sys.validate.prefix", "http://www.zsyh.test");
//		Thread.currentThread().setName("driver-boot-1");
//		new DriverJettyBootStrap();
//		Server server = new Server();
//		QueuedThreadPool threadPool = new QueuedThreadPool();
//		threadPool.setMaxThreads(100);
//		server.setThreadPool(threadPool);
//		Connector connector = new SelectChannelConnector();
// 		connector.setPort(port); //端口
//		server.addConnector(connector);
//		WebAppContext context = new WebAppContext(WEBAPP_PATH, "/");
//		context.getSecurityHandler().setLoginService(new HashLoginService("TEST-SECURITY-REALM"));
//		AbstractSessionManager sm = (AbstractSessionManager) context.getSessionHandler().getSessionManager();
//		String defaultSessionCookie = sm.getSessionCookie();
//		sm.setSessionCookie(defaultSessionCookie + port);
//		HandlerCollection handlers = new HandlerCollection();
//		handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
//		server.setHandler(handlers);
//		server.setStopAtShutdown(true);
//		server.setSendServerVersion(true);
//		server.start();
//		logger.info("启动完毕");
//		server.join();
//
//	}
//
//	private static String getWebPath() {
//		String currentClassPath = DriverJettyBootStrap.class.getResource(
//			"/").getPath();
//
//		String webPath = currentClassPath.substring(0, currentClassPath.indexOf(PROJECT_NAME))
//							+ WEB_SRC;
//		System.out.println(webPath);
//		return webPath;
//	}
//
//
//}
