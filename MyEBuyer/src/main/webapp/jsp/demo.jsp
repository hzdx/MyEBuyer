<page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>SpringMVC-Demo</title>
<h2>hello,this is demo jsp</h2>
${msg}
<c:forEach items="${list }" var="li">
	${li }hahaha______________________
</c:forEach>