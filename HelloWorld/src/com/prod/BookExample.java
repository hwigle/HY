package com.prod;

public class BookExample {
	public static void main(String[] args) {
		// 책(책제목, 저자, 출판사, 가격)
		Book book1 = new Book();
		book1.bookName = "혼공자";
		book1.Writer = "신용권";
		book1.Publisher = "한빛미디어";
		book1.Price = 24000;

		Book book2 = new Book();
		book2.bookName = "powerJava";
		book2.Writer = "천인국";
		book2.Publisher = "인피니티";
		book2.Price = 35000;

		Book book3 = new Book();
		book3.bookName = "재밌는 Java";
		book3.Writer = "이호준";
		book3.Publisher = "인피니티";
		book3.Price = 20000;

		Book[] books = { book1, book2, book3 };

		for (int i = 0; i < books.length; i++) {
//			if (books[i].Publisher == "인피니티") {
//				System.out.println("제목 : " + books[i].bookName);
//				System.out.println("저자 : " + books[i].Writer);
//				System.out.println("가격 : " + books[i].Price + "원");
//				System.out.println("================");
			if (books[i].Writer == "신용권") {
				System.out.println("제목 : " + books[i].bookName);
			}
		}
	}

}
