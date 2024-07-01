package com.newlecture.controller.exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exam/list")
public class List extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;UTF-8");
		PrintWriter out = res.getWriter();
		
		int page = 1;
		String name;
		int kor, eng, math;
		int total;
		double avg;
		String grade = "F";

		FileInputStream fis = new FileInputStream("C:/res/data.csv");
		Scanner scan = new Scanner(fis);
		
		scan.nextLine();
		
		out.printf("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
					<head>
						<div>1 page</div>
						<h1>성적출력</h1>
					</head>
					<table>
						<tr>
							<th>이름</th>
							<th>국어</th>
							<th>영어</th>
							<th>수학</th>
							<th>총점</th>
							<th>평균</th>
							<th>성적</th>
						</tr>
							""");		
		
		for (int i = 0; scan.hasNextLine() && i < 6; i++) {
			
			// -----------------------------
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			// System.out.printf("tokens:", Arrays.toString(tokens));

			name = tokens[0];
			// 문자열 토큰 값을 숫자로 변경
			if (isNumeric(tokens[1]))
				kor = Integer.parseInt(tokens[1]);
			else
				kor = 0;

			// 유효성 검사
			if (!(0 <= kor && kor <= 100))
				kor = 0;

			// ----------------------------------

			// kor 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[2]))
				eng = 0;
			else
				eng = Integer.parseInt(tokens[2]);

			// kor 값의 유효성 검사
			if (!(0 <= eng && eng <= 100))
				eng = 0;

			// eng 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[3]))
				math = 0;
			else
				math = Integer.parseInt(tokens[3]);

			// eng 값의 유효성 검사
			if (!(0 <= math && math <= 100))
				math = 0;

			// 성적 계산
			total = kor + eng + math;
			avg = total / 3.0;

			grade = "F";

			if (90 <= avg)
				grade = "A";
			else if (80 <= avg)
				grade = "B";
			else if (70 <= avg)
				grade = "C";
			else if (60 <= avg)
				grade = "D";
			else if (50 <= avg)
				grade = "E";

			out.printf("""
					<tr>
						<th>%s</th>
						<th>%d</th>
						<th>%d</th>
						<th>%d</th>
						<th>%d</th>
						<th>%.2f</th>
						<th>%s</th>
					</tr>


						""", name, kor, eng, math, total, avg, grade);
		}

		out.printf("""
							</tbody>
							</table>
						</body>
						</html>

				""");

		scan.close();
		fis.close();

	}

	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
}