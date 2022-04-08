package com.project;

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
			System.out.println("1.게시글 등록 2.게시글 수정 3.게시글 삭제 4.게시글 리스트 5.게시글 보기 9.게시판 닫기");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				Board a1 = new Board();
				scn.nextLine();
				System.out.println("게시글 제목을 입력하세요.");
				String btitle = scn.nextLine();
				System.out.println("게시글 내용을 입력하세요.");
				String bcontents = scn.nextLine();
				System.out.println("게시글 작성자를 입력하세요.");
				String bwriter = scn.nextLine();
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
					scn.nextLine();
					System.out.println("수정할 제목을 입력하세요.");
					String btitle = scn.nextLine();
					System.out.println("수정할 내용을 입력하세요.");
					String bcontents = scn.nextLine();
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
					System.out.println(b.getBno() + "." + b.getBtitle() + " " + b.getBwriter() + " " + b.getBdate()
							+ " " + "\n------------------------------------------------");
				}
			} else if (menu == 5) {
				System.out.println("조회할 게시글의 번호를 입력하세요.");
				int bno = scn.nextInt();
				Board board = service.getBoard(bno);
				if (board == null) {
					System.out.println("없는 게시글 번호입니다.");
				} else {
					System.out.println(board.toString());
					System.out.println("댓글창\n");
					List<Reply> reply = service.replyList(bno);

					int r_n = 1;
					for (Reply r : reply) {
						// 첫루프때 리스트 처음에 있는 놈이 r에 들어감
						System.out.println("|" + r_n + "|" + " [작성자: " + r.getR_writer() + "]" + " " + r.getR_date()
								+ "\n         " + r.getR_contents()
								+ "\n==================================================");
						r_n++;
					}
					while (true) {
						System.out.println("1.댓글 작성 2.댓글 수정 3.댓글 삭제 4.나가기");
						int select = scn.nextInt();
						if (select == 1) {
							scn.nextLine();
							Board a1 = new Board();
							System.out.println("댓글 내용을 입력하세요.");
							String r_contents = scn.nextLine();
							System.out.println("댓글 작성자를 입력하세요.");
							String r_writer = scn.nextLine();
							String r_date = a1.setBdate(date);
							Reply r1 = new Reply(r_num, r_contents, r_writer, r_date, bno);
							r_num++;
							service.insertReply(r1);
						} else if (select == 2) {
//							System.out.println("댓글을 수정할 게시글의 번호를 입력하세요.");
//							bno = scn.nextInt();
////							Board board = service.getBoard(bno);
//							if (board == null) {
//								System.out.println("없는 게시글 번호입니다.");
//								continue;
//							} else {

							System.out.println("수정할 댓글의 번호를 입력하세요.");
							int r_no = scn.nextInt();
							System.out.println("수정할 댓글의 내용을 입력하세요.");
							String r_contents = scn.next();
							String r_date = date;
							Reply r1 = new Reply(r_no, r_contents, r_date, bno);
							service.modifyReply(r1);
							System.out.println("댓글 수정이 완료되었습니다.");

						} else if (select == 3) {
//							System.out.println("댓글을 삭제할 게시글의 번호를 입력하세요.");
//							bno = scn.nextInt();
//							if (board == null) {
//								System.out.println("없는 게시글 번호입니다.");
//							} else {
							System.out.println("삭제할 댓글의 번호를 입력하세요.");
							int r_no = scn.nextInt();
							Reply r1 = new Reply(r_no, bno);
							service.deleteReply(r1);
							System.out.println("댓글이 삭제되었습니다.");

						} else if (select == 4) {
							break;
						}
					}
				}
			} else if (menu == 9) {

				System.out.println("게시판을 닫았습니다.");
				break;
			}
		}
		System.out.println("end of prog");
	}
}
