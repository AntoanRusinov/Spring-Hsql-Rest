package exception.resolvers;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import enums.CustomErrorStatus;
import exceptions.CustomException;

/**
 * @author antoan
 */
public class JsonExceptionResolver implements HandlerExceptionResolver {

	public static Logger logger = LoggerFactory.getLogger(JsonExceptionResolver.class);

	private Gson gson;

	public JsonExceptionResolver(Gson gson) {
		this.gson = gson;
	}

	public JsonExceptionResolver() {
		//for the jpa
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {

		try {
			setStatusCode(response, exception);
			PrintWriter writer = response.getWriter();
			CustomErrorStatus status = null;
			JsonElement jsonObject = null;

			if (exception instanceof CustomException) {
				CustomException customException = (CustomException) exception;
				status = customException.getCustomErrorStatus();
				
				if (status == CustomErrorStatus.ERROR) {
					jsonObject = errorJsonResult(CustomErrorStatus.ERROR.getStatusCode(), customException.getErrorMessage());
				}

			}
			writer.printf(jsonObject.toString());
			return new ModelAndView();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occured!");
		}

		return null;
	}

	public JsonElement errorJsonResult(int errorCode, String errorMessage) {
		Map<String, Object> wrappedData = new HashMap<>();
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("status", "ERROR");
		wrappedData.put("code", errorCode);
		wrappedData.put("explanation", errorMessage);
		errorMap.put("error", wrappedData);

		return gson.toJsonTree(errorMap);
	}

	private void setStatusCode(HttpServletResponse response, Exception exception) {
		if (exception instanceof CustomException) {CustomException customException = (CustomException) exception;
			int httpCode = customException.getCustomErrorStatus().getHttpCode();
			if (httpCode != 0) {
				response.setStatus(httpCode);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
	}

}