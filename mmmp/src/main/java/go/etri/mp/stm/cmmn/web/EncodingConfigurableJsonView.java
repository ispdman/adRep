package go.etri.mp.stm.cmmn.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.spring.web.servlet.view.JsonView;

public class EncodingConfigurableJsonView extends JsonView {

	@SuppressWarnings("unchecked")
	@Override
	protected void writeJSON(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		super.writeJSON(model, request, response);
	}

}
