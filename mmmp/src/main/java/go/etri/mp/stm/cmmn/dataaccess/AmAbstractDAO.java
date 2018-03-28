/**
 * 
 */
/**
 * @author 김인석
 *
 */
package go.etri.mp.stm.cmmn.dataaccess;

import javax.annotation.Resource;

import com.ibatis.sqlmap.client.SqlMapClient;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/** 
 * DW/DB 의 NSDI 계정에 접근하기 위한 datasource
 * 
 * 기존 DAO의 경우 EgovAbstractDAO를 extends하도록 되어 있으나
 * 다른 DB를 참조해야 하는 경우 현재 클래스와 같이 sqlMapClient가 아닌 
 * 다른 sqlMapClient를 지정하는 클래스를 통해 접근한다.
 *
 */
public class AmAbstractDAO extends EgovAbstractDAO {
	/**
     * NSDI용 AmSqlMapClient 지정
     */
    @Resource(name = "AmSqlMapClient")
    public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
        super.setSuperSqlMapClient(sqlMapClient);
    }
}