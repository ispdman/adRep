<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="depth2" name="depth2" value="<c:out value="${param.depth2}"/>"/><!--레프트메뉴에서 해당 메뉴 활성화를 위한 파라미터(depth2)-->
<input type="hidden" id="chartNm" name="chartNm">