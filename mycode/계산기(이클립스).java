import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/calc")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int result = 0;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; UTF-8");
        
        PrintWriter out = response.getWriter();
        String view = """
        		<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<h1>계산기 폼</h1>
		<form method="post">
			<fieldset>
				<div>
					<label>숫자1</label>
					<input name="num1">
				</div>
				<div>
					<label>숫자2</label>
					<input name="num2">
				</div>
			</fieldset>
			<div>
				<button>계산하기</button>
			</div>
			<div>
				계산결과 : %d				
			</div>
		</form>
	</section>
</body>
</html>
        		""";
        
        out.printf(view, result);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = 0;
		
//        if(request.getParameter("num1")!=null && request.getParameter("num2")!=null)
		if(request.getMethod().equals("POST"))
		{
			
			int num1 = 0;
			int num2 = 0;
			
			String num1_ = request.getParameter("num1");
			num1 = Integer.parseInt(num1_);
			
			String num2_ = request.getParameter("num2");
			num2 = Integer.parseInt(num2_);
			
			result = num1 + num2;
	}
	
//	public void service(HttpServletRequest request,
//                        HttpServletResponse response)
//                        throws IOException, ServletException {
//        System.out.println("hello Servlet");

        
//        }
        
    }
}