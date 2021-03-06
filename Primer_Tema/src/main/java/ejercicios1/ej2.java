package ejercicios1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ej2
 */
@WebServlet("/ej2")
public class ej2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int cont = 0;
	private int rand;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ej2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(ServletConfig config) throws ServletException {

		rand = 1 + (int)(Math.random() * 20);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aux = request.getParameter("valor");
		Integer valor = -99;
		if(aux != null) {
			valor = Integer.parseInt(aux);
		}
		
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(aux == null) {
        	out.println("<form>Dime un numero <input type='text' name='valor'>");
        	out.println("<input type=\"submit\" value='Jugar' name='jugar'></form>");
        	return;
        }
        
        if (valor == rand) {
        	out.println("<h1>Has Acertado en " + cont + " intenteos.</h1>");
        	cont = 0;
        	response.setHeader("Refresh", "3; URL=ej2");
        	return;
		}
        
        if(valor != rand) {
        	cont++;
        	if(cont == 5) {
        		out.println("<h1>Has fallado!");
        		cont = 0;
        		response.setHeader("Refresh", "3; URL=ej2");
        		return;
        	}else {
        		if(valor > rand) {
        			out.println("Te has pasado.<br>");
        		}else {
        			out.println("Te has quedado corto.<br>");
        		}
        		out.println("Llevas " + cont + " intentos.<br>");
        		out.println("<form>Dime un numero <input type='text' name='valor'>");
        		out.println("<input type=\"submit\" value='Jugar'></form>");
        	}
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
