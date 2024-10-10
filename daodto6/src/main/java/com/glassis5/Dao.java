package com.glassis5;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao extends Da {

	// (1/5) 글삭제
	// 게시글 번호에 해당하는 글을 삭제합니다.
	public void del(String no) { // 게시글에 '해당하는 번호(no) 삭제해야하므로 String no를 씀'
		connect(); // 데이터베이스 연결, connect or super.connect 로 입력
		String sql = String.format("DELETE FROM %s WHERE b_no=%s", Db.TABLE_PS_BOARD_FREE, no);
		super.update(sql); // SQL 실행
		super.close(); // 데이터베이스 연결 종료
	}

	// (2/5) 글쓰기
	// 게시글을 작성하고 데이터베이스에 저장합니다.
	public void write(Dto d) { // title, id, text를 불러와서 저장해야함
		connect(); // 데이터베이스 연결, connect or super.connect 로 입력
		String sql = String.format("INSERT INTO %S (b_title, b_id, b_text) VALUES ('%s', '%s', '%s')",
				Db.TABLE_PS_BOARD_FREE, d.title, d.id, d.text); // title, id, text를 불러옴
		super.update(sql); // SQL 실행
		super.close(); // 데이터베이스 연결종료
	}

	// (3/5) 글읽기
	// 게시글 번호에 해당하는 글을 읽어 반환합니다.
	public Dto read(String no) { // 게시글 번호에 해당하는 no를 읽어 반환 (no로 해야함)
		connect(); // 데이터베이스 연결, connect or super.connect 로 입력
		Dto post = null;
		try {
			String sql = String.format("SELECT * FROM %s WHERE b_no=%s", Db.TABLE_PS_BOARD_FREE, no);
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // 결과 가져오기
			post = new Dto(rs.getString("B_NO"), rs.getString("B_TITLE"), rs.getString("B_ID"),
					rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI"));
		} catch (Exception e) {
			e.printStackTrace(); // 오류 시 스택출력
		}
		super.close(); // 데이터베이스 연결종료
		return post; // 읽은 게시물 반환
	}

	// (4/5) 리스트 가져오기 (페이지없이 전체)
	// 전체 게시물을 리스트로 반환합니다.
	public ArrayList<Dto> list() {
		connect(); // 데이터베이스 연결, connect or super.connect
		ArrayList<Dto> posts = new ArrayList<>(); // 리스트 가져오기
		try {
			String sql = String.format("SELECT * FROM %s", Db.TABLE_PS_BOARD_FREE);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				posts.add(new Dto(rs.getString("B_NO"), rs.getString("B_TITLE"), rs.getString("B_ID"),
						rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}

		} catch (Exception e) {
			e.printStackTrace(); // 오류시 스택출력
		}
		super.close(); // 데이터베이스 연결종료
		return posts; // 게시물 리스트 반환
	}

	// (5/5) 글 수정
	// 특정 게시글을 수정합니다.
	public void edit(Dto d, String no) { // 특정 게시물의 no를 불러와 수정해야함
		connect(); // 데이터베이스 연결 , connect or super.connect
		String sql = String.format("UPDATE %s SET b_title='%s' WHERE b_no=%s", Db.TABLE_PS_BOARD_FREE, d.title, d.text,
				no);
		super.update(sql); // SQL실행
		super.close(); // 데이터베이스 연결종료
	}

	// 총 글 수 구하기
	// 총 게시물을 반환합니다.
	public int getPostCount() {
		int count = 0;
		connect(); // 데이터베이스 연결, connect 혹은 super.connect 입력
		try {
			String sql = String.format("SELECT COUNT * FROM %s", Db.TABLE_PS_BOARD_FREE);
			ResultSet rs = st.executeQuery(sql);
			rs.next();// 결과 가져오기
			count = rs.getInt("COUNT(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return count;
	}

	// 검색어를 사용한 총 글 수 구하기
	// 검색어에 해당하는 게시글 리스트를 페이지단위로 반환합니다.
	public int getSearchPostCount(String word) { // 검색될 단어 = word
		int count = 0; // 검색될 글 수
		connect(); // 데이터베이스 연결 = connect or super.connect
		try {
			String sql = String.format("SELECT COUNT(*) FROM %s WHERE b_title LIKE '%%%s%%'", Db.TABLE_PS_BOARD_FREE,
					word);
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // 결과 가져오기
			count = rs.getInt("COUNT(*)");
		} catch (Exception e) {
			e.printStackTrace(); // 오류시 스택출력
		}
		super.close(); // 데이터베이스 연결종료
		return count; // 검색된 글 수반환
	}

	// 검색어를 사용한 글 리스트 가져오기
	// 검색어에 해당하는 게시글 리스트를 페이지 단위로 반환합니다.
	public ArrayList<Dto> listSearch(String word, String page) {
		connect(); // 데이터베이스 연결 = connect or super.connect
		ArrayList<Dto> posts = new ArrayList<>();
		try {

			int startIndex = (Integer.parseInt(page) - 1) * Board.LIST_AMOUNT;
			String sql = String.format("SELECT * FROM %s WHERE b_title LIKE '%%%s%%' LIMIT %s, %s",
					Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.LIST_AMOUNT);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				posts.add(new Dto(rs.getString("B_NO"), rs.getString("B_TITLE"), rs.getString("B_ID"),
						rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close(); // 데이터베이스 연결종료
		return posts; // 검색된 글 반환
	}

	// 총 페이지 수 구하기
	// 총 페이지 수를 반환합니다.
	public int getTotalPageCount() {
		int totalPageCount = 0;
		int count = getPostCount(); // 총 글 수 가져오기
		if (count % Board.LIST_AMOUNT == 0) {
			// 딱 맞게 나누어 떨어질 때
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			// 남는 페이지가 있을 때
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		// 총 페이지 수 반환
		return totalPageCount;
	}

	// 검색어를 사용한 총 페이지 수 구하기
	// 검색된 결과의 총 페이지 수를 반환합니다.
	public int getSearchTotalPageCount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostCount(word);
		if (count % Board.LIST_AMOUNT == 0) {
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
}
