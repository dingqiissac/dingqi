package com.atguigu.userdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.utils.JDBCUtils;



/**
 * 灏佽瀵规暟鎹簱鏁版嵁鎿嶄綔鐨勫熀鏈柟娉�
 * 
 *
 */
public class BaseDao {
	//鍒涘缓QueryRunner瀵硅薄
	private QueryRunner runner = new QueryRunner();
	
	/**
	 * 澧炲垹鏀规柟娉�
	 * 	- 鍑℃槸涓嶈兘纭畾鐨勬暟鎹兘鏄敤鍙傛暟浼犻��
	 */
	public int update(String sql , Object...params) {
		Connection conn = JDBCUtils.getConn();
		int i = 0;
		try {
			i = runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//閲婃斁鏁版嵁搴撹繛鎺�
			JDBCUtils.closeConn(conn);
		}
		// 濡傛灉i>0浠ｈ〃澧炲垹鏀规垚鍔燂紝<=0浠ｈ〃澶辫触
		return i;
	}
	/**
	 * 鏌ヨ涓�鏉¤褰� 灏佽涓轰竴涓璞�
	 */
	public <T>T getBean(Class<T> type, String sql , Object...params) {
		Connection conn = JDBCUtils.getConn();
		T t = null;
		// 鍙傛暟1锛氭暟鎹簱杩炴帴 锛� 鍙傛暟2锛歴ql璇彞 锛� 鍙傛暟4锛歴ql璇彞鍗犱綅绗﹀弬鏁板垪琛� 锛� 鍙傛暟3锛氭煡璇㈢粨鏋滆В鏋愬伐鍏风被瀵硅薄[type灏辨槸璁叉煡璇㈠埌璁板綍灏佽瀵硅薄鐨勭被鍨�  ]
		try {
			t = runner.query(conn, sql, new BeanHandler<>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConn(conn);
		}
		//濡傛灉t==null浠ｈ〃鏌ヨ澶辫触 锛� 濡傛灉涓嶄负null浠ｈ〃鏌ヨ鎴愬姛
		return t;
	}
	/**
	 * 鏌ヨ澶氭潯璁板綍灏佽涓哄璞＄殑闆嗗悎
	 */
	public <T>List<T> getBeanList(Class<T> type , String sql , Object...params) {
		Connection conn = JDBCUtils.getConn();
		List<T> list = null;
		try {
			list = runner.query(conn, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConn(conn);
		}
		return list;
	}
	/**
	 * 鏌ヨ绗竴琛岀涓�鍒楃殑鏁版嵁灏佽涓篛bject
	 */
	public Object getScalar(String sql , Object...params) {
		Connection conn = JDBCUtils.getConn();
		Object object = null;
		try {
			//鏌ヨ绗竴琛岀涓�鍒楃殑鏁版嵁骞舵彁鍗囦负Object瀵硅薄杩斿洖
			object = runner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConn(conn);
		}
		return object;
	}
	/**
	 * 鎵归噺澧炲垹鏀圭殑鏂规硶
	 * @param sql
	 * @param params
	 */
	public void batchUpdate(String sql , Object[][] params) {
		Connection conn = JDBCUtils.getConn();
		//鍙傛暟1锛氭暟鎹簱杩炴帴锛� 鍙傛暟2锛氭壒澶勭悊鎵ц鐨剆ql璇彞 锛� 鍙傛暟3锛氫簩缁存暟缁刐绗竴缁� 鎵瑰鐞嗘墽琛岀殑娆℃暟 锛� 绗簩缁存瘡娆℃墽琛屾壒澶勭悊鏃秙ql闇�瑕佺殑鍙傛暟鍒楄〃]
		try {
			runner.batch(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConn(conn);
		}
	}
	
}
