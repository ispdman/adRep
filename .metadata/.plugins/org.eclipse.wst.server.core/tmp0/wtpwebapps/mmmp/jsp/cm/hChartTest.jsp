<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
 <%--  <script type="text/javascript" src="<c:url value='/js/jquery-latest.js'/>"></script> --%>
<!-- HighChart -->
<%-- <script type="text/javascript" src="<c:url value='/js/Highcharts-2.2.2/js/highcharts.src.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/Highcharts-2.2.2/js/modules/exporting.src.js'/>"></script> --%>
<script type="text/javascript" src="<c:url value='/js/jquery-1.8.0.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/highcharts/highcharts.js'/>"></script>
<script  type="text/javascript" src="<c:url value='/js/highcharts/exporting.js'/>"></script>

<script type="text/javascript">
//ajax 호출
function ajaxSubmit(url, async, callback) {
	jQuery.ajax({
		type	: 'post',
		async	: async,
		url		: url,
		//data	: $("#" + frmName).serialize(), 
		success	: function(data) {
			callback(data);
		},
		error: function(data, status, err) {
			alert('서버와의 통신 중 오류가 발생했습니다.\n잠시 후 다시 시도해주세요.');
		}
	});
}
	

function makeChart1(data){
	//차트의 색깔을 색깔을 지정 한다.
	Highcharts.setOptions({
	    colors: ['#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263']
	   });
var data1 = JSON.stringify(data);
//alert("data=>"+data+"\ndata1=>"+data1);
	//column 차트 
    var categoriesList = JSON.parse(data1).monthList;
    var seriesList     = JSON.parse(data1).resultList;
    
    
    chart1 = new Highcharts.Chart({
    	chart : {	
            renderTo     : 'chart1',	//차트를 그릴 div id
            type         : 'column',	//그릴 차트에 대한 종류 
        },
        title : {
            text    : '대제목'			   //차트 제목 
        },
        subtitle: {
            text: '소제목'
        },
        xAxis : {
            categories : []				//x 축의 표시될 내용 (ex: 1월, 2월, 3월...)
        },
        yAxis : {
            title : {
                 text : ''				//y축 제목
             }
        },
        plotOptions : {
            column: {
                dataLabels : {				//그래프에 데이터 표시 하기 위한 옵션 
                    enabled : true,			
                    style   : {
                        fontWeight: 'bold'
                    },
                    formatter: function() {
                        return this.y +'개';
                    }
                }
            }
        },
        legend: {
            enabled : true		//범례표시 여부
        },
        
        tooltip: {		//해당 그래프에 마우스Over시에 표시 하는 내용
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
//             formatter: function() {
//                 return ''+
//                 this.series.name +': '+ this.y +' 개';
//             },
        },
        series: []
    });
    
    chart1.xAxis[0].setCategories(categoriesList);
    for(var j = 0; j< seriesList.length;j++){

        chart1.addSeries({
            name : seriesList[j].name,
            data : seriesList[j].data
            
        });
    }
}

