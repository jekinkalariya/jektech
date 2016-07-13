package com.ecw.push;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		System.out.println("GEt call");
		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		AsyncContext actx = request.startAsync();
	    actx.setTimeout(30*1000);

		PrintWriter writer = actx.getResponse().getWriter();

		for (int i = 0; i < 20; i++) {
			writer.write("retry: 10000000000000000000000000000000000000000000000000000000000\n");
			writer.write("data: "+ System.currentTimeMillis() +"\n\n");
			writer.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		actx.complete();;
	}

}