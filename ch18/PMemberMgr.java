package ch18;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ch19.DBConnectionMgr;

public class PMemberMgr {
	
	private DBConnectionMgr pool;
	private static final String  SAVEFOLDER = "C:/Jsp/myapp/src/main/webapp/ch18/photo/";
	private static final String ENCTYPE = "EUC-KR";
	private static int MAXSIZE = 5*1024*1024;

	public PMemberMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// PMember Login
	public boolean loginPMember(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tblPMember where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}

	// PMember Get
	public PMemberBean getPMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PMemberBean bean = new PMemberBean();
		try {
			con = pool.getConnection();
			sql = "select name, pwd ,profile from tblPMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setId(id);
				bean.setName(rs.getString(1));
				bean.setPwd(rs.getString(2));
				bean.setProfile(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}

	// PMember Insert
	public boolean insertPMember(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MultipartRequest multi = null;
		String profile = null;
		boolean flag = false;
		try {
			
			File file = new File(SAVEFOLDER);
			if (!file.exists())
				file.mkdirs();
			multi = new MultipartRequest(req, SAVEFOLDER,MAXSIZE, ENCTYPE,
					new DefaultFileRenamePolicy());
			profile = multi.getFilesystemName("profile");
			con = pool.getConnection();
			sql = "insert tblPMember values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("id"));
			pstmt.setString(2, multi.getParameter("pwd"));
			pstmt.setString(3, multi.getParameter("name"));
			pstmt.setString(4, profile);
			if(pstmt.executeUpdate()==1) 
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	
	public void updatePMember(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MultipartRequest multi = null;
		String profile = null;
		try {
			multi = new MultipartRequest(req, SAVEFOLDER,MAXSIZE, ENCTYPE,
					new DefaultFileRenamePolicy());
			profile = multi.getFilesystemName("profile");
			con = pool.getConnection();
			if(profile!=null&&!profile.equals("")) {
				sql = "update tblPMember set pwd = ?, name = ?, profile = ? where id =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, multi.getParameter("pwd"));
				pstmt.setString(2, multi.getParameter("name"));
				pstmt.setString(3, profile);
				pstmt.setString(4, multi.getParameter("id"));
			}else {
				sql = "update tblPMember set pwd = ?, name = ? where id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, multi.getParameter("pwd"));
				pstmt.setString(2, multi.getParameter("name"));
				pstmt.setString(3, multi.getParameter("id"));
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
}
