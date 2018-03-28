<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<script type="text/javascript">
$(document).ready(function(){
	selectTestData1(1);
	selectTestData1(2);
	selectTestData1(3);
	selectTestData1(4);	
});
function makeChart1(data){
 	var charNm=data.chartNm;
 	 data = JSON.stringify(data);
	//pie 차트 
    var seriesListPie = JSON.parse(data).pDataList;
   	 Highcharts.chart(charNm, {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Browser market shares January, 2015 to May, 2015'
	    },
	    tooltip: {
	        pointFormat: '{point.y}, <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: false
	            },
	            showInLegend: true
	        }
	    },
	    series: [{
	        name: 'Brands',
	        colorByPoint: true,
	        	data        : seriesListPie
	    }]
	}); 
}

function makeChart2(data){
	var charNm=data.chartNm;
	data = JSON.stringify(data);
	//line 차트 
    var categoriesList = JSON.parse(data).monthList;
    var lDataList1     = JSON.parse(data).lDataList1;
    var lDataList2     = JSON.parse(data).lDataList2;
    
    
     chart1 = new Highcharts.Chart({
        chart : {
            renderTo     : charNm,
            type: 'spline',
            zoomType     : 'x'
        },
        title : {
            text    : 'Line 차트'
        },
        
        xAxis: {
            gridLineWidth: 1,
            labels: {
                align: 'left',
                x: 3,
                y: 10
            }
        },
        
        yAxis: [{ // left y axis
            title: {
                text: null
            },
            labels: {
                align: 'left',
                x: 3,
                y: 16,
//                 format: '{value}'
				formatter : function () {
					return this.value+' °C'
				}
            },
            showFirstLabel: false
        }, { // right y axis
            linkedTo: 0,
            gridLineWidth: 0,
            opposite: true,
            title: {
                text: null
            },
            labels: {
                align: 'right',
                x: -3,
                y: 16,
              //                 format: '{value}'
				formatter : function () {
					return this.value+' mm'
				}

            },
            showFirstLabel: false
        }],
        tooltip: {
            shared: true
        },
//         tooltip: {
//             valueSuffix: '°C'
//         },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        
        series: []
    });
    chart1.xAxis[0].setCategories(categoriesList);

    chart1.addSeries({
    	   	name : "기온",
            data : lDataList1,
            tooltip : {valueSuffix: ' °C'}

            
    });
   
    chart1.addSeries({
	   	name : "강수량",
        data : lDataList2,
        tooltip : {valueSuffix: ' mm'}

        
}); 

}
function selectTestData1(no){
   var url = '<c:url value="/overViewChartOne.do" />';
   $("#chartNm").val(no);
    ajaxSubmit(url,true, makeChart1,no);
}
function selectTestData2(no){
    var url = '<c:url value="/overViewChartTwo.do" />';
    ajaxSubmit(url,true, makeChart2, no);
}
function fnGraphSel(no){
	if(no==1){
		$("#dv2").hide();
		$("#dv1").show();
		selectTestData1(1);
		selectTestData1(2);
		selectTestData1(3);
		selectTestData1(4);
	}else if(no==2){
		$("#dv1").hide();
		$("#dv2").show();
		selectTestData2(5);
		selectTestData2(6);
		selectTestData2(7);
		selectTestData2(8);
	}
}


</script>
<jsp:include page="../cmmn/comParam.jsp" flush="false" /><!-- 공통파라미터 -->
	<form name="process" id="process" method="post" >
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
								<th scope="row"><label for="insttNm">그래프</label></th>
								<td>
										<input type="radio" id="graph1" name="graph1" value="1"/> 비율
										<input type="radio" id="graph1" name="graph1" value="2"/> 추세
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="insttNm">기준시간</label></th>
								<td>
										<input id="datetimepicker" type="text" class="w140" name="datetimepicker"/>
										<script type="text/javascript">
										$(function () {
										    $("#datetimepicker").datetimepicker(
										    	{
										    		showSecond: true,
										    		  dateFormat: 'yy-mm-dd',
										    		  timeFormat: 'hh:mm:ss'
										    	}		
										    );
										  });
										</script>					
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="insttNm">시간간격</label></th>
								<td>
										<select class="w140" id="timePart" name="timePart">
										<option value='5' >5분</option>
										<option value='10' >10분</option>
										<option value='15' >15분</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="text-right">
					<button class="btn btn-sm" type="button" onclick="fnResult();return false;">조회</button>
				</div> <!-- //search -->
	
				<!-- 로딩div -->
			    <div id="loadData" style="width:100%; height:0%; margin-top:0px; border:0px;"></div>
			    <!-- 로딩 이미지 -->
				<div id="viewLoading" style="left:500px;display:none;">
					<img src="<c:url value='/img/ajax-loader.gif'/>" alt="로딩이미지"/>
				</div>	
				
				<div class="page_total">
					<div class="left"> 
							<button class="btn btn-gray" type="button" onclick="javascript:fnGraphSel(1);">비율</button>
								<button class="btn btn-gray" type="button" onclick="javascript:fnGraphSel(2);">추세</button>
					</div> 
					<label for="pageUnit">　</label>
				</div>
				<!-- content -->
				<div class="table_container">
				
				<!-- 비율그래프 시작 -->
				<div id="dv1">
						<div class="main_form03" >
							<div class="border" style="height:330px;">
									<div id="dvChart1" style="height:310px;margin-top: 20px;"></div>
							</div>
							<div class="border" style="height:330px;">
									<div id="dvChart2" style="height:310px;margin-top: 20px;"></div>
							</div>
						</div>
						
						<div class="main_form03" >
							<div class="border" style="height:330px;">
									<div id="dvChart3" style="height:310px;margin-top: 20px;"></div>
							</div>
							<div class="border" style="height:330px;">
									<div id="dvChart4" style="height:310px;margin-top: 20px;"></div>
							</div>
						</div>
				</div>
				<!-- 비율그래프 끝 -->
				
				<!-- 추세그래프 시작 -->
				<div id="dv2" style="display:none">
					<div class="main_form03">
						<div class="border" style="height:330px;">
								<div id="dvChart5" style="height:310px;margin-top: 20px;"></div>
						</div>		
						<div class="border" style="height:330px;">
								<div id="dvChart6" style="height:310px;margin-top: 20px;"></div>
						</div>			
					</div>
					<div class="main_form03">
						<div class="border" style="height:330px;">
								<div id="dvChart7" style="height:310px;margin-top: 20px;"></div>
						</div>		
						<div class="border" style="height:330px;">
								<div id="dvChart8" style="height:310px;margin-top: 20px;"></div>
						</div>			
					</div>
				</div>
				<!-- 추세그래프 끝 -->
				</div>
				<!-- content -->
			</div>
			</form>
