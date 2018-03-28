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
package go.etri.mp.stm.service.impl;

import java.util.HashMap;
import java.util.List;

import go.etri.mp.stm.cmmn.dataaccess.AmAbstractDAO;
import go.etri.mp.stm.service.CmBbsDefaultVO;
import go.etri.mp.stm.service.CmBbsVO;

import org.springframework.stereotype.Repository;

/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
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

@Repository("cmBbsDAO")
public class CmBbsDAO extends AmAbstractDAO {

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertSample(CmBbsVO vo) throws Exception {
		insert("CmBbsDAO.insertSample", vo);
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSample(CmBbsVO vo) throws Exception {
		update("CmBbsDAO.updateSample", vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSample(CmBbsVO vo) throws Exception {
		delete("CmBbsDAO.deleteSample", vo);
	}
	
	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteFile(CmBbsVO vo) throws Exception {
		delete("CmBbsDAO.deleteFile", vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	public CmBbsVO selectSample(CmBbsVO vo) throws Exception {
		return (CmBbsVO) select("sampleDAO.selectSample", vo);
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectSampleList(CmBbsVO searchVO) throws Exception {
		return list("CmBbsDAO.selectCmList", searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 총 갯수
	 * @exception
	 */
	public int selectSampleListTotCnt(CmBbsVO searchVO) {
		return (Integer) select("CmBbsDAO.selectCmListTotCnt", searchVO);
	}
	
	@SuppressWarnings("unchecked")
    public List<?> selectCmDetailList(CmBbsVO vo) throws Exception {
    	return list("CmBbsDAO.selectCmDetailList", vo);
    }
	
	@SuppressWarnings("unchecked")
    public List<?> selectCmDetailFileList(CmBbsVO vo) throws Exception {
    	return list("CmBbsDAO.selectCmDetailFileList", vo);
    }
	
	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void fileUploadServiceProc(CmBbsVO vo) throws Exception {
		insert("CmBbsDAO.insertFile", vo);
	}
	
	//로그아이디
	public String selectBoardNo(CmBbsVO vo) throws Exception {
    	return (String)getSqlMapClientTemplate().queryForObject("CmBbsDAO.selectFileNo", vo);
    }
}
