/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.test.integration.security.context;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.as.test.integration.security.loginmodules.common.CounterLoginModule;

/**
 * Servlet which prints counter from CounterLoginModule. It can also reset this counter when reset parameter is set to true.
 *
 * @author olukas
 */
@WebServlet(urlPatterns = {CounterServlet.SERVLET_PATH})
public class CounterServlet extends HttpServlet {

    public static final String SERVLET_PATH = "/CounterServlet";

    public static final String RESET_PARAM = "reset";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        final PrintWriter writer = resp.getWriter();
        if (Boolean.parseBoolean(req.getParameter(RESET_PARAM))) {
            CounterLoginModule.resetCounter();
        }
        writer.write(Integer.toString(CounterLoginModule.getCounter()));
        writer.close();
    }
}
