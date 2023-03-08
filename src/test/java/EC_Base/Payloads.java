package EC_Base;

public class Payloads {
	
	public static String loginPayloads(String userName,String password) {

      return "{\r\n"
      		+ "    \"userEmail\": \""+userName+"\",\r\n"
      		+ "    \"userPassword\": \""+password+"\"\r\n"
      		+ "}";
		
	}
	public static String createOrderPayloads( String prodId) {

	      return "{\r\n"
	      		+ "	    \"orders\": [\r\n"
	      		+ "	        {\r\n"
	      		+ "	            \"country\": \"India\", \r\n"
	      		+ "	            \"productOrderedId\": \""+prodId+"\"\r\n"
	      		+ "	        }\r\n"
	      		+ "	    ]\r\n"
	      		+ "	}";
			
		}

	
	
	
}
