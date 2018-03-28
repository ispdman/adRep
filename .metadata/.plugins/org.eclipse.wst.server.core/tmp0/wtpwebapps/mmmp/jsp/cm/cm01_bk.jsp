<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
 <head>
 <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>cm</title>
<meta name="robots" content="all" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="keywords" content="국토교통부, 국가공간정보통합체계" />
<meta name="description" content="국토교통부 국가공간정보통합체계 홈페이지입니다." />
<meta name="author" content="국토교통부" />
 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/common.css'/>" />
  <script type="text/javascript" src="<c:url value='/js/jquery-3.2.1.min.js'/>"></script> 
  <script type="text/javaScript" language="javascript" >
	  function fn_regist() {
	     	document.process.action = "<c:url value='/selectCmRegist.do'/>";
	     	document.process.submit();
	  }
	  
	  function fnDetailView(boardNo){
		  $("#boardNo").val(boardNo);
		  document.process.action = "<c:url value='/cmDetailList.do'/>";
	      document.process.submit();
	  }
	  /* pagination 페이지 링크 function */
      function fn_egov_link_page(pageNo){
      	document.process.pageIndex.value = pageNo;
      	document.process.action = "<c:url value='/cmList.do'/>";
         	document.process.submit();
      }
  </script>
</head>

<body>
	<form name="process" id="process" method="post" action="">
	<input type="hidden" id="boardNo" name="boardNo">
	<input type="hidden" name="pageIndex" id="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/><!--page index  -->
	<!-- //content -->
			<div class="content">

				<div class="sub_header">

					<!-- location -->
					<ol class="location">
						<li>sp</li>
						<li>리스트</li>
					</ol><!-- //location -->

					<h3>sp</h3>

				</div><!-- //sub_header -->

				<!-- search -->
				<div class="table_content">
					<table summary="이 표는 기관명, 시스템명, 작동상태로 구성되어 있습니다.">
						<caption>검색 조회</caption>
						<colgroup>
							<col width="140px" />
							<col width="auto" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row"><label for="insttNm">제목</label></th>
								<td><input class="w130" type="text" id="insttNm" name="insttNm" onkeydown="javascript:moveFocus();" value=""/></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="text-right">
					<button class="btn btn-sm" type="button" onclick="fnResult();return false;">조회</button>
				</div> <!-- //search -->
				<div class="page_total">
					<div class="left"> 총 <span class="red"><c:out value="${paginationInfo.totalRecordCount}"/></span> 건 <span class="small">
						</span></div> 
					<label for="pageUnit">　</label>
				</div>
	
				<!-- 로딩div -->
			    <div id="loadData" style="width:100%; height:0%; margin-top:0px; border:0px;"></div>
			    <!-- 로딩 이미지 -->
				<div id="viewLoading" style="left:500px;display:none;">
					<img src="<c:url value='/img/ajax-loader.gif'/>" alt="로딩이미지"/>
				</div>	
				<!-- table -->
				<div class="table_container">
					<table summary="이 표는 번호,제목,작성일,작성자로 구성되어 있습니다.">
						<caption>sp</caption>
						<colgroup>
							<col width="230px" />
							<col width="250px" />
							<col width="70px" />
							<col width="70px" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col" ><a id="INSTT_NM" class="">번호</a></th>
								<th scope="col" ><a id="SYS_NM" class="" >제목</a></th>
								<th scope="col">작성자</th>
							</tr>
						</thead>
							<tbody>
									<c:forEach var="result" items="${resultList}" varStatus="status">
				            			<tr>
				            				<td><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}"/></td>
				            				<td><a onclick="fnDetailView('<c:out value="${result.boardNo}"/>')"><c:out value="${result.title}"/></a></td>
				            				<td><c:out value="${result.id}"/></td>
				            			</tr>
				        			</c:forEach>
							</tbody>
					</table>
				</div>
				<!-- //table -->

				<div class="text-right">
					<button type="button" class="btn btn-sm" onclick="javascript:fn_regist();">등록</button>
				</div>

	            <!-- paging -->
	            <div class="pagination_container">
				    <ul class="paging">
				    	<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_link_page"/>
				    </ul>
				</div>
	            <!-- //paging -->

			</div><!-- //content -->
			</form>
</body>
</html>