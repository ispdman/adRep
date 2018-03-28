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
import go.etri.mp.stm.cmmn.util.FileMngUtil;
import go.etri.mp.stm.service.CmBbsService;
import go.etri.mp.stm.service.CmBbsVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
public class CmBbsController {
	 private static final Logger logger = LogManager.getLogger(CmBbsController.class);
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
	@RequestMapping(value = "/cmList.do")
	public String selectCmList(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model) throws Exception {
		logger.debug("cmlist1");
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		logger.debug("cmlist2");
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		logger.debug("cmlist3");
		List<?> sampleList = cmBbsService.selectSampleList(searchVO);
		model.addAttribute("resultList", sampleList);
		logger.debug("cmlist4");
		int totCnt = cmBbsService.selectSampleListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		logger.debug("cmlist5");
		
		return "cm/cm01";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/selectCmRegist.do")
	public String selectCmRegist(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model) throws Exception {
		
		return "cm/cm02";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/cmRegist.do")
	public String CmRegist(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model,MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		//파일업로드
        MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest)request;
        Iterator fileIter = mptRequest.getFileNames();
        ArrayList result = new ArrayList();
        int i=1;
        while (fileIter.hasNext()) {
            MultipartFile mFile = mptRequest.getFile((String)fileIter.next());
            logger.debug("mFile.getSize=>"+mFile.getSize());
            if (mFile.getSize() > 0) {
            HashMap map = FileMngUtil.uploadFile(mFile,propertiesService.getString("Globals.fileStorePath"));
            String originalName = (String)map.get("ORIGIN_FILE_NM");
            String fileName = (String)map.get("UPLOAD_FILE_NM");
            String fileSize = (String)map.get("FILE_SIZE");
            String filePath = (String)map.get("FILE_PATH"); 
            String fileExt = (String)map.get("FILE_EXT");
            logger.debug("ORIGIN_FILE_NM=>"+originalName);
            logger.debug("UPLOAD_FILE_NM=>"+fileName);
            logger.debug("FILE_SIZE=>"+fileSize);
            logger.debug("FILE_PATH=>"+filePath);
            logger.debug("FILE_EXT=>"+fileExt);
            searchVO.setFileSn(Integer.toString(i));
            searchVO.setCreaId(searchVO.getId());
            searchVO.setFileSize(fileSize);
            searchVO.setOriginalFileName(originalName);
            searchVO.setStoredFileName(filePath+"\\\\"+fileName);
            cmBbsService.fileUploadServiceProc(searchVO);
            }
            i=i+1;
        }

		cmBbsService.insertSample(searchVO);
		return "redirect:/cmList.do";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/cmDetailList.do")
	public String selectCmDetailList(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model) throws Exception {
		System.out.println("selectCmDetailList");
		Map<String, Object> map = cmBbsService.selectCmDetailList(searchVO);
		Map<String, Object> map2 = cmBbsService.selectCmDetailFileList(searchVO);
		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultList2", map2.get("resultList"));
		
		return "cm/cm03";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fileDownload.do")
	public void fileDownload(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model,HttpServletResponse response) throws Exception {
		// 다운로드 받을 파일
		String    F_FILE_NM    = searchVO.getStoredFileName();
		// 사용자가 다운로드시 받게될 파일명
		// 파일명을 변경하면 서버상에 올라간 파일명과 다른 파일명으로 다운로드 받게됨
		String    R_FILE_NM    = searchVO.getOriginalFileName();//"pcmanager_setup.exe";
		// 파일의 확장자에 따른 마인 정보를 알아옴
		String    MIME        = FileMngUtil.getMime("exe");

		if(!F_FILE_NM.equals("") && !R_FILE_NM.equals("") && !MIME.equals(""))
		{
		    File file = new File (F_FILE_NM);
		    logger.debug(F_FILE_NM);
		    if(file.exists())
		    {
		        response.setHeader("Content-Type",MIME);
		        response.setHeader("Content-disposition","attachment; filename="+FileMngUtil.EnCodeType(R_FILE_NM,"euc-kr","8859_1"));
		        logger.debug("filedownload.do1");
		        byte[] bytestream = new byte[(int)file.length()];
		        int    i    = 0;
		        int    j    = 0;

		        BufferedInputStream        fin        = new BufferedInputStream(new FileInputStream(file));
		        BufferedOutputStream    fouts    = new BufferedOutputStream(response.getOutputStream(),4096);
		        logger.debug("filedownload.do2");
		        int read = 0;
		        try
		        {
		            while ((read = fin.read(bytestream)) != -1)
		            {
		                fouts.write(bytestream, 0, read);
		            }

		            fouts.close();
		            fin.close();
		        }
		        catch (Exception e)
		        {
		            logger.debug(e.getMessage());
		        }
		        finally
		        {
		            if(fouts!=null) fouts.close();
		            if(fin!=null) fin.close();
		        }
		    }// if end
		}
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/cmModi.do")
	public String CmModi(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model) throws Exception {
		cmBbsService.updateSample(searchVO);
		model.addAttribute("successYn", "Y");
		return "jsonView";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/cmDel.do")
	public String cmDel(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model) throws Exception {
		
		cmBbsService.deleteSample(searchVO);
		Map<String, Object> fileList = cmBbsService.selectCmDetailFileList(searchVO);
	     if(fileList != null){
	    	 cmBbsService.deleteFile(searchVO);//전체파일삭제
	    	 Map fileInfo;
	         List fileListReult=(List)fileList.get("resultList");
	         for(int i=0; i<fileListReult.size();i++){
	        	  fileInfo=(Map)fileListReult.get(i);
	        	 logger.debug("storedFileName=>"+fileInfo.get("storedFileName"));
	          String filePath = (String)fileInfo.get("storedFileName");
	          FileMngUtil.deleteFile(filePath);
	         }
	     }
		model.addAttribute("successYn", "Y");
		return "jsonView";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fileDel.do")
	public String fileDel(@ModelAttribute("searchVO") CmBbsVO searchVO, ModelMap model) throws Exception {
		//cmBbsService.deleteSample(searchVO);
		//model.addAttribute("successYn", "Y");
		cmBbsService.deleteFile(searchVO);
		FileMngUtil.deleteFile(searchVO.getStoredFileName());
		return "redirect:/cmDetailList.do?boardNo="+searchVO.getBoardNo();
	}
}
