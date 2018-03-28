<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title><tiles:getAsString name="title"/></title>
  <meta name="robots" content="all" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="keywords" content="한국전자통신연구원, MMMP" />
<meta name="description" content="한국전자통신연구원, MMMP 홈페이지입니다." />
<meta name="author" content="한국전자통신연구원," />
<link href="<c:url value='/js/timepicker/jquery-ui.css'/>" rel="stylesheet" type="text/css"/> <!-- 달력 css-->
 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/common.css'/>" /><!-- 공통 css-->

<script type="text/javascript" src="<c:url value='/js/jquery-1.8.0.min.js'/>"></script><!-- 제이쿼리 -->

<script type="text/javascript" src="<c:url value='/js/highcharts/highcharts.js'/>"></script><!-- 하이차트 그래프 -->
<script  type="text/javascript" src="<c:url value='/js/highcharts/exporting.js'/>"></script><!-- 하이차트 그래프 -->


<script src="<c:url value='/js/timepicker/jquery-ui.min.js'/>" type="text/javascript" ></script><!-- 달력 -->
<script src="<c:url value='/js/timepicker/jquery-ui-timepicker-addon.js'/>" type="text/javascript" ></script><!-- 달력 -->

<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script> <!-- 공통 스크립트 -->
</head>
 <body>
<tiles:insertAttribute name="header" />
<!--CONTAINER-->
<div id="wrap">
<div id="page">
	<tiles:insertAttribute name="left" />
	<tiles:insertAttribute name="contents" />
</div>
</div>
<tiles:insertAttribute name="footer" />
</body>
</html>
