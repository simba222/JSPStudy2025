package etc03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class ApiClient {
	
	// main 함수 실행 후 프로젝트 선택 후 새로고침 (F5)
	public static void main(String[] args) {
        String baseUrl = "http://apis.data.go.kr/6260000/RecommendedService/getRecommendedKr"; // 올바른 엔드포인트 확인
        String serviceKey = "본인의인증키"; // 서비스 키
        String outputFilePath = "open_api.json"; // 루트 프로젝트 폴더 아래 파일이 저장됩니다. 
        int pageNo = 1;
        // 이클립스, STS 에서 20개 이상 받고 파일을 열어볼 경우 메모리 부족 에러 발생 확인 
        int numOfRows = 2200; // 1개만 받아서 스키마 구조 확인 필요 

        try {
            // URL 생성 및 파라미터 추가
            StringBuilder urlBuilder = new StringBuilder(baseUrl);
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode(serviceKey, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(pageNo), "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(numOfRows), "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); // JSON 응답

            // HTTP 연결 설정
            URI uri = new URI(urlBuilder.toString());
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000); // 5초 타임아웃
            connection.setReadTimeout(5000);

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            if (responseCode >= 200 && responseCode <= 300) { // 정상 응답
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                reader.close();

                // JSON 데이터 파일로 저장
                saveToFile(response.toString(), outputFilePath);
                System.out.println("JSON 데이터가 " + outputFilePath + " 파일에 저장됨.");
            } else { // 오류 응답
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    errorResponse.append(line);
                }
                reader.close();
                System.out.println("HTTP 요청 실패: 응답 코드 " + responseCode);
                System.out.println("오류 메시지: " + errorResponse);
            }

            // 연결 종료
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // JSON 데이터를 파일로 저장하는 메서드
    private static void saveToFile(String jsonData, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(jsonData);
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
}
