package etc03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BusanThemeMgr {

    private DBConnectionMgr pool;

    public BusanThemeMgr() {
    	pool = DBConnectionMgr.getInstance();
    }

    // 페이징 처리된 목록 조회
    public Vector<BusanThemeBean> listBusanTheme(int page, int perPage) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        Vector<BusanThemeBean> vlist = new Vector<BusanThemeBean>();
        try {
            con = pool.getConnection();
            sql = "SELECT * FROM tblBusanTheme LIMIT ?, ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, (page - 1) * perPage);
            pstmt.setInt(2, perPage);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BusanThemeBean theme = new BusanThemeBean();
                theme.setUcSeq(rs.getInt("uc_seq"));
                theme.setMainTitle(rs.getString("main_title"));
                theme.setGugunNm(rs.getString("gugun_nm"));
                theme.setCate2Nm(rs.getString("cate2_nm"));
                theme.setPlace(rs.getString("place"));
                theme.setMainImgThumb(rs.getString("main_img_thumb"));
                vlist.addElement(theme);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return vlist;
    }
    
    public int getTotalCount() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tblBusanTheme";
        try {
            con = pool.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return total;
    }
    
    public BusanThemeBean getBusanThemeDetail(int ucSeq) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BusanThemeBean theme = null;
        String sql = "SELECT * FROM tblBusanTheme WHERE uc_seq = ?";
        try {
            con = pool.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ucSeq);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                theme = new BusanThemeBean();
                theme.setUcSeq(rs.getInt("uc_seq"));
                theme.setMainTitle(rs.getString("main_title"));
                theme.setGugunNm(rs.getString("gugun_nm"));
                theme.setCate2Nm(rs.getString("cate2_nm"));
                theme.setPlace(rs.getString("place"));
                theme.setMainImgThumb(rs.getString("main_img_thumb"));
                theme.setSubtitle(rs.getString("subtitle")); 
                theme.setAddr1(rs.getString("addr1"));
                theme.setHomepageUrl(rs.getString("homepage_url"));
                theme.setTrfcInfo(rs.getString("trfc_info"));
                theme.setMainImgNormal(rs.getString("main_img_normal")); // 상세 이미지
                theme.setItemcntnts(rs.getString("itemcntnts")); // 상세 설명
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return theme;
    }
}
