package go.etri.mp.stm.cmmn.web;


import go.etri.mp.stm.web.CmBbsController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Class Name : chartSampleController.java
 * @Description : chartSampleController Class
 * @Modification Information  
 * @author all4
 *
 */
@Controller
public class chartSampleController {
	
	 private static final Logger logger = LogManager.getLogger(chartSampleController.class);
	@RequestMapping(value="/hChartTest.do")
	public String hChartTest(ModelMap model) {
		
		logger.debug("HighChart Test");
		
		
		return "/cm/hChartTest";
	}

	@RequestMapping(value="/com/chartTest/hChartDataSelect.do")
	public String hChartDataSelect(HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
		logger.debug("HighChart Column Get data");
		
		List<String> monthList = new ArrayList<String>();
		
		monthList.add("1월");
		monthList.add("2월");
		monthList.add("3월");
		monthList.add("4월");
		monthList.add("5월");
		monthList.add("6월");
		monthList.add("7월");
		monthList.add("8월");
		monthList.add("9월");
		monthList.add("10월");
		monthList.add("11월");
		monthList.add("12월");
		 
		String[] city = {"서울", "경기", "강원","충청", "경상", "전라", "제주"};
		
		Map<String, Object> hChartData = null;
		List<Map> hChartDataList = new ArrayList<Map>();
		List<Integer> chartDataListTmp = null;
		for (int i = 0; i < city.length; i++) {
			hChartData = new HashMap<String, Object>();
			chartDataListTmp = new ArrayList<Integer>(); 
			
			hChartData.put("name", city[i]);
			
			for (int j = 0; j < 12; j++) {
				chartDataListTmp.add((i+1)*10+j);
			}

			hChartData.put("data", chartDataListTmp);
			
			
			hChartDataList.add(hChartData);
			
		}
		
		model.addAttribute("monthList", monthList);
		model.addAttribute("resultList", hChartDataList);
		return "jsonView";
		
		
	}
	
	
	@RequestMapping(value="/com/chartTest/hChartDataSelect2.do")
	public String hChartDataSelect2(HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
		logger.debug("HighChart Column&Line Get data");
		
		List<String> monthList = new ArrayList<String>();
		
		monthList.add("1월");
		monthList.add("2월");
		monthList.add("3월");
		monthList.add("4월");
		monthList.add("5월");
		monthList.add("6월");
		monthList.add("7월");
		monthList.add("8월");
		monthList.add("9월");
		monthList.add("10월");
		monthList.add("11월");
		monthList.add("12월");
		 

		
		List<Double> cDataList = new ArrayList<Double>();
		List<Double> lDataList = new ArrayList<Double>();
		
		
		cDataList.add(10.1);
		cDataList.add(20.2);
		cDataList.add(30.3);
		cDataList.add(40.4);
		cDataList.add(50.5);
		cDataList.add(60.6);
		cDataList.add(70.7);
		cDataList.add(80.8);
		cDataList.add(90.9);
		cDataList.add(10.10);
		cDataList.add(100.11);
		cDataList.add(100.12);
		
		lDataList.add(11.1);
		lDataList.add(12.2);
		lDataList.add(13.3);
		lDataList.add(14.4);
		lDataList.add(15.5);
		lDataList.add(16.6);
		lDataList.add(17.7);
		lDataList.add(18.8);
		lDataList.add(19.9);
		lDataList.add(10.10);
		lDataList.add(11.11);
		lDataList.add(12.12);
		
		
		model.addAttribute("monthList", monthList);
		model.addAttribute("cDataList", cDataList);
		model.addAttribute("lDataList", lDataList);
		return "jsonView";
		
		
	}

	@RequestMapping(value="/com/chartTest/hChartDataSelect3.do")
	public String hChartDataSelect3(HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
		logger.debug("HighChart Pie Get data");
		
		
		
//		String[] brand = {"IE", "FF", "OP","CR","SF","OT"};
		String[] brand = {"IE","CR"};
		int[] data = {50,30};
		
		
		List<Map> pDataList = new ArrayList<Map>();
		Map<String, Object> pieDataMap = null;
		
		
		for (int i = 0; i < brand.length; i++) {
			pieDataMap = new HashMap<String, Object>();
			
			pieDataMap.put("name", brand[i]);
			pieDataMap.put("y", data[i]);
			if(i==1){
				pieDataMap.put("sliced", true);
				pieDataMap.put("selected", true);
			}
			
			pDataList.add(pieDataMap);
		}
		
		model.addAttribute("pDataList", pDataList);
		return "jsonView";
		
		
	}

	@RequestMapping(value="/com/chartTest/hChartDataSelect4.do")
	public String hChartDataSelect4(HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
		logger.debug("HighChart semi circle donut Get data");
		
		
		
//		String[] brand = {"IE", "FF", "OP","CR","SF","OT"};
		String[] brand = {"사용","미사용"};
		int[] data = {73,27};
		
		
		List<Map> pDataList = new ArrayList<Map>();
		Map<String, Object> pieDataMap = null;
		
		
		for (int i = 0; i < brand.length; i++) {
			pieDataMap = new HashMap<String, Object>();
			
			pieDataMap.put("name", brand[i]);
			pieDataMap.put("y", data[i]);
			
			pDataList.add(pieDataMap);
		}
		
		model.addAttribute("pDataList", pDataList);
		return "jsonView";
		
		
	}

	@RequestMapping(value="/com/chartTest/hChartDataSelect5.do")
	public String hChartDataSelect5(HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
	logger.debug("HighChart Line2 Get data");
		
		List<String> monthList = new ArrayList<String>();
		
		monthList.add("1월");
		monthList.add("2월");
		monthList.add("3월");
		monthList.add("4월");
		monthList.add("5월");
		monthList.add("6월");
		monthList.add("7월");
		monthList.add("8월");
		monthList.add("9월");
		monthList.add("10월");
		monthList.add("11월");
		monthList.add("12월");
		 

		
		List<Double> lDataList1 = new ArrayList<Double>();
		List<Double> lDataList2 = new ArrayList<Double>();
		
		
		lDataList1.add(10.1);
		lDataList1.add(20.2);
		lDataList1.add(30.3);
		lDataList1.add(40.4);
		lDataList1.add(50.5);
		lDataList1.add(60.6);
		lDataList1.add(70.7);
		lDataList1.add(80.8);
		lDataList1.add(90.9);
		lDataList1.add(10.10);
		lDataList1.add(100.11);
		lDataList1.add(100.12);
		
		lDataList2.add(11.1);
		lDataList2.add(12.2);
		lDataList2.add(13.3);
		lDataList2.add(14.4);
		lDataList2.add(15.5);
		lDataList2.add(16.6);
		lDataList2.add(17.7);
		lDataList2.add(18.8);
		lDataList2.add(19.9);
		lDataList2.add(10.10);
		lDataList2.add(11.11);
		lDataList2.add(12.12);
		
		
		model.addAttribute("monthList", monthList);
		model.addAttribute("lDataList1", lDataList1);
		model.addAttribute("lDataList2", lDataList2);
		return "jsonView";
		
		
	}
	
	@RequestMapping(value="/com/chartTest/aChartTest.do")
	public String aChartTest(ModelMap model) {
		
		logger.debug("AmChart Test");
		
		
		return "/chartTest/aChartTest";
	}
	
	@RequestMapping(value="/com/chartTest/jChartTest.do")
	public String jChartTest(ModelMap model) {
		
		logger.debug("jqPlotChart Test");
		
		
		return "/chartTest/jChartTest";
	}
}
