package com.work;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
		String date = sdf.format(time.getTime());
		int b_num = service.getMaxnum() + 1;
		int r_num = service.getMaxnum2() + 1;

		// 메뉴 1.게시글등록 2.게시글수정 3.게시글삭제 4.게시글 전체조회 5.게시글 한건조회(게시글번호로)
		while (true) {
			System.out.println("1.게시글 등록 2.게시글 수정 3.게시글 삭제 4.게시글 리스트 5.게시글 보기 6.댓글 작성 7.댓글 삭제 8.게시판 닫기");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				Board a1 = new Board();
//				System.out.println("게시글 번호를 입력하세요.");
//				int bno = scn.nextInt();
				System.out.println("게시글 제목을 입력하세요.");
				String btitle = scn.next();
				System.out.println("게시글 내용을 입력하세요.");
				String bcontents = scn.next();
				System.out.println("게시글 작성자를 입력하세요.");
				String bwriter = scn.next();
				String bdate = a1.setBdate(date);
				System.out.println("게시글 비밀번호를 입력하세요.");
				int bpassword = scn.nextInt();
				Board b1 = new Board(b_num, btitle, bcontents, bwriter, bdate, bpassword);
				b_num++;
				service.insertBoard(b1);
				System.out.println("게시글 작성이 완료되었습니다.");
			} else if (menu == 2) {
				System.out.println("수정할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					System.out.println("수정할 제목을 입력하세요.");
					String btitle = scn.next();
					System.out.println("수정할 내용을 입력하세요.");
					String bcontents = scn.next();
					System.out.println("비밀번호를 입력하세요.");
					int bpassword = scn.nextInt();
					Board b1 = new Board(bno, btitle, bcontents, bpassword);
					service.modifyBoard(b1);
					System.out.println("게시글 수정이 완료되었습니다.");
				}
			} else if (menu == 3) {
				System.out.println("삭제할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					System.out.println("삭제할 게시글의 비밀번호를 입력하세요.");
					int bpassword = scn.nextInt();
					Board b1 = new Board(bno, bpassword);
					service.deleteBoard(b1);
					System.out.println("게시글 삭제가 완료되었습니다.");
				}
			} else if (menu == 4) {
				List<Board> list = service.boardList();
				for (Board b : list) {
					System.out.println(
							b.getBno() + "." + b.getBtitle() + " " + b.getBwriter() + " " + b.getBdate() + " ");
				}
			} else if (menu == 5) {
				System.out.println("조회할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					System.out.println(board.toString());
					List<Reply> reply = service.replyList(bno);
					for (Reply r : reply) {
						System.out.println("<" + r.getR_no() + "> " + r.getR_writer() + " " + r.getR_date() + "\n"
								+ r.getR_contents());

					}
				}
			} else if (menu == 6) {
				Board a1 = new Board();
				System.out.println("댓글을 작성할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					// 댓글 작성
					System.out.println("댓글 내용을 입력하세요.");
					String r_contents = scn.next();
					System.out.println("댓글 작성자를 입력하세요.");
					String r_writer = scn.next();
					String r_date = a1.setBdate(date);
					int b_no = 0;
					Reply r1 = new Reply(r_num, r_contents, r_writer, r_date, b_no);
					b_num++;
					service.insertReply(r1);
				}
			} else if (menu == 7) {
				System.out.println("댓글을 삭제할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					System.out.println("삭제할 댓글의 번호를 입력하세요.");
					int r_no = scn.nextInt();
					service.deleteReply(r_no);
					System.out.println("댓글이 삭제되었습니다.");
				}
			} else if (menu == 8) {
				System.out.println("게시판을 닫았습니다.");
				break;
			}
		}
		System.out.println("end of prog");
	}
}
