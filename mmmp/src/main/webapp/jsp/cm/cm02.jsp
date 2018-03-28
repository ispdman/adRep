<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

<script language="javascript" type="text/javascript">
//저장버튼
function fnSave(){
		 var compare = confirm("저장 하시겠습니까?");
		 if(compare == true){
			  document.process.action = "<c:url value='/cmRegist.do'/>";
			 document.process.submit(); 
			
			/*  $.ajax({
					url:"<c:url value='/cmRegist.do'/>",
					type  	: "post",
					dataType: 'json',
					data	: $("#process").serialize(),
					async:false,
					success:function(data){ 
						alert("저장 되었습니다."+data.successYn);
						fnMove();
					},
					error: function(xhr, status, error) {
						alert(error+",status="+status);
					}
				}); */
		 } 
}

function fnMove(){
	document.process.action = "<c:url value='/cmList.do'/>";
 	document.process.submit();
}
</script>
	<!-- Popup Page -->
	<div id="pop_wrap">
		<!-- pop_container -->
		<div class="pop_container">
			<h1>등록</h1>

			<!-- content -->
			<div class="content">
			<form name="process" id="process" method="post" enctype="multipart/form-data">
				<!--layer popup regist-->
				<div class="z99">
					<div class="popup_content">

						<!-- table -->
						<div class="table_content">
							<table summary="이 표는 기관명, 시스템명, 데이터(한글)명, 데이터명, 자료형태, 공간시각화 대상여부, 구분으로 구성되어 있습니다.">
								<caption>등록</caption>
								<colgroup>
									<col width="150px" />
									<col width="auto" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><label for="sysId">제목</label></th>
										<td><input type="text" id="title" name="title" class="w200"/>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="rprsntLayerId">내용</label></th>
										<td><input type="text" id="description" name="description" class="w200"/></td>
									</tr>
									<tr>
										<th scope="row"><label for="layNm">작성자</label></th>
										<td>
											<input type="text" id="id" name="id" class="w200"/>
										</td>
									</tr>
									<tr>
										<th scope="row">파일첨부</th>
										<td>
											      <input class="w300" type="file" name="file1" id="file1" />
											      <input class="w300" type="file" name="file2" id="file2"/>
										</td>
									</tr>
								</tbody>
							</table>
						</div><!-- //table --> 
						<div class="text-right">
							<button class="btn btn-sm" type="button" onclick="fnSave()">저장</button>							
							<button class="btn btn-blue" id="close" type="button" onclick="fnMove()">닫기</button>							
						</div>
					</div>
				</div>
		</form>
			<!-- //popup -->

			</div><!-- //content -->

		</div><!-- //pop_container -->

	</div><!-- //Popup Page -->
