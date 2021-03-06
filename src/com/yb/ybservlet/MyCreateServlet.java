package com.yb.ybservlet;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.sql.ActivitySql;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyCreateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   Date myDat =new Date();
		   String nowtime=format.format(myDat);
		
		  // ActivitySql ab = new ActivitySql();
		 
		    ActivitySql as=new ActivitySql();
		
			//Activity activity =new Activity();
		    if( request.getSession().getAttribute("userkey")!=null)
		    {
		    Integer uid=(Integer)request.getSession().getAttribute("userkey");
			List<Activity> myCreateActivity= as.queryMyCreateActivity(uid);
			request.setAttribute("myCreateActivity", myCreateActivity);
		    }
			request.setAttribute("nowtime", nowtime);
			
			
			request.getRequestDispatcher("mycreate.jsp").forward(request, response);
		
	 
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
