package com.teachmeskills.lesson24.hw.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkAge")
public class AgeAssertion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryParam = req.getParameter("age");

        if (queryParam == null || queryParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Query is empty.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(queryParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, String.format("Unexpected param value: ", queryParam));
            return;
        }

        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        boolean isAdult = age >= 18;
        if (isAdult) {
            pw.write("User is adult.");
        } else {
            pw.write("User is too young.");
        }
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String body = sb.toString();

        if (body == null || body.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Body is empty.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(body);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unexpected body: " + body);
            return;
        }

        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        boolean isAdult = age >= 18;
        if (isAdult) {
            pw.write("User is adult.");
        } else {
            pw.write("User is too young.");
        }
        pw.close();
    }
}
