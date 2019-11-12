 package com.sc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.sc.bean.Item;
import com.sc.bean.Page;

 public class GoodsDao {

     Connection conn=null;
     Statement st=null;
     PreparedStatement ps=null;
     ResultSet rs=null;

     public Item getGoodsById(int itemId){
         Item g=null;
         try {
             conn= DBUtil.getConn();//��ȡ����
             //3��ͨ�����ݿ����Ӷ��󣬴�����������
             st=conn.createStatement();
             //4��ʹ�ó�������ִ��sql��䣨��ѯ�������ؽ����
             String sql="select * from t_item where itemId="+itemId;
             rs=st.executeQuery(sql);
             //5�����������е�����
             while(rs!=null&&rs.next()){
                 //ѭ��ȡ��һ�е��е���Ϣ����װ����Ʒ�����������
                 g=new Item(rs.getInt("itemId"),
                         rs.getString("itemName"),
                         rs.getInt("cid"),
                         rs.getString("itemProductor"),
                         rs.getString("itemPhoto"),
                         rs.getString("itemIntro"),
                         rs.getFloat("priceVip"),
                         rs.getFloat("priceNormal"),
                         rs.getInt("itemNum"),
                         rs.getInt("itemTolNum"),
                         rs.getString("itemState"));
             }
         } catch (SQLException e) {
             System.out.println("ͨ����Ʒ��Ż�ȡ��Ʒ����ʧ�ܣ�");
         } finally {
             DBUtil.closeAll(rs, ps, st, conn);
         }
         return g;
     }

     //��ѯ������Ʒ�б�
     public List<Item> selectGoods(){
             List<Item> list=new ArrayList<Item>();
             conn= DBUtil.getConn();
             String sql="select * from t_item";
             try {
                 ps=conn.prepareStatement(sql);
                 rs=ps.executeQuery();
                 //���������е�����
                 while(rs!=null&&rs.next()){
                     //ѭ��ȡ��ÿһ�е��е���Ϣ����װ����Ʒ�����������
                     Item g=new Item(rs.getInt("itemId"),
                             rs.getString("itemName"),
                             rs.getInt("cid"),
                             rs.getString("itemProductor"),
                             rs.getString("itemPhoto"),
                             rs.getString("itemIntro"),
                             rs.getFloat("priceVip"),
                             rs.getFloat("priceNormal"),
                             rs.getInt("itemNum"),
                             rs.getInt("itemTolNum"),
                             rs.getString("itemState"));
                     list.add(g);//����Ʒ������뼯��
                 }
             } catch (SQLException e) {
                 System.out.println("��ѯ������Ʒ�б�ʧ�ܣ�");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
             return list;
         }

     //�����Ʒ
         public void addGoods(Item g){
             conn= DBUtil.getConn();
             String sql="INSERT INTO t_item values(null,?,?,?,?,?,?,?,?,?,?)";
             try {
                 ps=conn.prepareStatement(sql);

                 ps.setString(1, g.getItemName());
                 ps.setInt(2, g.getcid());
                 ps.setString(3, g.getItemProductor());
                 ps.setString(4, g.getItemPhoto());
                 ps.setString(5, g.getItemIntro());
                 ps.setFloat(6, g.getPriceVip());
                 ps.setFloat(7, g.getPriceNormal());
                 ps.setInt(8, g.getItemNum());
                 ps.setInt(9, g.getItemTolNum());
                 ps.setString(10, g.getItemState());
                 ps.execute();
             } catch (SQLException e) {
                 System.out.println("�����Ʒʧ�ܣ�");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
         }

         //ͨ��idɾ������Ʒ
         public void deleteGoodsById(int itemId){
             conn= DBUtil.getConn();
             String sql="delete from t_item where itemId=?";
             try {
                 ps=conn.prepareStatement(sql);
                 ps.setInt(1, itemId);
                 ps.execute();
             } catch (SQLException e) {
                 System.out.println("ͨ��idɾ������Ʒʧ�ܣ�");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
         }

         //�޸���Ʒ
         public void updateGoods(Item g){
             conn= DBUtil.getConn();
             String sql="update t_item set itemName=?,cid=?,itemProductor=?,itemPhoto=?,itemIntro=?"
                      + ",priceVip=?,priceNormal=?,itemNum=?,itemTolNum=?,itemState=? where itemId=?";
             try {
                 ps=conn.prepareStatement(sql);
                 ps.setString(1, g.getItemName());
                 ps.setInt(2, g.getcid());
                 ps.setString(3, g.getItemProductor());
                 ps.setString(4, g.getItemPhoto());
                 ps.setString(5, g.getItemIntro());
                 ps.setFloat(6, g.getPriceVip());
                 ps.setFloat(7, g.getPriceNormal());
                 ps.setInt(8, g.getItemNum());
                 ps.setInt(9, g.getItemTolNum());
                 ps.setString(10, g.getItemState());
                 ps.setInt(11, g.getItemId());
                 ps.execute();
             } catch (SQLException e) {
                 System.out.println("�޸���Ʒʧ�ܣ�");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
         }


         public List<Item> selectGoodsPage(Page p){
             List<Item> list=new ArrayList<Item>();

             conn= DBUtil.getConn();
             String sql="select * from t_item limit ?,?";
             try {
                 ps=conn.prepareStatement(sql);
                 ps.setInt(1, (p.getPageNum()-1)*p.getPageSize());//���ôӵڼ�����ʼ����ȡ����
                 ps.setInt(2, p.getPageSize());//����ÿҳ��ʾ����
                 rs=ps.executeQuery();
                 //���������е�����
                 while(rs!=null&&rs.next()){
                     //ѭ��ȡ��ÿһ�е��е���Ϣ����װ����Ʒ�����������
                     Item g=new Item(rs.getInt("itemId"),
                             rs.getString("itemName"),
                             rs.getInt("cid"),
                             rs.getString("itemProductor"),
                             rs.getString("itemPhoto"),
                             rs.getString("itemIntro"),
                             rs.getFloat("priceVip"),
                             rs.getFloat("priceNormal"),
                             rs.getInt("itemNum"),
                             rs.getInt("itemTolNum"),
                             rs.getString("itemState"));
                     list.add(g);//����Ʒ������뼯��
                 }
             } catch (SQLException e) {
                 System.out.println("��ҳ��ѯ��Ʒ�б�ʧ�ܣ�");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }

             return list;
         }

     //��ѯ��Ʒ������--��ҳ
     public int selectGoodsCount(){
         int count=0;
         conn= DBUtil.getConn();
         String sql="select count(*) from t_item";
         try {
             ps=conn.prepareStatement(sql);
             rs=ps.executeQuery();
             //���������е�����
             while(rs!=null&&rs.next()){
                 count=rs.getInt(1);
             }
         } catch (SQLException e) {
             System.out.println("��ѯ��Ʒ������ʧ�ܣ�");
         } finally {
             DBUtil.closeAll(rs, ps, st, conn);
         }
         return count;

     }
 }
