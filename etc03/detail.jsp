<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="etc03.BusanThemeBean" %>
<jsp:useBean id="mgr" class="etc03.BusanThemeMgr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>�λ��׸�����</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
    <div id="wrap">
        <!-- header -->
        <header id="header">
            <!-- nav -->
            <nav id="nav">
                <h3 class="logo">
                    <span>�λ�</span>
                </h3>
            </nav>
        </header>
        <!-- main -->
        <main class="common_wrap" id="theme_detail_page">
            <div id="container">
                <section class="common_box content_box">
                    <div class="common_title theme_title">
                        <h1>�׸� ���� �󼼺���</h1>
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
                                    <li><span class="theme_detail_label">����:</span> <%= theme.getGugunNm() %></li>
                                    <li><span class="theme_detail_label">ī�װ�:</span> <%= theme.getCate2Nm() %></li>
                                    <li><span class="theme_detail_label">��ġ:</span> <%= theme.getPlace() %></li>
                                    <li><span class="theme_detail_label">�ּ�:</span> <%= theme.getAddr1() %></li>
                                    <li><span class="theme_detail_label">Ȩ������:</span> <a href="<%= theme.getHomepageUrl() != null ? theme.getHomepageUrl() : "#" %>" target="_blank"><%= theme.getHomepageUrl() != null ? theme.getHomepageUrl() : "Ȩ������ ����" %></a></li>
                                    <li><span class="theme_detail_label">���� ����:</span> <span class="theme_detail_textarea"><%= theme.getTrfcInfo() != null ? theme.getTrfcInfo() : "���� ���� ����" %></span></li>
                                    <li><span class="theme_detail_label">�� ����:</span> <span class="theme_detail_textarea"><%= theme.getItemcntnts() != null ? theme.getItemcntnts() : "�� ���� ����" %></span></li>
                                </ul>
                            </div>
                        </div>
                        <div class="action_btn">
                            <button onclick="window.history.back()">������� ���ư���</button>
                        </div>
                        <%} else {%>
                        <p>�ش� �׸� ���� ������ ã�� �� �����ϴ�.</p>
                        <%}%>
                    </div>
                </section>
            </div>
        </main>
    </div>
</body>
</html>