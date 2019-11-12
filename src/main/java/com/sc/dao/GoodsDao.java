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
             conn= DBUtil.getConn();//获取连接
             //3、通过数据库连接对象，创建陈述对象
             st=conn.createStatement();
             //4、使用陈述对象，执行sql语句（查询），返回结果集
             String sql="select * from t_item where itemId="+itemId;
             rs=st.executeQuery(sql);
             //5、处理结果集中的数据
             while(rs!=null&&rs.next()){
                 //循环取出一行的列的信息，封装到商品对象的属性中
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
             System.out.println("通过商品编号获取商品对象失败！");
         } finally {
             DBUtil.closeAll(rs, ps, st, conn);
         }
         return g;
     }

     //查询所有商品列表
     public List<Item> selectGoods(){
             List<Item> list=new ArrayList<Item>();
             conn= DBUtil.getConn();
             String sql="select * from t_item";
             try {
                 ps=conn.prepareStatement(sql);
                 rs=ps.executeQuery();
                 //处理结果集中的数据
                 while(rs!=null&&rs.next()){
                     //循环取出每一行的列的信息，封装到商品对象的属性中
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
                     list.add(g);//把商品对象存入集合
                 }
             } catch (SQLException e) {
                 System.out.println("查询所有商品列表失败！");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
             return list;
         }

     //添加商品
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
                 System.out.println("添加商品失败！");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
         }

         //通过id删除该商品
         public void deleteGoodsById(int itemId){
             conn= DBUtil.getConn();
             String sql="delete from t_item where itemId=?";
             try {
                 ps=conn.prepareStatement(sql);
                 ps.setInt(1, itemId);
                 ps.execute();
             } catch (SQLException e) {
                 System.out.println("通过id删除该商品失败！");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }
         }

         //修改商品
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
                 System.out.println("修改商品失败！");
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
                 ps.setInt(1, (p.getPageNum()-1)*p.getPageSize());//设置从第几条开始向下取数据
                 ps.setInt(2, p.getPageSize());//设置每页显示条数
                 rs=ps.executeQuery();
                 //处理结果集中的数据
                 while(rs!=null&&rs.next()){
                     //循环取出每一行的列的信息，封装到商品对象的属性中
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
                     list.add(g);//把商品对象存入集合
                 }
             } catch (SQLException e) {
                 System.out.println("分页查询商品列表失败！");
             } finally {
                 DBUtil.closeAll(rs, ps, st, conn);
             }

             return list;
         }

     //查询商品总条数--分页
     public int selectGoodsCount(){
         int count=0;
         conn= DBUtil.getConn();
         String sql="select count(*) from t_item";
         try {
             ps=conn.prepareStatement(sql);
             rs=ps.executeQuery();
             //处理结果集中的数据
             while(rs!=null&&rs.next()){
                 count=rs.getInt(1);
             }
         } catch (SQLException e) {
             System.out.println("查询商品总条数失败！");
         } finally {
             DBUtil.closeAll(rs, ps, st, conn);
         }
         return count;

     }
 }
