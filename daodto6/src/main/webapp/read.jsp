<%@page import="com.glassis5.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 서버에서 전달된 게시글 객체를 받아서 dto타입으로 변환
Dto d = (Dto)request.getAttribute("post");
%>
<!-- 게시글 정보출력 -->
<!-- 글 번호출력 -->
<%=d.no %>
<!-- 작성자 아이디 출력 -->
<%=d.id%>
<!-- 글제목 출력 -->
<%=d.title %>
<hr>
<!-- 글 본문 출력 -->
<%=d.text %>
<a href = "/board/del?no=<%=d.no %>">삭제</a>
<a href = "/board/edit_insert?no=<%=d.no %>">수정</a>
<a href = "/list.jsp">리스트로</a>
</body>
</html>