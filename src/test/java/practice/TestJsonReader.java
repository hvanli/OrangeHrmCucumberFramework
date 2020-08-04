package practice;
import com.hrm.utils.ApiContants;
import com.hrm.utils.CommonMethods;

public class TestJsonReader extends CommonMethods{

	public static void main(String[] args) {
		
		String json=readJson(ApiContants.GENERATE_TOKEN_BODY_FILEPATH);
		System.out.println(json);

	}
}
