package com.teachmeskills.lesson24.hw.task1.task1_annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teachmeskills.lesson24.hw.task1.consts.ICity;
import com.teachmeskills.lesson24.hw.task1.consts.ITimeZone;
import com.teachmeskills.lesson24.hw.task1.util.DateTimeUtil;

@WebServlet("/annotation/beijing")
public class BeijingDateTime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeUtil.printDateTime(resp, ITimeZone.BEIJING_TIMEZONE_ID, ICity.BEIJING);
    }
}
