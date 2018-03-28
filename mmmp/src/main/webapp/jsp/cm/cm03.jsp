<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<script language="javascript" type="text/javascript">
//저장버튼
function fnSave(){
		 var compare = confirm("저장 하시겠습니까?");
		 if(compare == true){
			 $.ajax({
					url:"<c:url value='/cmModi.do'/>",
					type  	: "post",
					dataType: 'json',
					data	: $("#process").serialize(),
					async:false,
					success:function(data){ 
						alert("저장 되었습니다."+data.successYn);
						//window.opener.fnReload(schLnkDate);
	                	//window.close();
					},
					error: function(xhr, status, error) {
						alert(error+",status="+status);
					}
				});
		 } 
}

function fnDelete(){
	$("#fileSn").val("");
	 var compare = confirm("삭제 하시겠습니까?");
	 if(compare == true){
		 $.ajax({
				url:"<c:url value='/cmDel.do'/>",
				type  	: "post",
				dataType: 'json',
				data	: $("#process").serialize(),
				async:false,
				success:function(data){ 
					alert("삭제 되었습니다."+data.successYn);
					fnMove();
					//window.opener.fnReload(schLnkDate);
               	//window.close();
				},
				error: function(xhr, status, error) {
					alert(error+",status="+status);
				}
			});
	 } 
}

function fnMove(){
	document.process.action = "<c:url value='/cmList.do'/>";
 	document.process.submit();
}

function fnDownload(sf,of){
	$("#storedFileName").val(sf);
	$("#originalFileName").val(of);
	document.process.action = "<c:url value='/fileDownload.do'/>";
 	document.process.submit();
}

function fnFileDel(sf,fs){
	$("#storedFileName").val(sf);
	$("#fileSn").val(fs);
	document.process.action = "<c:url value='/fileDel.do'/>";
 	document.process.submit();
}
</script>
	<!-- Popup Page -->
	<div id="pop_wrap">
		<!-- pop_container -->
		<div class="pop_container">
			<h1>상세</h1>

			<!-- content -->
			<div class="content">
			<form name="process" id="process" method="post" action="">
			<input type="hidden" id="storedFileName" name="storedFileName" />
			<input type="hidden" id="originalFileName" name="originalFileName" />
			 <input type="hidden" id="fileSn" name="fileSn" /> 
				<!--layer popup regist-->
				<div class="z99">
					<div class="popup_content">

						<!-- table -->
						<div class="table_content">
							<table summary="이 표는 기관명, 시스템명, 데이터(한글)명, 데이터명, 자료형태, 공간시각화 대상여부, 구분으로 구성되어 있습니다.">
								<caption>상세페이지</caption>
								<colgroup>
									<col width="150px" />
									<col width="auto" />
								</colgroup>
								<tbody>
								<c:forEach var="result" items="${resultList}" varStatus="status">
								<input type="hidden" id="boardNo" name="boardNo" value="<c:out value="${result.boardNo}"/>"/>
									<tr>
										<th scope="row"><label for="title">제목</label></th>
										<td>
											<input type="text" id="title" name="title" class="w200" value="<c:out value="${result.title}"/>"/>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="rprsntLayerId">내용</label></th>
										<td><input type="text" id="description" name="description" class="w200" value="<c:out value="${result.description}"/>"/></td>
									</tr>
									<tr>
										<th scope="row"><label for="layNm">작성자</label></th>
										<td>
											<input type="text" id="id" name="id" class="w200" value="<c:out value="${result.id}"/>" disabled/>
										</td>
									</tr>
								</c:forEach>
								<tr>
										<th scope="row"><label for="layNm">파일</label></th>
										<td>
										<c:if test="${fn:length(resultList2) eq 0 }">
											<input type="file" name="file1" />
											<input type="file" name="file2" />
										</c:if>
										<c:if test="${fn:length(resultList2) eq 1 }">
											<c:forEach var="result" items="${resultList2}" varStatus="status">
												<a href="#" onclick="fnDownload('<c:out value="${result.storedFileName}"/>','<c:out value="${result.originalFileName}"/>')"><c:out value="${result.originalFileName}"/></a>&nbsp;&nbsp;
												<a href="#" onclick="fnFileDel('<c:out value="${result.storedFileName}"/>','<c:out value="${result.fileSn}"/>')"><font color="red" size="1">삭제</font></a>
											</c:forEach>	
											<input type="file" name="file1" />
										</c:if>
										<c:if test="${fn:length(resultList2) eq 2 }">
										
											<c:forEach var="result" items="${resultList2}" varStatus="status">
												<a href="#" onclick="fnDownload('<c:out value="${result.storedFileName}"/>','<c:out value="${result.originalFileName}"/>')"><c:out value="${result.originalFileName}"/></a>&nbsp;&nbsp;
												<a href="#" onclick="fnFileDel('<c:out value="${result.storedFileName}"/>','<c:out value="${result.fileSn}"/>')"><font color="red" size="1">삭제</font></a>
											</c:forEach>	
									</c:if>
										</td>
									</tr>
								
								</tbody>
							</table>
						</div><!-- //table --> 
						<div class="text-right">
							<button class="btn btn-sm" type="button" onclick="fnDelete()">삭제</button>
							<button class="btn btn-sm" type="button" onclick="fnSave()">수정</button>							
							<button class="btn btn-blue" id="close" type="button" onclick="fnMove()">닫기</button>							
						</div>
					</div>
				</div>
		</form>
			<!-- //popup -->

			</div><!-- //content -->

		</div><!-- //pop_container -->

	</div><!-- //Popup Page -->
