/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package go.etri.mp.stm.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import go.etri.mp.stm.cmmn.CommonVO;
import go.etri.mp.stm.cmmn.util.FileMngUtil;
import go.etri.mp.stm.service.CmBbsService;
import go.etri.mp.stm.service.CmBbsVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class OvStmController {
	 private static final Logger logger = LogManager.getLogger(OvStmController.class);
	/** EgovSampleService */
	@Resource(name = "cmBbsService")
	private CmBbsService cmBbsService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/overViewList.do")
	public String selectOverViewList(@ModelAttribute("searchVO") CommonVO searchVO, ModelMap model) throws Exception {
		logger.debug("overViewList");
		
		return "ov/ov01";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/serviceList.do")
	public String selectServiceList(@ModelAttribute("searchVO") CommonVO searchVO, ModelMap model) throws Exception {
		logger.debug("serviceList");
		
		return "ov/ov02";
	}
	
	@RequestMapping(value="/overViewChartOne.do")
	public String hChartDataSelect3(@ModelAttribute("searchVO") CommonVO searchVO,HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
		logger.debug("HighChart Pie Get data param=>"+searchVO.getChartNm());
		
		
		
		String[] brand = {"IE", "FF", "OP","CR","SF","OT"};
		int[] data = {20,20,20,20,10,10};
		
		
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
		model.addAttribute("chartNm","dvChart"+searchVO.getChartNm());
		model.addAttribute("pDataList", pDataList);
		return "jsonView";
		
		
	}
	
	@RequestMapping(value="/overViewChartTwo.do")
	public String hChartDataSelect5(@ModelAttribute("searchVO") CommonVO searchVO,HttpSession session, ModelMap model, HttpServletResponse response) throws Exception {
		
	logger.debug("HighChart Line2 Get data param=>"+searchVO.getChartNm());
		
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
		
		model.addAttribute("chartNm","dvChart"+searchVO.getChartNm());
		model.addAttribute("monthList", monthList);
		model.addAttribute("lDataList1", lDataList1);
		model.addAttribute("lDataList2", lDataList2);
		return "jsonView";
		
		
	}
	
}
