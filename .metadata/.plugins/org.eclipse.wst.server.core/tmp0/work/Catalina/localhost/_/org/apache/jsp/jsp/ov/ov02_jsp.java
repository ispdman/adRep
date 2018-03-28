package org.apache.jsp.jsp.ov;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ov02_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function makeChart1(data){\r\n");
      out.write(" \tvar charNm=data.chartNm;\r\n");
      out.write(" \t data = JSON.stringify(data);\r\n");
      out.write("\t//pie 차트 \r\n");
      out.write("    var seriesListPie = JSON.parse(data).pDataList;\r\n");
      out.write("   \t Highcharts.chart(charNm, {\r\n");
      out.write("\t    chart: {\r\n");
      out.write("\t        plotBackgroundColor: null,\r\n");
      out.write("\t        plotBorderWidth: null,\r\n");
      out.write("\t        plotShadow: false,\r\n");
      out.write("\t        type: 'pie'\r\n");
      out.write("\t    },\r\n");
      out.write("\t    title: {\r\n");
      out.write("\t        text: 'Browser market shares January, 2015 to May, 2015'\r\n");
      out.write("\t    },\r\n");
      out.write("\t    tooltip: {\r\n");
      out.write("\t        pointFormat: '{point.y}, <b>{point.percentage:.1f}%</b>'\r\n");
      out.write("\t    },\r\n");
      out.write("\t    plotOptions: {\r\n");
      out.write("\t        pie: {\r\n");
      out.write("\t            allowPointSelect: true,\r\n");
      out.write("\t            cursor: 'pointer',\r\n");
      out.write("\t            dataLabels: {\r\n");
      out.write("\t                enabled: false\r\n");
      out.write("\t            },\r\n");
      out.write("\t            showInLegend: true\r\n");
      out.write("\t        }\r\n");
      out.write("\t    },\r\n");
      out.write("\t    series: [{\r\n");
      out.write("\t        name: 'Brands',\r\n");
      out.write("\t        colorByPoint: true,\r\n");
      out.write("\t        \tdata        : seriesListPie\r\n");
      out.write("\t    }]\r\n");
      out.write("\t}); \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function makeChart2(data){\r\n");
      out.write("\tvar charNm=data.chartNm;\r\n");
      out.write("\tdata = JSON.stringify(data);\r\n");
      out.write("\t//line 차트 \r\n");
      out.write("    var categoriesList = JSON.parse(data).monthList;\r\n");
      out.write("    var lDataList1     = JSON.parse(data).lDataList1;\r\n");
      out.write("    var lDataList2     = JSON.parse(data).lDataList2;\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    Highcharts.chart(charNm, {\r\n");
      out.write("        chart: {\r\n");
      out.write("            type: 'column'\r\n");
      out.write("        },\r\n");
      out.write("        title: {\r\n");
      out.write("            text: 'Stacked column chart'\r\n");
      out.write("        },\r\n");
      out.write("        xAxis: {\r\n");
      out.write("            categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']\r\n");
      out.write("        },\r\n");
      out.write("        yAxis: {\r\n");
      out.write("            min: 0,\r\n");
      out.write("            title: {\r\n");
      out.write("                text: 'Total fruit consumption'\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        tooltip: {\r\n");
      out.write("            pointFormat: '<span style=\"color:{series.color}\">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',\r\n");
      out.write("            shared: true\r\n");
      out.write("        },\r\n");
      out.write("        plotOptions: {\r\n");
      out.write("            column: {\r\n");
      out.write("                stacking: 'percent'\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        series: [{\r\n");
      out.write("            name: 'John',\r\n");
      out.write("            data: [5, 3, 4, 7, 2]\r\n");
      out.write("        }, {\r\n");
      out.write("            name: 'Jane',\r\n");
      out.write("            data: [2, 2, 3, 2, 1]\r\n");
      out.write("        }, {\r\n");
      out.write("            name: 'Joe',\r\n");
      out.write("            data: [3, 4, 4, 2, 5]\r\n");
      out.write("        }]\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function selectTestData1(no){\r\n");
      out.write("   var url = '");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("   $(\"#chartNm\").val(no);\r\n");
      out.write("    ajaxSubmit(url,true, makeChart1,no);\r\n");
      out.write("}\r\n");
      out.write("function selectTestData2(no){\r\n");
      out.write("    var url = '");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("    ajaxSubmit(url,true, makeChart2, no);\r\n");
      out.write("}\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\tselectTestData1(1);\r\n");
      out.write("\tselectTestData2(2);\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../cmmn/comParam.jsp", out, false);
      out.write("<!-- 공통파라미터 -->\r\n");
      out.write("\t<form name=\"process\" id=\"process\" method=\"post\" >\r\n");
      out.write("\t<!-- //content -->\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"sub_header\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- location -->\r\n");
      out.write("\t\t\t\t\t<ol class=\"location\">\r\n");
      out.write("\t\t\t\t\t\t<li>sp</li>\r\n");
      out.write("\t\t\t\t\t\t<li>리스트</li>\r\n");
      out.write("\t\t\t\t\t</ol><!-- //location -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<h3>sp</h3>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div><!-- //sub_header -->\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- search -->\r\n");
      out.write("\t\t\t\t<div class=\"table_content\">\r\n");
      out.write("\t\t\t\t\t<table summary=\"이 표는 기관명, 시스템명, 작동상태로 구성되어 있습니다.\">\r\n");
      out.write("\t\t\t\t\t\t<caption>검색 조회</caption>\r\n");
      out.write("\t\t\t\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t\t\t\t<col width=\"140px\" />\r\n");
      out.write("\t\t\t\t\t\t\t<col width=\"auto\" />\r\n");
      out.write("\t\t\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"row\"><label for=\"insttNm\">그래프</label></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"graph1\" name=\"graph1\" value=\"1\"/> 비율\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"graph1\" name=\"graph1\" value=\"2\"/> 추세\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"row\"><label for=\"insttNm\">기준시간</label></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input id=\"datetimepicker\" type=\"text\" class=\"w140\" name=\"datetimepicker\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(function () {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    $(\"#datetimepicker\").datetimepicker(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    \t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    \t\tshowSecond: true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    \t\t  dateFormat: 'yy-mm-dd',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    \t\t  timeFormat: 'hh:mm:ss'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    \t}\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    );\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</script>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"row\"><label for=\"insttNm\">시간간격</label></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"w140\" id=\"timePart\" name=\"timePart\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value='5' >5분</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value='10' >10분</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value='15' >15분</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"text-right\">\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-sm\" type=\"button\" onclick=\"fnResult();return false;\">조회</button>\r\n");
      out.write("\t\t\t\t</div> <!-- //search -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<!-- 로딩div -->\r\n");
      out.write("\t\t\t    <div id=\"loadData\" style=\"width:100%; height:0%; margin-top:0px; border:0px;\"></div>\r\n");
      out.write("\t\t\t    <!-- 로딩 이미지 -->\r\n");
      out.write("\t\t\t\t<div id=\"viewLoading\" style=\"left:500px;display:none;\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" alt=\"로딩이미지\"/>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"page_total\">\r\n");
      out.write("\t\t\t\t\t<div class=\"left\"> \r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-gray\" type=\"button\" onclick=\"javascript:fnGraphSel(1);\">비율</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-gray\" type=\"button\" onclick=\"javascript:fnGraphSel(2);\">추세</button>\r\n");
      out.write("\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t<label for=\"pageUnit\">　</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- content -->\r\n");
      out.write("\t\t\t\t<div class=\"table_container\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- 비율그래프 시작 -->\r\n");
      out.write("\t\t\t\t<div id=\"dv1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main_form03\" >\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"border\" style=\"height:330px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"dvChart1\" style=\"height:310px;margin-top: 20px;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"border\" style=\"height:330px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"dvChart2\" style=\"height:310px;margin-top: 20px;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 비율그래프 끝 -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- content -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /jsp/ov/ov02.jsp(91,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/overViewChartOne.do");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /jsp/ov/ov02.jsp(96,15) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/overViewChartTwo.do");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /jsp/ov/ov02.jsp(177,15) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/img/ajax-loader.gif");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }
}
