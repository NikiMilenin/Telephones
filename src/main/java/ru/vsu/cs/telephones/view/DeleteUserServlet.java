package ru.vsu.cs.telephones.view;
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

@WebServlet("/delete_user")
public class DeleteUserServlet extends HttpServlet {
    private Telephones service = new Telephones();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String phone = request.getParameter("phone");
        try {
            service.deleteSubscriber(phone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Subscriber> subs;
        try {
            subs = service.getAllSubscribers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/show_subscribers");
    }
}
