<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html"
	prefix="html"%>

<jsp:include flush="true" page="../header.jsp" />

		<c:forEach var="board" items="${ boardList }">
			${ board.category.name }: ${ board.name }, ${ board.description } <a href="<html:rewrite action="/thread" />?board.id=${ board.id }">Publish</a> <BR />
		</c:forEach>
		