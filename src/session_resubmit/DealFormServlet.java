package session_resubmit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DealFormServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            boolean b = isRepeatSubmit(request);//�ж��û��Ƿ����ظ��ύ
            if(b==true){
                System.out.println("�벻Ҫ�ظ��ύ");
                return;
            }
            request.getSession().removeAttribute("token");//�Ƴ�session�е�token
            System.out.println("�����û��ύ���󣡣�");
    }
        
	/**
	 * �жϿͻ����ύ���������ƺͷ����������ɵ������Ƿ�һ��
	 * @param request
	 * @return 
	 *         true �û��ظ��ύ�˱� 
	 *         false �û�û���ظ��ύ��
	 */
	private boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		//1������û��ύ�ı�������û��token�����û����ظ��ύ�˱�
		if(client_token==null){
			return true;
		}
		
		String server_token = (String) request.getSession().getAttribute("token");
		//2�������ǰ�û���Session�в�����Token(����)�����û����ظ��ύ�˱�
		if(server_token==null){
			return true;
		}
		
		//3���洢��Session�е�Token(����)����ύ��Token(����)��ͬ�����û����ظ��ύ�˱�
		if(!client_token.equals(server_token)){
			return true;
		}
		
		return false;
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}