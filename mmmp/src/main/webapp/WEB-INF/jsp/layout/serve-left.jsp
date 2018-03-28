<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- left menu -->
			<div class="left_menu">
				<ul class="depth1">
					<li id="depth1_li">
						<a >대메뉴</a>
						<ul class="depth2">
							<li id="li01"><a href="<c:url value='/overViewList.do?depth2=li01'/>">depth1</a></li>
							<li id="li02"><a href="<c:url value='/serviceList.do?depth2=li02'/>">depth2</a></li>
							<li id="li03"><a href="#">depth3</a></li>
							<li id="li04"><a href="#">depth4</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- //left menu -->