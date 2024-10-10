<%@page import="com.glassis5.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호, 제목, 작성자<hr>
<%
//게시글 목록 가져오기
ArrayList<Dto> posts = (ArrayList<Dto>)request.getAttribute("posts");
// 게시글 목록을 반복해서 출력
for(int i=0; i<posts.size(); i++){
%>
<%=posts.get(i).no %><!-- 게시글 번호 -->
<!-- 게시글 제목 링크 -->
<a href="/board/read?no=<%=posts.get(i).no %>"><%=posts.get(i).title %></a>
<!-- 작성자 아이디 -->
<%=posts.get(i).id %>
<%
	
}
%>
<!-- 글쓰기 및 이동 링크 -->
<a href = "/write.jsp">쓰기</a>
<!-- 글쓰기 페이지로 이동 -->
<a href = "/board/list">리스트로</a>
<!-- 홈으로 이동 -->
<a href = "/">홈으로</a>
</body>
</html>