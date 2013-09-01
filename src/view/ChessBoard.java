package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import solution.Board;
import solution.Challenge;
import solution.Queen;

public class ChessBoard extends JFrame {

	private JPanel[][] pnlChessCells = new JPanel[8][8];
	private JPanel pnlMain = new JPanel(new GridLayout(8, 8));
	private ImageIcon queenBlack = new ImageIcon(getClass().getResource(
			"/images/QueenBlack2.jpeg"));
	private Container c;
	private JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
	private JPanel pnlNav = new JPanel(new GridLayout(1, 4));
	private JPanel pnlPager = new JPanel(new GridLayout(2, 1));
	JLabel lblPager = new JLabel();
	JLabel lblNumberOfAttacks = new JLabel();

	public ChessBoard() {
		initBoard();
	}

	private void initBoard() {
		c = getContentPane();

		configureLayoutDefault();

		c.setLayout(null);

		pnlMain.setBounds(3, 3, 460, 460);
		pnlMain.setBackground(new Color(255, 255, 255));

		c.add(pnlMain);

		configureButtons();

		c.add(pnlButtons);

		configureNavButtons();

		c.add(pnlNav);

		configureLabels();

		c.add(pnlPager);

		this.drawChessBoard();
		this.insertQueensInBoard();
	}

	private void configureLayoutDefault() {
		setBounds(100, 50, 460, 650);
		setBackground(new Color(204, 204, 204));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("8 Queens Puzzle");
		setResizable(false);
	}

	private void configureLabels() {
		pnlPager.add(lblPager);
		pnlPager.add(lblNumberOfAttacks);
		pnlPager.setBounds(0, 565, 460, 50);
		lblPager.setAlignmentX(CENTER_ALIGNMENT);
	}

	private void configureNavButtons() {
		JButton btnNavPrevious = createPreviousButton();
		JButton btnNavNext = createNextButton();
		JButton btnNavFirst = createFirstButton();
		JButton btnNavLast = createLastButton();

		pnlNav.add(btnNavFirst);
		pnlNav.add(btnNavPrevious);
		pnlNav.add(btnNavNext);
		pnlNav.add(btnNavLast);
		pnlNav.setBounds(0, 515, 460, 50);
	}

	private void configureButtons() {
		JButton btnNewChallenge = createNewChallengeButton();
		JButton btnSolveChallenge = createSolveChallengeButton();

		pnlButtons.add(btnNewChallenge);
		pnlButtons.add(btnSolveChallenge);
		pnlButtons.setBounds(0, 465, 460, 50);
	}

	private JButton createLastButton() {
		JButton btnNavLast = new JButton("Last");
		btnNavLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Viewer.initLastState();
			}
		});
		return btnNavLast;
	}

	private JButton createFirstButton() {
		JButton btnNavFirst = new JButton("First");
		btnNavFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Viewer.initFirstState();
			}
		});
		return btnNavFirst;
	}

	private JButton createNextButton() {
		JButton btnNavNext = new JButton("Next");
		btnNavNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Viewer.initNextState();
			}
		});
		return btnNavNext;
	}

	private JButton createPreviousButton() {
		JButton btnNavPrevious = new JButton("Previous");
		btnNavPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Viewer.initPreviousState();
			}
		});
		return btnNavPrevious;
	}

	private JButton createSolveChallengeButton() {
		JButton btnSolveChallenge = new JButton("Solve new Challenge");
		btnSolveChallenge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Viewer.initsolveChallengeState();
			}
		});
		return btnSolveChallenge;
	}

	private JButton createNewChallengeButton() {
		JButton btnNewChallenge = new JButton("Create New Challenge");
		btnNewChallenge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Viewer.initCreateNewChallenge();
			}
		});
		return btnNewChallenge;
	}

	private void drawChessBoard() {

		for (int y = 0; y < 8; y++)
			for (int x = 0; x < 8; x++) {
				pnlChessCells[y][x] = new JPanel(new BorderLayout());
				pnlMain.add(pnlChessCells[y][x]);

				if (y % 2 == 0) {

					if (x % 2 != 0)
						pnlChessCells[y][x].setBackground(Color.DARK_GRAY);
					else
						pnlChessCells[y][x].setBackground(Color.WHITE);

				} else {

					if (x % 2 == 0)
						pnlChessCells[y][x].setBackground(Color.DARK_GRAY);
					else
						pnlChessCells[y][x].setBackground(Color.WHITE);

				}
			}
	}

	private void insertQueensInBoard() {
		for (Queen queen : Viewer.challenge.getBoard().getBoard()) {
			this.pnlChessCells[queen.getRowNumber() - 1][queen
					.getColumnNumber() - 1].add(new JLabel(queenBlack),
					BorderLayout.CENTER);
			this.pnlChessCells[queen.getRowNumber() - 1][queen
					.getColumnNumber() - 1].validate();
		}
	}
}
