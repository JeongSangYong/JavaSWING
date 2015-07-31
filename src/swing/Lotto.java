package swing;

import java.util.Arrays;

public class Lotto {
	//필드
	int[] lotto = new int[6];

	//생성자
	
	public int[] getLotto() {
		return lotto;
	}

	//로또는 외부에서 숫자를 주입받는 것이 아니라 자체적으로
	//랜덤숫자를 발생시켜야 한다.
	public void setLotto() {		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = 0;	//배열내부의 지변초기화
		}
		for (int i = 0; i < lotto.length; i++) {
			int randomNum = (int) ((Math.random()*45)+1);
			
			//로또는 숫자가 숭복이 있어서는 안됨
			//나중에 나온 숫자가 먼저 나온 숫자와 같다면 그 숫자는 폐기해야함
			boolean exist = false;
			for (int j = 0; j < lotto.length; j++) {
				if (randomNum == lotto[j]) {
					exist = true;
					break;
				}
			}
			if (exist) {
				i--;
				continue;
			}else{
				lotto[i]=randomNum;
			}
		}
		//중복이 되지 않은 6개의 랜덤숫자가 배열에 담겼다면
		//그 배열의 숫자를 오름차순으로 정렬해야 함
		Arrays.sort(lotto);
	}
	
	//멤버메소드
	
	
	
}
