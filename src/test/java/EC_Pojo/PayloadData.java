package EC_Pojo;

public class PayloadData {
	
	private static String accToken;
	private static String productId;
	private static String orders;
	private static String userId;
	
	public static String getAccToken() {
		return accToken;
	}
	public static void setAccToken(String accToken) {
		PayloadData.accToken = accToken;
	}
	public static String getProductId() {
		return productId;
	}
	public static void setProductId(String productId) {
		PayloadData.productId = productId;
	}
	public static String getOrders() {
		return orders;
	}
	public static void setOrders(String orders) {
		PayloadData.orders = orders;
	}
	public static String getUserId() {
		return userId;
	}
	public static void setUserId(String userId) {
		PayloadData.userId = userId;
	}
}
