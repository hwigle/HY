package com.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardApp {

	List<Board> list = new ArrayList<Board>();
	Scanner scn = new Scanner(System.in);

	public BoardApp() {

	}

	public void execute() {
		BoardService service = null;
		service = new BoardServiceOracle();
		// 메뉴 1.게시글등록 2.게시글수정 3.게시글삭제 4.게시글 전체조회 5.게시글 한건조회(게시글번호로)
		while (true) {
			System.out.println("1.게시글등록 2.게시글수정 3.게시글삭제 4.게시글 전체조회 5.게시글 한건조회");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("게시글 번호를 입력하세요.");
				int bno = scn.nextInt();
				System.out.println("게시글 제목을 입력하세요.");
				String btitle = scn.next();
				System.out.println("게시글 내용을 입력하세요.");
				String bcontents = scn.next();
				System.out.println("게시글 작성자를 입력하세요.");
				String bwriter = scn.next();
				System.out.println("게시글 작성날짜를 입력하세요.");
				String bdate = scn.next();
				System.out.println("게시글 비밀번호를 입력하세요.");
				int bpassword = scn.nextInt();
				Board b1 = new Board(bno, btitle, bcontents, bwriter, bdate, bpassword);
				service.insertBoard(b1);
				System.out.println("게시글 작성이 완료되었습니다.");
			} else if (menu == 2) {
				System.out.println("수정할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				System.out.println("수정할 제목을 입력하세요.");
				String btitle = scn.next();
				System.out.println("수정할 내용을 입력하세요.");
				String bcontents = scn.next();
				System.out.println("비밀번호를 입력하세요.");
				int bpassword = scn.nextInt();
				Board b1 = new Board(bno, btitle, bcontents, bpassword);
				service.modifyBoard(b1);
				System.out.println("게시글 수정이 완료되었습니다.");
			} else if (menu == 3) {
				System.out.println("삭제할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				service.deleteBoard(bno);
				System.out.println("게시글 삭제가 완료되었습니다.");
			} else if (menu == 4) {
				List<Board> list = service.boardList();
				for (Board b : list) {
					System.out.println(b.toString());
				}
			} else if (menu == 5) {
				System.out.println("조회할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					System.out.println(board.toString());
				}
			}
		}
	}
}
