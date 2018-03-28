/**
 * 
 */
/**
 * @author 김인석
 *
 */
package go.etri.mp.stm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import go.etri.mp.stm.service.CmBbsDefaultVO;
import go.etri.mp.stm.service.CmBbsService;
import go.etri.mp.stm.service.CmBbsVO;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
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

@Service("cmBbsService")
public class CmBbsServiceImpl extends EgovAbstractServiceImpl implements CmBbsService {

	private static final Logger logger = LoggerFactory.getLogger(CmBbsServiceImpl.class);

	/** SampleDAO */
	// TODO ibatis 사용
	@Resource(name = "cmBbsDAO")
	private CmBbsDAO cmBbsDAO;
	// TODO mybatis 사용
	//  @Resource(name="sampleMapper")
	//	private SampleMapper sampleDAO;


	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public void insertSample(CmBbsVO vo) throws Exception {
		//LOGGER.debug(vo.toString());
		/** ID Generation Service */
		//String id = egovIdGnrService.getNextStringId();
		//vo.setId(id);
		//LOGGER.debug(vo.toString());

		cmBbsDAO.insertSample(vo);
		//return id;
	}
	
	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public void fileUploadServiceProc(CmBbsVO vo) throws Exception {
		/*String boardNo = cmBbsDAO.selectBoardNo(vo); //로그아이디
		logger.debug("boardNo=>"+boardNo);
		vo.setBoardNo(boardNo);*/
		cmBbsDAO.fileUploadServiceProc(vo);
		//return id;
	}
	
	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void updateSample(CmBbsVO vo) throws Exception {
		cmBbsDAO.updateSample(vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deleteSample(CmBbsVO vo) throws Exception {
		cmBbsDAO.deleteSample(vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deleteFile(CmBbsVO vo) throws Exception {
		cmBbsDAO.deleteFile(vo);
	}
	
	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public CmBbsVO selectSample(CmBbsVO vo) throws Exception {
		CmBbsVO resultVO = cmBbsDAO.selectSample(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	@Override
	public List<?> selectSampleList(CmBbsVO searchVO) throws Exception {
		return cmBbsDAO.selectSampleList(searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
	@Override
	public int selectSampleListTotCnt(CmBbsVO searchVO) {
		return cmBbsDAO.selectSampleListTotCnt(searchVO);
	}
	
    public Map<String, Object> selectCmDetailList(CmBbsVO vo) throws Exception {
    	List<?> result = cmBbsDAO.selectCmDetailList(vo); 

    	Map<String, Object> map = new HashMap<String, Object>();
	
    	map.put("resultList", result);

    	return map;
	}
    
    public Map<String, Object> selectCmDetailFileList(CmBbsVO vo) throws Exception {
    	List<?> result = cmBbsDAO.selectCmDetailFileList(vo); 

    	Map<String, Object> map = new HashMap<String, Object>();
	
    	map.put("resultList", result);

    	return map;
	}
}
