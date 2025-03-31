<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.util.Vector" %>
<%@ page import="etc03.BusanThemeMgr" %>
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
    <!-- wrap -->
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
        <main class="common_wrap" id="theme_list_page">
            <div id="container">
                <section class="common_box content_box">
                    <div class="common_title theme_title">
                        <h1>테마 여행</h1>
                    </div>
                    <!-- 테마 여행 목록 -->
                    <div class="theme_list_area">
                        <%
                            int currentPage = 1;
                            if(request.getParameter("page") != null) {
                                currentPage = Integer.parseInt(request.getParameter("page"));
                            }
                            int perPage = 6;
                            
                            Vector<BusanThemeBean> vlist = mgr.listBusanTheme(currentPage, perPage);
                            for (int i = 0; i < vlist.size(); i++) {
                                BusanThemeBean theme = vlist.get(i);
                        %>
                        <ul class="theme_item">
                            <ul class="theme_num">
                                <li><%= theme.getCate2Nm() %></li>
                                <li><%= theme.getGugunNm() %></li>
                            </ul>
                            <div class="theme_img">
                            	<a href="detail.jsp?ucSeq=<%= theme.getUcSeq() %>">
                                	<img src="<%= theme.getMainImgThumb() %>" alt="<%= theme.getMainTitle() %>">
                               	</a>
                            </div>
                            <div class="theme_article">
                                <div>
                                    <%= theme.getMainTitle() %> (<%= theme.getPlace() %>)
                                </div>
                            </div>
                        </ul>
                        <%
                            } // end for
                        %>
                    </div>
                    <!-- 동적 페이징 처리 시작 -->
                    <%
                        int totalRecord = mgr.getTotalCount();
                        int totalPage = (int)Math.ceil((double)totalRecord / perPage);
                        int pageBlock = 5;
                        int nowBlock = (int)Math.ceil((double)currentPage / pageBlock);
                        int pageStart = (nowBlock - 1) * pageBlock + 1;
                        int pageEnd = pageStart + pageBlock - 1;
                        if(pageEnd > totalPage) {
                            pageEnd = totalPage;
                        }
                    %>
                    <ul class="theme_pagination">
                        <% if(currentPage > 1) { %>
                        <li class="prev">
                            <a href="list.jsp?page=<%= currentPage - 1 %>"><</a>
                        </li>
                        <% } else { %>
                        <li class="prev"><</li>
                        <% } %>
                        <% for(int j = pageStart; j <= pageEnd; j++) {
                               if(j == currentPage) { %>
                        <li class="page_num active">
                            <span><%= j %></span>
                        </li>
                        <% } else { %>
                        <li class="page_num">
                            <a href="list.jsp?page=<%= j %>"><%= j %></a>
                        </li>
                        <%     }
                           } %>
                        <% if(currentPage < totalPage) { %>
                        <li class="next">
                            <a href="list.jsp?page=<%= currentPage + 1 %>">></a>
                        </li>
                        <% } else { %>
                        <li class="next">></li>
                        <% } %>
                    </ul>
                    <!-- 동적 페이징 처리 끝 -->
                </section>
            </div>
        </main>
    </div>
</body>
</html>