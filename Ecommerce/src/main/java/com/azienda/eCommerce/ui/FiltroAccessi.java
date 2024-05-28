package com.azienda.eCommerce.ui;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class FiltroAccessi implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try {
			HttpServletRequest richiesta = (HttpServletRequest) arg0;
			String log = (String)richiesta.getSession().getAttribute("Loggato");

			if(log.equals("SI")) {
				arg2.doFilter(arg0, arg1);
			}else {
				arg0.getRequestDispatcher("/JSP/pubblica/Login.jsp").forward(arg0, arg1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			arg0.getRequestDispatcher("/JSP/pubblica/Login.jsp").forward(arg0, arg1);
		}

	}

}
