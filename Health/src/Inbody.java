import java.util.*;

//헬스장 회원 인바디 프로그래밍(
//1.이름,체중,키 입력 => 내용을 저장,
//2.BMI 계산 결과 출력 (BMI에 맞춘 저체중, 표준, 고도비만, 초고비만까지 같이 출력)
//3.회원 목록 출력 => 출력 후 결과 보시겠습니까 (Y/N) Y 입력시 2.를 출력
//4.회원 목록 삭제
//5.목표 칼로리 구해주기
public class Inbody {

	public static double bmi(double weightList, double heightList) {
		double result = weightList / ((heightList / 100) * (heightList / 100));
		return result;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("---Inbody_Information---");
		System.out.println("----작 성 자 : 윤 영 욱----");
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println();

		int[] memberNumList = new int[5]; // 고유한 회원번호
		String[] nameList = new String[5];
		double[] weightList = new double[5];
		double[] heightList = new double[5];
		int count = 0;
		double result = 0; // bmi값 대입 변수

		while (true) {

			System.out.println("1.회원 정보 저장 ");
			System.out.println("2.BMI 결과 출력 ");
			System.out.println("3.회원 목록 출력 ");
			System.out.println("4.회원 정보 검색 ");
			System.out.println("5.회원 정보 삭제 ");
			System.out.println("0.프로그램 종료 ");
			System.out.print("커맨드를 입력해주세요 > ");

			String inputValue = scn.nextLine(); // 입력값을 받아서 inputValue 변수에 대입

			if (inputValue.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break; // 0을 입력하면 프로그램이 종료됨
			}

			if (inputValue.equals("1")) { // 입력값이 1이면 진행
				int memberNum = 0;
				while (true) {
					System.out.print("회원번호를 입력하세요 : ");
					String tempMemberNumList = scn.nextLine();
					memberNum = Integer.parseInt(tempMemberNumList);
					int cnt = 0;
					for (int i = 0; i < count; i++) {
						if (memberNumList[i] == memberNum) {
							System.out.println("중복된 값입니다.");
							cnt++;
							break;
						}
					}
					if (cnt == 0) {
						break;
					}
				}

				if (memberNumList.length == count) { // 배열의 길이가 같아지면 2배 늘림
					int[] newMemberNumList = new int[count * 2];
					String[] newNameList = new String[count * 2];
					double[] newWeightList = new double[count * 2];
					double[] newHeightList = new double[count * 2];

					for (int i = 0; i < count; i++) {
						newMemberNumList[i] = memberNumList[i];
						newNameList[i] = nameList[i];
						newWeightList[i] = weightList[i];
						newHeightList[i] = heightList[i];
					}
					memberNumList = newMemberNumList; // 새 배열 주소를 원래 배열에 넣음
					nameList = newNameList;
					weightList = newWeightList;
					heightList = newHeightList;

				}
				System.out.print("이름을 입력하세요 : ");
				String name = scn.nextLine(); // 입력값 이름을 name 변수에 저장

				System.out.print("체중을 입력하세요 : ");
				String tempWeight = scn.nextLine();// 입력값 체중을 tempWeight 변수에 저장
				int weight = Integer.parseInt(tempWeight);// tempWeight를 int weight저장

				System.out.print("키를 입력하세요 : ");
				String tempheight = scn.nextLine();// 입력값 키를 tempheight 변수에 저장
				int height = Integer.parseInt(tempheight);// tempheight를 int로 바꿔서 height로 저장

				memberNumList[count] = memberNum;
				nameList[count] = name;
				weightList[count] = weight;
				heightList[count] = height;

				count++; // 1번 값을 받았을 때 저장되는 개수를 나타내주기 위해 사용

				System.out.println("정보가 정상적으로 입력되었습니다.");
				System.out.println("계속하려면 enter를 눌러주세요");
				scn.nextLine();

			} else if (inputValue.equals("2")) {
				System.out.print("원하는 회원번호를 입력하세요 : ");
				String customerName = scn.nextLine();
				int customerNum = Integer.parseInt(customerName);

				for (int i = 0; i < count; i++) {
					if (memberNumList[i] == customerNum) { // 입력 받은 값이랑 회원번호가 같으면
						result = bmi(weightList[i], heightList[i]); // result = 체중 / ((키(m)
						result = Math.round(result * 10) / 10.0; // BMI 값 소수점 한자리를 반올림

						System.out.println(nameList[i] + " 회원님의 BMI 수치는 : " + result + "입니다"); // BMI 수치 보여주는 코드
						if (result >= 0 && result < 18.5) {
							System.out.println(nameList[i] + "님은 저체중입니다");
						} else if (result >= 18.5 && result < 23) {
							System.out.println(nameList[i] + "님은 표준체중입니다.");
						} else if (result >= 23 && result < 25) {
							System.out.println(nameList[i] + "님은 과체중입니다");
						} else if (result >= 25) {
							System.out.println(nameList[i] + "님은 비만입니다");
						} else {
							System.out.println("잘못된 입력입니다.");
						}
					}

				}

				System.out.println("정보가 정상적으로 출력되었습니다.");
				System.out.println("계속하려면 enter를 눌러주세요");
				scn.nextLine();

			} else if (inputValue.equals("3")) { // 3을 입력했을 때 실행 로직
				for (int i = 0; i < count; i++) {
					String text = "회원 번호 : ";
					text += memberNumList[i];
					text += ", 이름 : ";
					text += nameList[i];
					text += ", 체중 : ";
					text += weightList[i];
					text += ", 키 : ";
					text += heightList[i];
					text += "cm";

					System.out.println(text);
				}

				System.out.println("저장된 회원수 : " + count + "명");
				System.out.println("계속하려면 enter를 눌러주세요");
				scn.nextLine();

			} else if (inputValue.equals("4")) { // 회원 정보 검색
				int cnt = 0;
				System.out.print("검색할 회원의 이름을 입력하세요 : ");
				String searchInput = scn.nextLine();

				for (int i = 0; i < count; i++) {
					if (nameList[i].equals(searchInput)) { // 입력값이 리스트에 있으면 출력
						System.out.println(nameList[i] + "님이 검색되었습니다.");
						cnt++; // 수 증가
					}

					if (cnt == 0) { // 검색한 결과가 없을 때
						System.out.println("검색 결과가 없습니다.");
						break; // 반복문을 나감
					} else {
						System.out.println(cnt + "명이 검색되었습니다.");

						System.out.print("검색 회원의 BMI 정보를 보시겠습니까? Y/N");
						String yesOrNOT = scn.nextLine();

						if (yesOrNOT.equals("y") || yesOrNOT.equals("Y") || yesOrNOT.equals("ㅛ")) { // Y를 누르면 BMI수치 출력
							for (int x = 0; x < count; x++) {
								if (nameList[x].equals(searchInput)) {
									result = bmi(weightList[i], heightList[i]);
									result = Math.round(result * 10) / 10.0;
									System.out.println("회원님의 BMI = " + result);
								}
							}
						}
					}
				}
				System.out.println("계속하려면 enter를 눌러주세요");
				scn.nextLine();

			} else if (inputValue.equals("5")) { // 회원 정보 삭제
				System.out.println("삭제할 회원의 이름을 입력해주세요 : ");
				String deleteName = scn.nextLine();// 입력
				int deleteCount = 0; // 삭제된 회원수를 대입할 변수

				for (int i = 0; i < count; i++) {
					if (nameList[i].equals(deleteName)) { // 반복문 안에서 입력값이 저장값이랑 같은 경우
						for (int x = 0; x < count - 1; x++) {// 반복문을 돌림 삭제할 배열에 다음 값을 넣어줌으로 값을 삭제
							nameList[x] = nameList[x + 1];
							weightList[x] = weightList[x + 1];
							heightList[x] = heightList[x + 1];
						}

						count--;
						i--;
						deleteCount++;
					}
				}
				System.out.println(deleteCount + "명 삭제되었습니다.");
				System.out.println("프로그램을 계속하려면 enter를 입력해주세요");
				scn.nextLine();
			}

		}

	}

}
