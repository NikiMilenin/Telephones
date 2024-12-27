package ru.vsu.cs.telephones.view;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.vsu.cs.telephones.data.Subscriber;
import ru.vsu.cs.telephones.service.Telephones;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/update_subscriber")
public class UpdateUserServlet extends HttpServlet {
    private Telephones service = new Telephones();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String phone = request.getParameter("old_phone");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        service.changeName(name, phone);
        service.changeSurname(surname, phone);
        service.changePhone2(phone2, phone);
        service.changePhone3(phone3, phone);
        service.changePhone1(phone1, phone);
        response.sendRedirect(request.getContextPath() + "/show_subscribers");
    }

}
