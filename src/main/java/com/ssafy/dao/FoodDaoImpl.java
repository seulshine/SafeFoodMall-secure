package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.service.FoodService;
import com.ssafy.service.FoodServiceImpl;
import com.ssafy.util.DBUtil;
import com.ssafy.util.FoodNutritionSAXHandler;
import com.ssafy.util.FoodSAXHandler;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.util.MyBatisUtil;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.SafeFoodException;

public class FoodDaoImpl implements FoodDao {

	private static FoodDao dao = new FoodDaoImpl();

	public static FoodDao getDao() {
		return dao;
	}

	private FoodDaoImpl() {
		loadData();
	}

	DBUtil util = DBUtil.getUtil();
	private List<Food> foods = null;
	private final String namespace = "com.ssafy.mapper.UserMapper.";
	private final String foodnamespace = "com.ssafy.mapper.FoodMapper.";
	
	public List<Food> getList(){
		return foods;
	}
	
	/**
	 * 식품 영양학 정보와 식품 정보를 xml 파일에서 읽어온다.
	 */
	public void loadData() {
		// FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
        FoodSaxParser parser = new FoodSaxParser();
        foods = parser.getFoods();
        System.out.println("가나다라마바사박준성");
        // 가져온 Food 리스트 데이터를 DB에 저장한다.
        SqlSession session = MyBatisUtil.getUtil().getSession();
        for (Food food : foods) {
            System.out.println(food);
            insertAllFood(session, food);
        }
        session.commit();
		
//		// FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
//		FoodSaxParser parser = new FoodSaxParser();
//		foods = parser.getFoods();
//
//		// 가져온 Food 리스트 데이터를 DB에 저장한다.
//		try {
//			Connection con = util.getConnection();
//			for (Food food : foods) {
//				System.out.println(food);
//				insertAllFood(con, food);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	private void insertAllFood(SqlSession session, Food food){
		String stmt = foodnamespace + "insertFood";
        session.insert(stmt, food);
		
//		String sql = "insert into food values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		PreparedStatement pstmt = null;
//		try {
//			con.setAutoCommit(false);
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, food.getCode());
//			pstmt.setString(2, food.getName());
//			pstmt.setDouble(3, food.getSupportpereat());
//			pstmt.setDouble(4, food.getCalory());
//			pstmt.setDouble(5, food.getCarbo());
//			pstmt.setDouble(6, food.getProtein());
//			pstmt.setDouble(7, food.getFat());
//			pstmt.setDouble(8, food.getSugar());
//			pstmt.setDouble(9, food.getNatrium());
//			pstmt.setDouble(10, food.getChole());
//			pstmt.setDouble(11, food.getFattyacid());
//			pstmt.setDouble(12, food.getTransfat());
//			pstmt.setString(13, food.getMaker());
//			pstmt.setString(14, food.getMaterial());
//			pstmt.setString(15, food.getImg());
//			pstmt.setString(16, food.getAllergy());
//			pstmt.executeUpdate();
//			con.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			util.rollback(con);
//		} 
//		finally {
//			util.close(pstmt);
//		}
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. web에서 구현할 내용. web에서 페이징 처리시
	 * 필요
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 개수
	 */

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. web에서 구현할 내용. web에서 페이징 처리시
	 * 필요
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 개수
	 */
	public int foodCount(FoodPageBean bean) {

		// 구현하세요.
		String key = bean.getKey(); // name, maker, material
		String word = bean.getWord();
		String sql = null;
		if (key.equals("name")) {
			sql = "select * from food where name = ? ";
		} else if (key.equals("maker")) {
			sql = "select * from food where maker = ? ";
		} else { // key.equals("material")
			sql = "select * from food where material = ? ";
		}

		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = util.getConnection();
			pstmt = null;
			rset = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, word);
			rset = pstmt.executeQuery();
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rset);
			util.close(pstmt);
		}

		return cnt;
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를 검색해서 반환.
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 * @throws SQLException
	 */
	public List<Food> searchAll(FoodPageBean bean) {
		List<Food> finds = new LinkedList<Food>();
		if (bean != null) {
			Connection con = null;
			try {
				con = util.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			String key = bean.getKey();
			String word = bean.getWord();

			String sql;

			if (!key.equals("all") && word != null && !word.trim().equals("")) {

				// 구현 하세요.
				if (key.equals("name")) {
					sql = "select * from food where locate (?, name)";
				} else if (key.equals("maker")) {
					sql = "select * from food where locate (?, maker) ";
				} else { // key.equals("material")
					sql = "select * from food where locate (?, material) ";
				}

				PreparedStatement pstmt = null;
				ResultSet rset = null;

				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, word);

					rset = pstmt.executeQuery();

					while (rset.next()) {
						Food food = new Food();
						food.setCode(rset.getInt(1));
						food.setName(rset.getString(2));
						food.setSupportpereat(rset.getDouble(3));
						food.setCalory(rset.getDouble(4));
						food.setCarbo(rset.getDouble(5));
						food.setProtein(rset.getDouble(6));
						food.setFat(rset.getDouble(7));
						food.setSugar(rset.getDouble(8));
						food.setNatrium(rset.getDouble(9));
						food.setChole(rset.getDouble(10));
						food.setFattyacid(rset.getDouble(11));
						food.setTransfat(rset.getDouble(12));
						food.setMaker(rset.getString(13));
						food.setMaterial(rset.getString(14));
						food.setImg(rset.getString(15));
						finds.add(food);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					util.close(rset);
					util.close(pstmt);
					util.close(con);
				}

			} else {
				sql = "select * from food";
				PreparedStatement pstmt = null;
				ResultSet rset = null;

				try {
					pstmt = con.prepareStatement(sql);
					rset = pstmt.executeQuery();

					while (rset.next()) {
						Food food = new Food();
						food.setCode(rset.getInt(1));
						food.setName(rset.getString(2));
						food.setSupportpereat(rset.getDouble(3));
						food.setCalory(rset.getDouble(4));
						food.setCarbo(rset.getDouble(5));
						food.setProtein(rset.getDouble(6));
						food.setFat(rset.getDouble(7));
						food.setSugar(rset.getDouble(8));
						food.setNatrium(rset.getDouble(9));
						food.setChole(rset.getDouble(10));
						food.setFattyacid(rset.getDouble(11));
						food.setTransfat(rset.getDouble(12));
						food.setMaker(rset.getString(13));
						food.setMaterial(rset.getString(14));
						food.setImg(rset.getString(15));
						food.setAllergy(rset.getString(16));
						finds.add(food);

					}

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					util.close(rset);
					util.close(pstmt);
					util.close(con);
				}

			}

		}
		return finds;

	}

	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
	 * 
	 * @param code 검색할 식품 코드
	 * @return 식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	public Food search(int code) {
		// 코드에 맞는 식품 검색하여 리턴
		String sql = "select * from food where code = ? ";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Food food = new Food();
		Connection con = null;
		try {
			con = util.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				
				food.setCode(rset.getInt(1));
				food.setName(rset.getString(2));
				food.setSupportpereat(rset.getDouble(3));
				food.setCalory(rset.getDouble(4));

				food.setCarbo(rset.getDouble(5));
				food.setProtein(rset.getDouble(6));
				food.setFat(rset.getDouble(7));
				food.setSugar(rset.getDouble(8));
				food.setNatrium(rset.getDouble(9));
				food.setChole(rset.getDouble(10));
				food.setFattyacid(rset.getDouble(11));
				food.setTransfat(rset.getDouble(12));
				food.setMaker(rset.getString(13));
				food.setMaterial(rset.getString(14));
				food.setImg(rset.getString(15));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rset);
			util.close(pstmt);
			util.close(con);
		}

		return food;
	}

	/**
	 * 가장 많이 검색한 Food 정보 리턴하기 web에서 구현할 내용.
	 * 
	 * @return
	 */
	public List<Food> searchBest() {

		return null;
	}

	public List<Food> searchBestIndex() {

		return null;
	}

	public static void main(String[] args) {
		FoodDaoImpl dao = new FoodDaoImpl();
		dao.loadData();
		System.out.println(dao.search(1));
		System.out.println("===========================material로 검색=================================");
		print(dao.searchAll(new FoodPageBean("material", "감자전분", null, 0)));
		System.out.println("===========================maker로 검색=================================");
		print(dao.searchAll(new FoodPageBean("maker", "빙그레", null, 0)));
		System.out.println("===========================name으로 검색=================================");
		print(dao.searchAll(new FoodPageBean("name", "라면", null, 0)));
		System.out.println("============================================================");
		print(dao.searchAll(null));
		System.out.println("============================================================");
	}

	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}
}