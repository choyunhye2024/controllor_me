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
Dto dto = (Dto)request.getAttribute("post");
%>
<!-- 게시글 수정 폼 -->
<form action = "/board/edit_proc" mathod = "get"><!-- get요청을 통해 수정처리 -->
<input type = "hidden" name = "no" value="<%=dto.no %>"><!-- 게시글번호(수정중엔 숨김) -->
<label>제목: <input name = "title" value="<%=dto.title%>"></label><br><!-- 제목입력필드 -->
<label>내용: <textarea name = "text"><%=dto.text %></textarea></label><br><!-- 내용입력필드 -->
<input type = "submit" value = "수정"><!-- 수정버튼 -->
</form>
<a href = "list.jsp">리스트로</a>
</body>
</html>