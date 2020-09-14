/*
 * package utils;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.json.JSONObject;
 * 
 * //import com.fedex.api.automation.pages.apps.AppsFulfillmentOrdersPageObject;
 * 
 * import io.restassured.RestAssured; import io.restassured.response.Response;
 * import io.restassured.specification.RequestSpecification;
 * 
 * public class PostmanHandler {
 * 
 * ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir")+
 * "\\"+Config.getProperty("attachmentsPath2")+Config.getProperty("teststub"));
 * //AppsFulfillmentOrdersPageObject appsFulfillmentOrdersPageObject = new
 * AppsFulfillmentOrdersPageObject(); public static Map<String, Integer>
 * APIDetailsColumnHeader = new HashMap<>(); public static String APISheetName =
 * "API Details"; TestStubReader stubReader;
 * 
 * public static void setAPIDetailsColHeader(String header,int colIndex){
 * 
 * APIDetailsColumnHeader.put(header, colIndex); }
 * 
 * public static int getAPIDetailsColHeader(String colHeader){
 * 
 * return APIDetailsColumnHeader.get(colHeader); }
 * 
 * 
 * // { // stubReader = new TestStubReader(); // // for(int
 * i=1;i<=excelReader.getColCount(APISheetName);i++){ // // String header =
 * stubReader.setSheetAndGetData(APISheetName, "Name_App", i); //
 * System.out.println("Header::"+header+"::"+i); //
 * setAPIDetailsColHeader(header, i); //
 * //System.out.println("Column Index::"+getAPIDetailsColHeader("Org Name")); //
 * } // // }
 * 
 * public String generateAccessTokenAndRefreshToken(String appOwner){
 * 
 * //String appOwner = "Sahithya_Fulfillment"; String status=null;
 * 
 * stubReader = new TestStubReader(); stubReader.setReadingSheet(APISheetName);
 * 
 * RequestSpecification request = RestAssured.given();
 * request.contentType("application/x-www-form-urlencoded; charset=UTF-8");
 * request.header("org_name", stubReader.getData(appOwner, 1));
 * request.formParam("code",stubReader.getData(appOwner, 2) );
 * request.formParam("client_id", stubReader.getData(appOwner, 3));
 * request.formParam("client_secret", stubReader.getData(appOwner, 4));
 * request.formParam("grant_type", "authorization_code");
 * request.formParam("scope", "Fulfillment_Returns");
 * 
 * Response response = request.post(Config.getProperty("api_endpoint"));
 * 
 * String responseBody = response.getBody().asString();
 * 
 * if(responseBody.contains("access_token")){
 * 
 * JSONObject json = new JSONObject(responseBody); String accessToken
 * =json.getString("access_token"); stubReader.addData(appOwner, accessToken,
 * 7); System.out.println("Access Token::"+accessToken); String refreshToken =
 * json.getString("refresh_token"); stubReader.addData(appOwner, refreshToken,
 * 8); System.out.println("Refresh Token::"+refreshToken);
 * 
 * status = "TokenGeneration:Success"; return status;
 * 
 * }else{
 * 
 * status = "TokenGeneration:Fail"; return status; }
 * 
 * 
 * }
 * 
 * 
 * public String generateAccessTokenWithRefreshTok(String appOwner){
 * 
 * //String appOwner = "Sahithya_Fulfillment"; String status=null;
 * 
 * stubReader = new TestStubReader(); stubReader.setReadingSheet(APISheetName);
 * RequestSpecification request = RestAssured.given();
 * request.contentType("application/x-www-form-urlencoded; charset=UTF-8");
 * request.header("org_name", stubReader.getData(appOwner, 1));
 * request.formParam("refresh_token",stubReader.getData(appOwner, 8) );
 * request.formParam("client_id", stubReader.getData(appOwner, 3));
 * request.formParam("client_secret", stubReader.getData(appOwner, 4));
 * request.formParam("grant_type", "refresh_token"); request.formParam("scope",
 * "Fulfillment_Returns");
 * 
 * Response response = request.post(Config.getProperty("api_endpoint")); String
 * responseBody = response.getBody().asString();
 * System.out.println("Response Body is =>  " + responseBody);
 * 
 * if(responseBody.contains("access_token")){
 * 
 * JSONObject json = new JSONObject(responseBody); String accessToken
 * =json.getString("access_token"); stubReader.addData(appOwner, accessToken,
 * 7); String refreshToken = json.getString("refresh_token");
 * stubReader.addData(appOwner, refreshToken, 8);
 * 
 * status = "TokenGeneration:Success"; return status;
 * 
 * }else{
 * 
 * status = "TokenGeneration:Fail"; return status; }
 * 
 * }
 * 
 * 
 * }
 */