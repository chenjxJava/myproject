package com.scm.test;

import java.sql.SQLException;
import java.util.List;

import com.freemark.domain.Table;
import com.freemark.utils.JDBCUtils;

/**
 * Created by admin on 2017-07-14.
 */
public class DataMetaDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		List<Table> tablesBy = JDBCUtils.getTablesBy(JDBCUtils.getConnection());
		for (Table table : tablesBy) {
			System.out.println(table);
		}
	}
}
