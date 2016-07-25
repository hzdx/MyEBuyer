package com.mycom.start;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Launcher {

	public static final int PORT = 8080;
	public static final String CONTEXT_PATH = "/";
	public static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";

	/**
	 * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
	 */
	public static Server createServerInSource(int port,String webappPath, String ctxPath) {
		Server server = new Server();
		// 设置在JVM退出时关闭Jetty的钩子。
		server.setStopAtShutdown(true);

		// 这是http的连接器
		// ServerConnector connector = new ServerConnector(server);
		ServerConnector connector = new NetworkTrafficServerConnector(server);// nio
		connector.setPort(port);
		// 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
		connector.setReuseAddress(false);
		server.setConnectors(new Connector[] { connector });

		WebAppContext webContext = new WebAppContext(webappPath, ctxPath);
		// webContext.setContextPath("/");
		webContext.setDescriptor(webappPath + "/WEB-INF/web.xml");
		// 设置webapp的位置
		webContext.setResourceBase(webappPath);
		webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
		server.setHandler(webContext);
		return server;
	}

	/**
	 * 启动jetty服务
	 */
	public void startJetty(int port,String webappPath, String ctxPath) {
		final Server server = Launcher.createServerInSource(port,webappPath, ctxPath);
		try {
			server.stop();
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		new Launcher().startJetty(PORT,DEFAULT_WEBAPP_PATH,CONTEXT_PATH);
	}
}