package com.siapa.jasper.servlet;

import com.siapa.config.SpringApplicationContextServiceProvider;
import com.siapa.jasper.service.ReportingService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReportingServiceServlet", urlPatterns = {"/report"})
public class ReportingServiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String reportName = request.getParameter("reportName");
        request.setAttribute("reportName", reportName);
        ReportingService reportingService = (ReportingService) SpringApplicationContextServiceProvider.getBean("reportingService");
        reportingService.executeReport(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
