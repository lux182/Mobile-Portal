package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Item;
import util.DBHelper;

//��Ʒ��ҵ���߼���
public class DaoItem {
	//������е���Ʒ��Ϣ
	public ArrayList<Item> getAllItems(){
		Connection con=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		ArrayList<Item> list=new ArrayList<Item>();
		
		try {
			con=DBHelper.getConnection();
			String sql="select * from items";		
			pre=con.prepareStatement(sql);
			res=pre.executeQuery();
			
			while(res.next()){
			Item item=new Item();
			item.setId(res.getInt("id"));
			item.setName(res.getString("name"));
			item.setCity(res.getString("city"));
			item.setPrice(res.getInt("price"));
			item.setNumber(res.getInt("number"));
			item.setPicture(res.getString("picture"));
			list.add(item);
			}	
			return list;					
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			//�ͷ����ݼ�����
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res=null;
			}			
			//�ͷ�������
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pre=null;
			}
		}
		
	}
	
	//������ƷID��ȡ��Ʒ����
	public Item getItemById(int id){
		Connection con=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		try {
			con=DBHelper.getConnection();
			String sql="select * from items where Id=?";		
			pre=con.prepareStatement(sql);
			pre.setInt(1,id );
			res=pre.executeQuery();
			
			if(res.next()){
				Item item=new Item();
				item.setId(res.getInt("id"));
				item.setName(res.getString("name"));
				item.setCity(res.getString("city"));
				item.setPrice(res.getInt("price"));
				item.setNumber(res.getInt("number"));
				item.setPicture(res.getString("picture"));
				return item;
			}					
			else{
				return null;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			//�ͷ����ݼ�����
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res=null;
			}			
			//�ͷ�������
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pre=null;
			}
		}
	}
}

