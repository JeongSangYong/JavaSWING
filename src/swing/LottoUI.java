package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoUI extends JFrame implements ActionListener{

	/**
	 * serialVersionUID 는 시리얼 번호로 클래스 구분 식별번호
	 */
	private static final long serialVersionUID = 1L;
	Lotto lotto;
	JButton btn;
	JPanel panelNorth, panelSouth;
	ImageIcon icon;
	List<JButton> btns;
	
	public LottoUI() {
		setTitle("로또 발생기");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		btn = new JButton("로또 번호 추첨");
		
		btn.addActionListener(this);//this는 큰 객체인 프레임을 가리킴
		panelNorth.add(btn);
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
		setBounds(300, 400, 1200, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		//버튼 객체 6개를 만듬
		if(btns.size() == 0){
			JButton tmp = null;
			for (int i = 0; i < 6; i++) {
				tmp = new JButton();
				btns.add(tmp);
				panelSouth.add(tmp);
			}
		}
		//6개의 랜덤숫자르 만듬
		lotto.setLotto();
		int[] arr = lotto.getLotto();
/*		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}*/
		//6개의 버튼 객체에 아이콘을 붙인다.
		for (int i = 0; i < arr.length; i++) {
			btns.get(i).setIcon(getIcon(arr[i]));
		}
	}

	private Icon getIcon(int i) {
		String imgPath = "src/images/"+Integer.toString(i)+".gif";
		return new ImageIcon(imgPath);
	}	
}
