package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.*;
import javax.naming.*;

import common.Const;

public class BaseService {
	public Connection con;
	
	
	private String dataSourceName=Const.DATA_SOURCE;
	
	public BaseService() 
	{
		try {
			initConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection initConnection() throws NamingException,SQLException
	{
		Context ctx=null;
		DataSource ds=null;
		ctx=new InitialContext();
		ds=(DataSource)ctx.lookup(this.dataSourceName);
		con=ds.getConnection();
		return con;
	}
	
	public void closeConnection() {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeRs(ResultSet rs)
	{
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeStatement(Statement stmt)
	{
		try {
			if(stmt!=null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException
	{
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt;
	}
	
	public PreparedStatement setParams(PreparedStatement pstmt,Object [] params) throws SQLException
	{
		for(int i=0;i<params.length;i++)
		{
			pstmt.setObject(i+1, params[i]);
		}
		return pstmt;
	}
	
	public PreparedStatement setParams(String  sql,Object [] params) throws SQLException
	{
		PreparedStatement pstmt=this.con.prepareStatement(sql);
		for(int i=0;i<params.length;i++)
		{
			pstmt.setObject(i+1, params[i]);
		}
		return pstmt;
	}
	
	public int update(PreparedStatement pstmt, Object [] params) throws SQLException
	{
		int recCount=0;
		try
		{
			this.setParams(pstmt, params);
			recCount=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return recCount;
	}
	
	public int update(String sql,Object [] params)
	{

		int recCount=0;
		PreparedStatement pstmt=null;
		try
		{
			pstmt=this.setParams(sql, params);
			recCount=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeStatement(pstmt);
		}
		return recCount;
	}
	
	public int update(String sql)
	{
		int recCount=0;
		Statement stmt=null;
		try
		{
			stmt=this.con.createStatement();
			recCount=stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeStatement(stmt);
		}
		return recCount;
	}
	
	private List <Map> getListFromRS(ResultSet rs) throws SQLException
	{
		List<Map> list=new ArrayList<Map>();
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		while(rs.next())
		{
			Map m=new HashMap();
			
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				String colName=rsmd.getColumnName(i);
				
				m.put(colName, rs.getObject(i));
			}
			list.add(m);
		}
		
		return list;
	}
	
	public List<Map> getList(String sql,Object [] params)
	{
		List<Map> list=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=this.setParams(sql, params);
			rs=pstmt.executeQuery();
			list=this.getListFromRS(rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.closeRs(rs);
			this.closeStatement(pstmt);
		}
		return list;
	}
	
	
	public List<Map> getList(String sql)
	{
		List<Map> list=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			stmt=this.con.createStatement();
			rs=stmt.executeQuery(sql);
			list=this.getListFromRS(rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.closeRs(rs);
			this.closeStatement(stmt);
		}
		return list;
		
	}
	
	
	private Map getSingleRowFromRS(ResultSet rs)
	{
		Map m=null;
		
		try {
			if (rs.next()) {

				m = new HashMap();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String colName = rsmd.getColumnName(i);

					m.put(colName, rs.getObject(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Map getSingleRow(String sql, Object[] params) {
		Map m = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = this.setParams(sql, params);
			rs = pstmt.executeQuery();
			m = this.getSingleRowFromRS(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closeStatement(pstmt);
		}
		return m;
	}
	
	public Map getSingleRow(String sql) {
		Map m = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(sql);
			m = this.getSingleRowFromRS(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closeStatement(stmt);
		}
		return m;
	}
	
	public int getInt(String sql,Object [] params)
	{
		int i=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=this.setParams(sql, params);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				i=rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeRs(rs);
			closeStatement(pstmt);
		}
		return  i;
	}
	public int getInt(String sql)
	{
		int i=0;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			stmt=this.con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				i=rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeRs(rs);
			closeStatement(stmt);
		}
		return  i;
	}

	public int getPageCount(String sql,int pageRecNum)
	{
		String countSql="select count('1') cnt from ("+sql+ ")";
		int rowCount=this.getInt(countSql);
		int pageCount=rowCount/pageRecNum;
		
		if(rowCount%pageRecNum!=0)
		{
			pageCount++;
		}
		return pageCount;
	}
	public int getPageCount(String sql,Object [] params,int pageRecNum)
	{
		String countSql="select count('1') cnt from ("+sql+ ")";
		int rowCount=this.getInt(countSql,params);
		int pageCount=rowCount/pageRecNum;
		
		if(rowCount%pageRecNum!=0)
		{
			pageCount++;
		}
		return pageCount;
	}
	
	public List getPage(String sql,Object [] params,int curPage,int pageRecNum)
	{
	
		int startRecRn,endRecRn;
		startRecRn=(curPage-1)*pageRecNum+1;
		endRecRn=curPage*pageRecNum;
		
		
		String rnSql= "(" + sql +")  A ";
		rnSql="select A.*,rownum rn from "+rnSql +" where rownum<="+endRecRn;
		rnSql="select * from (" + rnSql+") where rn>="+startRecRn;
		
		List list=null;
		list=this.getList(rnSql,params);
		return list;
	}
	public List getPage(String sql,int curPage,int pageRecNum)
	{
	
		int startRecRn,endRecRn;
		startRecRn=(curPage-1)*pageRecNum+1;
		endRecRn=curPage*pageRecNum;
		
		
		String rnSql= "(" + sql +")  A ";
		rnSql="select A.*,rownum rn from "+rnSql +" where rownum<="+endRecRn;
		rnSql="select * from (" + rnSql+") where rn>="+startRecRn;
		
		List list=null;
		list=this.getList(rnSql);
		return list;
	}
}
