package ru.vsu.cs.telephones.view;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ru.vsu.cs.telephones.data.Subscriber;
import ru.vsu.cs.telephones.service.Telephones;


@WebServlet("/show_subscribers")
public class MainServlet extends HttpServlet {
    private Telephones service = new Telephones();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Subscriber> sub;
        try {
            sub = service.getAllSubscribers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("subscribers", sub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("show_subscribers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String[] phones = {phone1, phone2, phone3};
        Subscriber sub = new Subscriber(name, surname, phones);
        try {
            service.addSubscriber(sub);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Subscriber> subs;
        try {
            subs = service.getAllSubscribers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("subscribers", subs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("show_subscribers.jsp");
        dispatcher.forward(request, response);
    }


    public void destroy() {
    }
}