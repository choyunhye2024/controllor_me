package com.glassis5;

// Dto 클래스는 데이터베이스의 게시물 정보를 담는 객체로 사용됩니다.
public class Dto {
	// 필드들: 게시물의 다양한 정보를 저장
	public String no; // 게시물 번호
	public String title; // 게시물 제목
	public String id; // 작성자 ID
	public String datetime; // 작성 일자 및 시간
	public String hit; // 조회수
	public String text; // 게시물 내용
	public String replyCount; // 댓글 수
	public String replyOri; // 원본 댓글 번호 (대댓글의 경우 사용)

	// 생성자: 새로운 게시물을 작성할 때 사용
	// 게시물 제목, 작성자 ID, 게시물 내용만 전달받아 초기화
	public Dto(String title, String id, String text) {
		this.title = title; // 게시물 제목
		this.id = id; // 작성자 ID
		this.text = text; // 게시물 내용
	}

	// 생성자: 게시물의 모든 정보를 저장할 때 사용
	// 게시물 번호, 제목, 작성자 ID, 작성 시간, 조회수, 내용, 댓글 수, 원본 댓글 번호를 초기화
	// 이 생성자는 데이터베이스에서 게시글 정보를 조회할 때 사용
	public Dto(String no, String title, String id, String datetime, String hit, String text, String replyCount,
			String replyOri) {
		this.no = no; // 게시물 번호
		this.title = title; // 게시물 제목
		this.id = id; // 작성자 ID
		this.datetime = datetime; // 작성 시간
		this.hit = hit; // 조회수
		this.text = text; // 게시물 내용
		this.replyCount = replyCount; // 댓글 수
		this.replyOri = replyOri; // 원본 댓글 번호 (대댓글의 경우)
	}

	// 생성자: 게시물 제목과 내용만 수정할 때 사용
	// 주로 게시물 수정 작업에서 사용됩니다.
	public Dto(String title, String text) {
		this.title = title; // 게시물 제목
		this.text = text; // 게시물 내용
	}
}
