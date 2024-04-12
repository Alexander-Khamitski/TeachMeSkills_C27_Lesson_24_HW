package com.teachmeskills.lesson24.hw.task1.task1_pathParameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teachmeskills.lesson24.hw.task1.consts.ICity;
import com.teachmeskills.lesson24.hw.task1.consts.ITimeZone;
import com.teachmeskills.lesson24.hw.task1.util.DateTimeUtil;

@WebServlet(urlPatterns="/time/*")
public class PathParamDateTime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathParam = req.getRequestURI().substring("TeachMeSkills_C27_Lesson_24_HW/time/".length());
        switch (pathParam) {
            case "/minsk":
                DateTimeUtil.printDateTime(resp, ITimeZone.MINSK_TIMEZONE_ID, ICity.MINSK);
                break;
            case "/beijing":
                DateTimeUtil.printDateTime(resp, ITimeZone.BEIJING_TIMEZONE_ID, ICity.BEIJING);
                break;
            case "/washington":
                DateTimeUtil.printDateTime(resp, ITimeZone.WASHINGTON_TIMEZONE_ID, ICity.WASHINGTON);
                break;
            default:
                PrintWriter pw = resp.getWriter();
                pw.write(String.format(ICity.UNEXPECTED_CITY_MESSAGE,
                                       pathParam,
                                       ICity.MINSK.toLowerCase(),
                                       ICity.BEIJING.toLowerCase(),
                                       ICity.WASHINGTON.toLowerCase()
                ));
                pw.close();
        }
    }
}
