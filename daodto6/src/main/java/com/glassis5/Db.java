package com.glassis5;

public class Db {
	// MySQL JDBC 드라이버의 패키지 경로 (MySQL 연결 시 사용)
	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";

	// 오라클 데이터베이스 연결 시 사용할 드라이버 패키지 경로 (주석 처리된 상태)
	// static private String DB_JDBC_DRIVER_PACKAGE_PATH =
	// "oracle.jdbc.OracleDriver";

	// 데이터베이스 이름
	static private String DB_NAME = "my_cat";

	// MySQL 데이터베이스 URL
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/" + DB_NAME;

	// 오라클 데이터베이스 URL (주석 처리된 상태)
	// static private String DB_URL_ORACLE = "jdbc:oracle:thin:@127.0.0.1:1521:" +
	// DB_NAME;

	// 현재 사용할 데이터베이스 URL (MySQL 사용 시 설정)
	static public String DB_URL = DB_URL_MYSQL;

	// 데이터베이스 사용자 ID
	static public String DB_ID = "root";

	// 데이터베이스 사용자 비밀번호
	static public String DB_PW = "root";

	/* 테이블 관련 상수 */

	// 게시판 테이블 (자유게시판)
	public static final String TABLE_PS_BOARD_FREE = "PS_BOARD_FREE";

	// 추가적인 테이블 정의 (주석 처리된 상태)
	// public static final String TABLE_PLAYER = "FT_INS_PLAYER"; // 플레이어 테이블
	// public static final String TABLE_CITY = "FT_INS_CITY"; // 도시 테이블
	// public static final String TABLE_GOODS = "FT_GOODS"; // 물품 테이블
	// public static final String TABLE_SHIP_CARGO = "FT_INS_SHIP_CARGO"; // 선박 화물
	// 테이블

	// 회원 테이블 (주석 처리된 상태)
	// public static final String TABLE_PS_MEMBER = "PS_MEMBER"; // 회원 테이블
}