function makeChart2(data){
    
	Highcharts.setOptions({
	    colors: ['#000000', '#00FF00']
	   });

	var data1 = JSON.stringify(data);
	//alert("data=>"+data+"\ndata1=>"+data1);
	//column&Line 차트 
    var categoriesList = JSON.parse(data1).monthList;
    var seriesListColumn = JSON.parse(data1).cDataList;
    var seriesListLine = JSON.parse(data1).lDataList;
    
    
    chart2 = new Highcharts.Chart({
        chart : {
            renderTo    : 'chart1',
            zoomType 	: 'xy'				//차트의 줌을 하기 위한 옵션
        },
        title : {
            text    : 'column&Line 차트 '
        },
        xAxis : {
            categories : [],
        
        },
        yAxis: [{
        	labels : {
        		format : '{value}°C',
        		style  : {color : Highcharts.getOptions().colors[1]}
        	},
        	title  : {
        		text  : 'Temperature',
        		style : {color : Highcharts.getOptions().colors[1]}
        	}
        }, {
        	title  : {
        		text  : 'RainFall',
        		style : {color : Highcharts.getOptions().colors[0]}
        	},
        	labels : {
        		format : '{value}mm',
        		style  : {color : Highcharts.getOptions().colors[0]}
        	},
        	opposite : true
        }],
        
        tooltip : {shared : true},
        legend  : {
//범례 위치 조정
//             layout          : 'vertical',
//             align           : 'left',
//             x               : 120,
//             verticalAlign   : 'top',
//             y               : 100,
//             floating        : true,
            backgroundColor : (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },

        series : []
    });
    
    chart2.xAxis[0].setCategories(categoriesList);	//x축 카테고리 세팅

		//column 데이터 세팅
        chart2.addSeries({
            name    : 'RainFall',
            type    : 'column',
            yAxis   : 1, 
            data    : seriesListColumn,
            tooltip : {valueSuffix: ' mm'}
        });
        //line 데이터 세팅
        chart2.addSeries({
            name    : 'Temperature',
            type    : 'spline',
            data    : seriesListLine,
            tooltip : {valueSuffix: ' °C'}
        });
}

function makeChart3(data){
	var data1 = JSON.stringify(data);
	//alert("data=>"+data+"\ndata1=>"+data1);
	//pie 차트 
    var seriesListPie = JSON.parse(data1).pDataList;
    
    
    chart3 = new Highcharts.Chart({
        chart: {
            renderTo            : 'chart1',	//Div Id
            plotBackgroundColor : null,
            plotBorderWidth     : null,
            plotShadow          : false,
            type                : 'pie'		//Chart Type
        },
        title       : {
            text    : 'Pie 차트 '
        },
        tooltip     : {
            pointFormat: '{series.name}: <b>{point.percentage}%</b>'
        },
        legend: {
            enabled : true
        },
        plotOptions : {
            pie: {
                allowPointSelect: true,		//true 일경우 Pie 클릭시 클릭한 Pie 조각 분리 
                cursor          : 'pointer',
                dataLabels      : {
		              			      enabled        : true, 	// 표시 여부 
		                   			  color          : '#000000',
		                   			  connectorColor : '#000000',
		                        	  formatter      : function() {	// pie 조각 의 이름과 퍼센트(주석으로 되어있는것을 사용하면 값을 표시) 표시
// 								                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' ';
								                            return '<b>'+ this.point.name +'</b>: '+ this.point.y +' ';
								                       }
		               			   }
            }
        },
        series: []
    });

    
   	chart3.addSeries({
   		name        : "brand",			//마우스 올렸을때 뜨는 조그만 박스에 표시 됨
		data        : seriesListPie

   	});

        
}

function makeChart4(data){
    
	//donut 차트 
	
	/*
	HighCharts 2.2.2 에서는 startAngle 과 endAngle을 사용 할 수 없어서 semi circle donut 차트를
	만들 수 없다.
	
	HighCharts 4.6.2 에서는 startAngle 과 endAngle을 사용하여 만들 수 있다.
	*/
	var data1 = JSON.stringify(data);
	//alert("data=>"+data+"\ndata1=>"+data1);
    var seriesListPie = JSON.parse(data1).pDataList;
    chart4 = new Highcharts.Chart({
        chart: {
            renderTo            : 'chart1',	//Div Id
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title       : {
            text: 'ddfdfs',
            align: 'center',
            verticalAlign: 'middle',
            y: -10
        },
        tooltip     : {
        	 pointFormat: '{series.name}: <b>{point.y}개 시스템</b>'
        },
        plotOptions : {
            pie: {
            	dataLabels: {
                    enabled: true,
                    distance: -50,
                    style: {
                        fontWeight: 'bold',
                        color: 'white',
                        textShadow: '0px 1px 2px black'
                    },
				    formatter      : function() {	// pie 조각 의 이름과 퍼센트(주석으로 되어있는것을 사용하면 값을 표시) 표시
										          return '<b>'+ this.point.name +'</b>: '+ this.percentage +'%';
// 									          return '<b>'+ this.point.name +'</b>: '+ this.point.y +'개 시스템 ';
											     }

                },

//                 	startAngle : -90,
//                  endAngle   : 90
				 
			center: ['50%', '50%']
            }
        },
        
        series: []
    });

    var totCnt = 0;
    var cnt1 = 0;
    for ( var i = 0; i < seriesListPie.length; i++) {
		totCnt = totCnt+seriesListPie[i].y;
		if(seriesListPie[i].name=="사용률"){
			cnt1 = seriesListPie[i].y;
		}
	}
    
    var percent = cnt1/totCnt*100;
    
    
    var titleText = percent+'% <br/>'
     			  + '('+cnt1+'/'+totCnt+' 개 시스템) <br/>'
     			  + '<br><b style="font-size:10px">연계 Agent 동작 상태 현황</b>';
    
	chart4.setTitle({
		text : titleText
	})    
   	chart4.addSeries({
   		type		: 'pie',
   		name        : "brand",			//마우스 올렸을때 뜨는 조그만 박스에 표시 됨
   		innerSize   : '50%',
   		
		data        : seriesListPie

   	});

        
}

function makeChart5(data){
	var data1 = JSON.stringify(data);
	//alert("data=>"+data+"\ndata1=>"+data1);
	//line 차트 
    var categoriesList = JSON.parse(data1).monthList;
    var lDataList1     = JSON.parse(data1).lDataList1;
    var lDataList2     = JSON.parse(data1).lDataList2;
    
    
    chart1 = new Highcharts.Chart({
        chart : {
            renderTo     : 'chart1',
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

function makeChart6(data){
	Highcharts.chart('chart1', {
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
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
	        data: [{
	            name: 'Microsoft Internet Explorer',
	            y: 56.33
	        }, {
	            name: 'Chrome',
	            y: 24.03,
	            sliced: true,
	            selected: true
	        }, {
	            name: 'Firefox',
	            y: 10.38
	        }, {
	            name: 'Safari',
	            y: 4.77
	        }, {
	            name: 'Opera',
	            y: 0.91
	        }, {
	            name: 'Proprietary or Undetectable',
	            y: 0.2
	        }]
	    }]
	});
}

function selectTestData(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect.do" />';
    ajaxSubmit(url,true, makeChart1);
}

function selectTestData2(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect2.do" />';
    ajaxSubmit(url,true, makeChart2);
}

function selectTestData3(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect3.do" />';
    ajaxSubmit(url,true, makeChart3);
}

function selectTestData4(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect4.do" />';
    ajaxSubmit(url,true, makeChart4);
}

function selectTestData5(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect5.do" />';
    ajaxSubmit(url,true, makeChart5);
}
function selectTestData6(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect5.do" />';
    ajaxSubmit(url,true, makeChart6);
}
/*    
function selectTestData(){
//  var searchDate = $("#select_a").val();
    var url = '<c:url value="/com/chartTest/hChartDataSelect.do" />';
    ajaxSubmit(url,true,function(json) {
        if (json.errorMsg) {
            alert(json.errorMsg);
        } else {
//          var userList = JSON.parse(json).userList;
            var resultList = JSON.parse(json).resultList;
            var monthList = JSON.parse(json).monthList;

            var xAxisList = new Array();
            var yValList = new Array();
            var yNameList = new Array();
//          for(var b=1;b<=12;b++){
//              var year = searchDate;
//              var month = '';
//              if(b<10) month += '0'+b;
//              else month += ''+b;
                
//              var YM = year+month
                
//              var flag = false;
//              for(var a=0;a<userList.length;a++){
//                  var userVO = userList[a];
                    
//                  if(YM == userVO.joinMonth){
//                      yValList.push(parseInt(userVO.useCnt));
//                      flag = true;
//                      break;
//                  }
//              }
//              if(!flag){
//                  yValList.push(parseInt(0));
//              }
//              xAxisList.push(month+'월');
//          }
            
            for(var i =0; i < resultList.length;i++){
                yNameList.push(resultList[i].city);
                yValList.push(resultList[i].val);
            }
            
            
//          chart1.xAxis[0].setCategories(xAxisList);
            chart1.xAxis[0].setCategories(monthList);

            for(var j = 0; j < yNameList.length;j++){
                chart1.addSeries({
                    name : yNameList[j],
                    data : yValList[j]
                    
                });
                
            }
            chart1.redraw();
        }
    });
}
*/    

</script>

</head>
<body>
<p>High Chart 테스트 화면</p>
<!-- <div id="chart1" style="min-width: 310px; height: 400px; margin: 0 auto"></div> -->
<div id="chart1">1</div>

<input type="button" onclick="selectTestData()" value="column차트 생성">
<input type="button" onclick="selectTestData2()" value="column&Line차트 생성">
<input type="button" onclick="selectTestData3()" value="pie차트 생성">
<input type="button" onclick="selectTestData4()" value="donut차트 생성">
<input type="button" onclick="selectTestData5()" value="line차트 생성">
<input type="button" onclick="selectTestData6()" value="pie with legend">

</body>
</html>