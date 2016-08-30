package session_resubmit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTokenServlet extends HttpServlet {
    private static final long serialVersionUID = -884689940866074733L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = TokenProccessor.getInstance().makeToken(); //��������
        System.out.println("��FormServlet�����ɵ�token��"+token);
        request.getSession().setAttribute("token", token); //�ڷ�����ʹ��session����token(����)
        request.getRequestDispatcher("/form.jsp").forward(request, response); //��ת��form.jspҳ��
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}