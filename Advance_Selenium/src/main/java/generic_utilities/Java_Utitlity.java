package generic_utilities;

import java.util.Random;

public class Java_Utitlity {
	/**
	 * This method is used to avoid Duplicates
	 * @return
	 * @author Rahul
	 */
	public int getRandomNum() {
		Random r=new Random();
		int ranNum = r.nextInt();
		return ranNum;
	}

}
