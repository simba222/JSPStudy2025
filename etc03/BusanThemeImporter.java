package etc03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.JSONArray;
import org.json.JSONObject;

public class BusanThemeImporter {

	 public static void main(String[] args) {
		 	DBConnectionMgr pool = DBConnectionMgr.getInstance();
	        String jsonFilePath = "open_api.json"; // JSON 파일 경로
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        try {
	            // JSON 파일 읽기
	            String jsonData = readJsonFile(jsonFilePath);
	            JSONObject jsonObject = new JSONObject(jsonData);
	            JSONArray items = jsonObject.getJSONObject("getRecommendedKr").getJSONArray("item");

	            // MySQL 연결
	            con = pool.getConnection();
	            //con.setAutoCommit(false); // 트랜잭션 시작

	            String sql = "INSERT tblBusanTheme (uc_seq, main_title, gugun_nm, "
	            		+ "cate2_nm, lat, lng, place, title, subtitle, addr1, homepage_url, "
	            		+ "trfc_info, main_img_normal, main_img_thumb, itemcntnts) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            pstmt = con.prepareStatement(sql);

	            // JSON 데이터 삽입
	            for (int i = 0; i < items.length(); i++) {
	                JSONObject item = items.getJSONObject(i);

	                pstmt.setInt(1, item.getInt("UC_SEQ"));
	                pstmt.setString(2, item.optString("MAIN_TITLE", ""));
	                pstmt.setString(3, item.optString("GUGUN_NM", ""));
	                pstmt.setString(4, item.optString("CATE2_NM", ""));
	                pstmt.setDouble(5, item.optDouble("LAT", 0.0));
	                pstmt.setDouble(6, item.optDouble("LNG", 0.0));
	                pstmt.setString(7, item.optString("PLACE", ""));
	                pstmt.setString(8, item.optString("TITLE", ""));
	                pstmt.setString(9, item.optString("SUBTITLE", ""));
	                pstmt.setString(10, item.optString("ADDR1", ""));
	                pstmt.setString(11, item.optString("HOMEPAGE_URL", ""));
	                pstmt.setString(12, item.optString("TRFC_INFO", ""));
	                pstmt.setString(13, item.optString("MAIN_IMG_NORMAL", ""));
	                pstmt.setString(14, item.optString("MAIN_IMG_THUMB", ""));
	                pstmt.setString(15, item.optString("ITEMCNTNTS", ""));

	                pstmt.addBatch(); // 배치 추가
	            }
	            pstmt.executeBatch(); // 배치 실행
	            System.out.println("데이터가 성공적으로 MySQL에 저장됨.");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }  finally {
	        	pool.freeConnection(con, pstmt);
			}
	    }

	    // JSON 파일 읽기 메서드
	    private static String readJsonFile(String filePath) {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return content.toString();
	    }
	}