package concert;

import java.util.Scanner;


public class reserve {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		
		String cusName = null; // 예약자 성명
		int stGubun = 0; // 좌석타입
		int stNum = 0;
		
		Book ss = new Book(cusName, stGubun, stNum);
		
		Scanner sc = new Scanner(System.in);
		
		while(flag) { // - 예약 시스템의 메뉴는 "예약", "조회", "취소", "끝내기"가 있다.
					  // - 없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메시지를 출력하고 사용자가 다시시도하도록 한다.
			System.out.println();
			System.out.println("=============명품콘서트홀 예약시스템입니다.==============");
			System.out.println("원하는 서비스의 번호를 입력하세요. 1)예약 2)조회 3)취소 4)끝내기"); 
			
			int service_num = sc.nextInt();
			switch(service_num) {
			case 1: 
				ss.bookSeat();
				break;
			case 2: 
				ss.searchSeat();
				break;
			case 3: 
				ss.canSeat();
				break;
			case 4: // 끝내기
				System.out.println("시스템이 종료됩니다.");
				flag = false;
				break;
			default:
				System.out.println("잘못 누르셨습니다. 올바른 번호를 입력해주세요.");
			}
		}
	}
}

class Book{
	String cusName; // 예약자 성명
	int stGubun; // 좌석타입
	int stNum; // 좌석번호
	String[][] seats = new String[3][10]; // 좌석구분 - S A B 각 10석씩.
	String[] list = {"S","A","B"};
	
	public Book(String cusName, int stGubun, int stNum) {
		this.cusName = cusName;
		this.stGubun = stGubun;
		this.stNum = stNum;
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0; j < 10 ; j++) {
				seats[i][j] = "__";
			}
		}
	}
	
	public void bookSeat() { // 좌석예약
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------좌석 예약-----------");
		System.out.println("성명을 입력하세요");
		System.out.println("성명 :");
		String cusName = sc.next();
		while(true) {
			System.out.println("원하시는 좌석등급을 선택하세요. S석 = 1/A석 = 2/B석 = 3 (숫자로 입력해주세요)");
			System.out.println("좌석등급 :");
			int stGubun = sc.nextInt() - 1;
			System.out.println("원하시는 좌석번호을 선택하세요. 1~10번");
			System.out.println("좌석번호 :");
			int stNum = sc.nextInt() - 1 ;
         		if(stNum>10){
         			System.out.println("잘못된 좌석번호 입니다. 다시 입력해주세요.");
         			stNum = sc.nextInt()-1;
         		}
         		if(seats[stGubun][stNum].equals(cusName)){
         			System.out.println("이미 예약된 자리입니다.다시 시도해주세요.");
         	}
         	seats[stGubun][stNum] = (cusName);
         	break;
		}
		System.out.println();
	}
	
	public void searchSeat() { // 좌석조회 및 출력
		
		System.out.println("-----------좌석조회-----------");
		for (int i = 0; i < 3; i++) {
            System.out.print("\n" + list[i] + "석 ");
            for (int j = 0; j < 10; j++) {
                System.out.print(" "+ seats[i][j]);
            }
        }
	}
	
	public void canSeat() { // 좌석취소
		
			Scanner sc = new Scanner(System.in);
			System.out.println("-----------예약 취소-----------");
			System.out.println("예약자 성명:");
				String canName = sc.next();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 10; j++) {
						if(canName.equals(seats[i][j])) {
							seats[i][j] = "__";
							System.out.println("예약이 취소 되었습니다.");
							break;
					}
				}
			}
	}
}

