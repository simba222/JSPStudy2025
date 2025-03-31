<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="etc03.BusanThemeBean" %>
<jsp:useBean id="mgr" class="etc03.BusanThemeMgr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>부산테마여행</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
    <div id="wrap">
        <!-- header -->
        <header id="header">
            <!-- nav -->
            <nav id="nav">
                <h3 class="logo">
                    <span>부산</span>
                </h3>
            </nav>
        </header>
        <!-- main -->
        <main class="common_wrap" id="theme_detail_page">
            <div id="container">
                <section class="common_box content_box">
                    <div class="common_title theme_title">
                        <h1>테마 여행 상세보기</h1>
                    </div>
                    <div class="theme_field">
                        <%
                            int ucSeq = Integer.parseInt(request.getParameter("ucSeq"));
                            BusanThemeBean theme = mgr.getBusanThemeDetail(ucSeq);
                            if (theme != null) {
                        %>
                        <div class="theme_detail_content">
                            <div class="theme_detail_img">
                                <img src="<%= theme.getMainImgNormal() != null ? theme.getMainImgNormal() : theme.getMainImgThumb() %>" alt="<%= theme.getMainTitle() %>">
                            </div>
                            <div class="theme_detail_info">
                                <h2 class="theme_detail_title"><%= theme.getMainTitle() %></h2>
                                <p class="theme_detail_subtitle"><%= theme.getSubtitle() != null ? theme.getSubtitle() : "" %></p>
                                <ul class="theme_detail_fields">
                                    <li><span class="theme_detail_label">지역:</span> <%= theme.getGugunNm() %></li>
                                    <li><span class="theme_detail_label">카테고리:</span> <%= theme.getCate2Nm() %></li>
                                    <li><span class="theme_detail_label">위치:</span> <%= theme.getPlace() %></li>
                                    <li><span class="theme_detail_label">주소:</span> <%= theme.getAddr1() %></li>
                                    <li><span class="theme_detail_label">홈페이지:</span> <a href="<%= theme.getHomepageUrl() != null ? theme.getHomepageUrl() : "#" %>" target="_blank"><%= theme.getHomepageUrl() != null ? theme.getHomepageUrl() : "홈페이지 없음" %></a></li>
                                    <li><span class="theme_detail_label">교통 정보:</span> <span class="theme_detail_textarea"><%= theme.getTrfcInfo() != null ? theme.getTrfcInfo() : "교통 정보 없음" %></span></li>
                                    <li><span class="theme_detail_label">상세 설명:</span> <span class="theme_detail_textarea"><%= theme.getItemcntnts() != null ? theme.getItemcntnts() : "상세 설명 없음" %></span></li>
                                </ul>
                            </div>
                        </div>
                        <div class="action_btn">
                            <button onclick="window.history.back()">목록으로 돌아가기</button>
                        </div>
                        <%} else {%>
                        <p>해당 테마 여행 정보를 찾을 수 없습니다.</p>
                        <%}%>
                    </div>
                </section>
            </div>
        </main>
    </div>
</body>
</html>