package com.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberApp {

	List<Member> members = new ArrayList<Member>();
	Scanner scn = new Scanner(System.in);
	// MemberService를 구현하는 구현클래스 선언(멤버 클래스)



	class MemberServiceImple implements MemberService {

		@Override
		public void addMember(Member member) {
			members.add(member);
		}

		@Override // 수정(연락처만)
		public void modifyMember(Member member) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getMemberId() == member.getMemberId()) {
					members.get(i).setPhone(member.getPhone());
				}
			}
		}

		@Override // 전체 리스트
		public List<Member> memberList() {
			return members;
		}

		@Override
		public Member getMember(int mn) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getMemberId() == mn) {
					return members.get(i);
				}
			}
			return null;
		}
	}

	public void execute() {
		MemberService service = new MemberServiceImple();

		// 메뉴: 1.등록 2.리스트 3.수정 9.종료
		// 1.도서반 :기본정보 + 반장이름, 강의실 정보 /members에 추가
		// 2.축구반 :코치이름 + 라커룸 이름
		// 3.수영반 :강사이름 + 수영등급
		int menu = 0;

		while (true) {
			int memberId = 0;
			String memberName, phone, topName, LibInfo, coachNm, rockerNm;
			String teacherNm, score;

			System.out.println("1.등록 2.리스트 3.수정 9.종료");
			System.out.println("선택>> ");
			
			try {
			menu = scn.nextInt();
			}catch(Exception e) {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		
			if (menu == 1) {
				System.out.println("1.도서반 2.축구반 3.수영반");
				int menu2 = scn.nextInt();
				
				//공통
				System.out.println("회원아이디 입력>>");
				memberId = scn.nextInt();
				System.out.println("회원이름 입력>>");
				memberName = scn.next();
				System.out.println("연락처 입력>>");
				phone = scn.next();
				
				

				if (menu2 == 1) {
					System.out.println("반장이름>> ");
					topName = scn.next();
					System.out.println("도서관이름>> ");
					LibInfo = scn.next();
					
					service.addMember(new BookMember(memberId, memberName, phone, topName, LibInfo));

				} else if (menu2 == 2) {

					System.out.println("코치이름>> ");
					coachNm = scn.next();
					System.out.println("라커룸이름>> ");
					rockerNm = scn.next();
					
					service.addMember(new SoccerMember(memberId, memberName, phone, coachNm, rockerNm));

				} else if (menu2 == 3) {

					System.out.println("강사이름>> ");
					teacherNm = scn.next();
					System.out.println("수영등급>> ");
					score = scn.next();

					service.addMember(new SwimMember(memberId, memberName, phone, teacherNm, score));

				} else {
					System.out.println("잘못된 메뉴를 선택했습니다.");
				
				}
				
				
			} else if (menu == 2) {
				List<Member> members = service.memberList();
				for (Member m1 : members) {
					System.out.println("===============");
					System.out.println(m1.toString());
					System.out.println("===============");
					System.out.println();
				}
				
			} else if (menu == 3) {
				
				System.out.println("ID입력>> ");
				memberId = scn.nextInt();
				Member member = service.getMember(memberId);
				if(member != null) {
					System.out.println("휴대폰번호>> ");
					phone = scn.next();
					Member m1 = new Member(memberId, null, phone);
					service.modifyMember(m1); //memberId들어가야함
				}
				

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
				
			}
			
		}
		System.out.println("end of program");
	}
}
