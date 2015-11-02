import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Methods extends MyPanel implements MouseListener {
	static JFrame fm; // frame for resume and game over panel
	static JFrame frame;

	// creating cars of left side
	public void initializationLeft(int mode) {

		int x = (int) ((Math.random() * 2) + 3);
		// Getting random number of cars between 3 and 12
		n1 = (int) ((Math.random() * 4) + 1);
		int pre = side1.size();
		if (mode == 1) {
			for (int i = pre; i < pre + n1; i++) {

				// random number to determine cars direction
				if (k1 % 2 == 0) {
					if (k1 % x == 0) {
						side1.add(0);
					} else {
						side1.add(1);
					}
					// number 0 or 1
				}
				if (k1 % 2 != 0) {
					if (k1 % x == 0) {
						side1.add(2);
					} else {
						side1.add(1);
					}
				}
				side1x.add(xpos[0][0] - ((int) (i / 2) * 100));// Setting
																// position of
																// first car and
																// finding
																// remaining by
																// subtracting
																// 100 from
																// previous car

				side1y.add(ypos[0][k1 % 2]);// Looping between two y positions
											// for cars
				side1Angle.add((double) 0); // Angle of cars of left side is
											// zero
				carLeft.add(new Images());
				k1++;
			}
		}

		n1 = (int) ((Math.random() * 3) + 1);
		pre = side1b.size();
		// if it is second game mode then cars postion changes
		if (mode == 2) {

			for (int i = pre; i < pre + n1; i++) {
				if (k1b % 2 == 0) {
					side1b.add((int) (Math.random() * 2));// Getting random
															// number 0 or 1
				}
				if (k1b % 2 != 0) {
					side1b.add(1 + (int) ((Math.random() * (2))));// Getting
																	// random
																	// number
																	// 1 or
																	// 2
				}
				side1bx.add(xpos1[0][0] - ((int) (i / 2) * 100));// Setting
																	// position
																	// of
																	// first car
																	// and
																	// finding
																	// remaining
																	// by
																	// subtracting
																	// 100 from
																	// previous
																	// car

				side1by.add(ypos1[0][k1b % 2]);// Looping between two y
												// positions
												// for cars
				side1bAngle.add((double) 0); // Angle of cars of left side is
												// zero
				carLeftb.add(new Images());
				k1b++;
			}
		}

	}

	// Creating cars of right side
	public void initializationRight() {
		int x = (int) ((Math.random() * 2) + 3);
		// Getting random number of cars
		n2 = (int) ((Math.random() * 4) + 1);
		int pre = side2.size();
		for (int i = pre; i < pre + n2; i++) {
			if (k2 % 2 == 0) {
				if (k2 % x == 0) {
					side2.add(0);
				} else {
					side2.add(1);
				}
				// number 0 or 1
			}
			if (k2 % 2 != 0) {
				if (k2 % x == 0) {
					side2.add(2);
				} else {
					side2.add(1);
				}
			}
			side2x.add(xpos[1][0] + ((int) (i / 2) * 100));// Setting
															// position of
															// first car and
															// finding
															// remaining by
															// adding 100 to
															// previous car

			side2y.add(ypos[1][k2 % 2]);// Looping between two y positions for
										// cars
			side2Angle.add((double) 180); // Angle of cars of right side is zero
			carRight.add(new Images());
			k2++;
		}
	}

	public void initializationTop() {
		int x = (int) ((Math.random() * 2) + 3);
		// Getting random number of cars between 3 and 12
		n3 = (int) ((Math.random() * 2) + 3);
		int pre = side3.size();
		for (int i = pre; i < pre + n3; i++) {
			if (k3 % 2 == 0) {
				if (k3 % x == 0) {
					side3.add(0);
				} else {
					side3.add(1);
				}
				// number 0 or 1
			}
			if (k3 % 2 != 0) {
				if (k3 % x == 0) {
					side3.add(2);
				} else {
					side3.add(1);
				}
			}
			side3y.add(ypos[2][0] - ((int) (i / 2) * 100));// Setting
															// yposition of
															// first car and
															// finding
															// remaining by
															// subtracting
															// 100 from
															// previous car

			side3x.add(xpos[2][k3 % 2]);// Looping between two x positions for
										// cars
			side3Angle.add((double) 90); // Angle of cars of top side is 90
			carTop.add(new Images());
			k3++;
		}

	}

	// creating cars of bottom side
	public void initializationBottom(int mode) {
		int x = (int) ((Math.random() * 2) + 3);
		// Getting random number of cars between 3 and 12
		n4 = (int) ((Math.random() * 2) + 3);
		int pre = side4.size();
		// game mode 1
		if (mode == 1) {
			for (int i = pre; i < pre + n4; i++) {
				if (k4 % 2 == 0) {
					if (k4 % x == 0) {
						side4.add(0);
					} else {
						side4.add(1);
					}
					// number 0 or 1
				}
				if (k4 % 2 != 0) {
					if (k4 % x == 0) {
						side4.add(2);
					} else {
						side4.add(1);
					}
				}
				side4y.add(ypos[3][0] + ((int) (i / 2) * 100));// Setting
																// position of
																// first car and
																// finding
																// remaining by
																// adding 100 to
																// previous car

				side4x.add(xpos[3][k4 % 2]);// Looping between two x positions
											// for
											// cars
				side4Angle.add((double) -90); // Angle of cars of bottom side is
												// -90
				carBottom.add(new Images());
				k4++;
			}
		}

		n4 = (int) ((Math.random() * 3) + 1);
		pre = side4b.size();
		// if 2nd mode then position of car changes
		if (mode == 2) {
			for (int i = pre; i < pre + n4; i++) {
				if (k4b % 2 == 0) {
					side4b.add((int) (Math.random() * 2));// Getting random
															// number 0 or 1
				}
				if (k4b % 2 != 0) {
					side4b.add(1 + (int) (Math.random() * 2));// Getting
																// random
																// number
																// 1 or
																// 2
				}
				side4by.add(ypos1[3][0] + ((int) (i / 2) * 100));// Setting
																	// position
																	// of
																	// first car
																	// and
																	// finding
																	// remaining
																	// by
																	// adding
																	// 100 to
																	// previous
																	// car

				side4bx.add(xpos1[3][k4b % 2]);// Looping between two x
												// positions
												// for
												// cars
				side4bAngle.add((double) -90); // Angle of cars of bottom side
												// is -90
				carBottomb.add(new Images());
				k4b++;
			}
		}
	}

	// action for key binding
	Action escape = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {

			fm = new JFrame();
			Resume m = new Resume();
			pause = true;
			clip.stop();
			fm.add(m);
			fm.setUndecorated(true);
			fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
			fm.setVisible(true);

		}
	};
	// action for key binding
	Action down = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			signalsRestore();
			if (green != 3) {
				green = 3;
				Top.setIcon(Green1);
			} else if (green == 3) {
				green = 0;
				Top.setIcon(Red1);
			}
		}

	};
	// action for key binding
	Action up = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			signalsRestore();
			if (green != 4) {
				green = 4;
				Bottom.setIcon(Green1);
			} else if (green == 4) {
				green = 0;
				Bottom.setIcon(Red1);
			}
		}
	};
	// action for key binding
	Action left = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			signalsRestore();
			if (green != 2) {
				green = 2;
				Right.setIcon(Green3);
			} else if (green == 2) {
				green = 0;

				Right.setIcon(Red3);
			}
		}
	};

	// action for key binding
	Action right = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			signalsRestore();
			if (green != 1) {
				green = 1;
				Left.setIcon(Green2);

			} else if (green == 1) {
				green = 0;
				Left.setIcon(Red2);
			}
		}
	};
	// action for key binding
	Action space = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			signalsRestore();
			if (green != 4) {
				green = 4;
				Bottom.setIcon(Green1);
			} else if (green == 4) {
				green = 0;
				Bottom.setIcon(Red1);
			}
		}
	};
	// action for key binding
	Action Stop = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			signalsRestore();
			green = 0;
		}
	};

	@Override
	public void mouseClicked(MouseEvent e) {

		// Setting icons of all signals red
		Left.setIcon(Red2);
		Right.setIcon(Red3);
		Top.setIcon(Red1);
		Bottom.setIcon(Red1);
		// turning left signal on
		if (e.getComponent() == leftButton) {
			if (green != 1) {
				green = 1;
				Left.setIcon(Green2);
			} else if (green == 1) {
				green = 0;
				Left.setIcon(Red2);
			}

		}
		// turning right signal on
		if (e.getComponent() == rightButton) {
			if (green != 2) {
				green = 2;
				Right.setIcon(Green3);
			} else if (green == 2) {
				green = 0;
				Right.setIcon(Red3);
			}
		}
		// turning Top signal on
		if (e.getComponent() == topButton) {
			if (green != 3) {
				green = 3;
				Top.setIcon(Green1);
			} else if (green == 3) {
				green = 0;
				Top.setIcon(Red1);
			}
		}
		// turning Bottom signal on
		if (e.getComponent() == bottomButton) {
			if (green != 4) {
				green = 4;
				Bottom.setIcon(Green1);
			} else if (green == 4) {
				green = 0;
				Bottom.setIcon(Red1);
			}
		}

	}

	// hover effect
	@Override
	public void mouseEntered(MouseEvent e) {

		// Adding hover effect on signals
		// Turns yellow when mouse entered
		if (e.getComponent() == leftButton) {
			Left.setIcon(Yellow2);
		}
		if (e.getComponent() == rightButton) {
			Right.setIcon(Yellow2);
		}
		if (e.getComponent() == topButton) {
			Top.setIcon(Yellow1);
		}
		if (e.getComponent() == bottomButton) {
			Bottom.setIcon(Yellow1);
		}

	}

	// hover effect
	@Override
	public void mouseExited(MouseEvent e) {

		// Restoring the left signal image back when mouse exited
		if (e.getComponent() == leftButton) {
			if (green == 1) {
				Left.setIcon(Green2);
			} else {
				Left.setIcon(Red2);
			}
		}
		// Restoring the Right signal image back when mouse exited
		if (e.getComponent() == rightButton) {
			if (green == 2) {
				Right.setIcon(Green3);
			} else {
				Right.setIcon(Red3);
			}
		}
		// Restoring the Top signal image back when mouse exited
		if (e.getComponent() == topButton) {
			if (green == 3) {
				Top.setIcon(Green1);
			} else {
				Top.setIcon(Red1);
			}
		}
		// Restoring the Bottom signal image back when mouse exited
		if (e.getComponent() == bottomButton) {
			if (green == 4) {
				Bottom.setIcon(Green1);
			} else {
				Bottom.setIcon(Red1);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	// Method responsible for all movements
	public Values trans(int side, int counter, int n, int green, int xpos,

	int ypos, double angle) {
		// First argument is used to tell method that it is left side
		// 2nd argument ie counter is used to tell number i.e index of this car
		// in the lane
		// 3rd arument is used to tell that car wants to move left ,right or
		// straight
		// Green is used to tell that which signal is open
		// 5th and 6th argumenty is to tell the x and y position of car
		// 7th argument is tell the current angle of rotation
		Values v = new Values(); // Making an object of Value class

		// Saving values got through arguments in the object
		v.angle = angle;
		v.xpos = (int) (xpos);
		v.ypos = (int) (ypos);

		int diff = 0;
		// We have subtracted diff from each reading to make each cars positon
		// according to his index in the lane.
		// WE have multiplied with xp and yp to make it adjustable according to
		// resolution
		// There are four sides
		/*
		 * 1=left 2=right 3=top 4=bottom
		 */

		// Left side
		if (side == 1) {

			if (counter >= passedLeft) {
				counter -= passedLeft;

			}
			diff = (counter / 2) * 100;

			// Left turn
			if (n == 1) {
				v.xinc = 4; // Speed of car
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), v.xpos, v.ypos);
				v.at1.translate(v.xpos, v.ypos);
				if (pause) {
					return v;
				}

				// Stoping car if signal is off
				if (v.xpos >= ((420) - diff) && v.xpos <= (424 - diff)
						&& green != 1) {

					v.xinc = 0;
					v.yinc = 0;
					return v;
				}

				// Rotating the car slowly to left side when it reaches a
				// specific point
				if (v.xpos >= 560) {
					if (v.angle > -90) {
						v.angle -= 1.4;
						v.xinc = 1;
						v.yinc = -1;
					}

					if (v.angle <= -90.0) {
						v.xinc = 0;
						v.yinc = -4;
						v.angle = -90.0;
					}

				}

			}

			if (n == 2) {// Going straight

				// translating through AfflineTransform
				v.at1.translate(v.xpos, v.ypos);
				v.xinc = 4;// Speed of car
				v.yinc = 0;
				// Stoping car if signal is off
				if (pause) {
					return v;
				}
				if (green != 1 && v.xpos >= 420 - diff && v.xpos <= 424 - diff) {
					v.xinc = 0;
					return v;
				}
			}

			if (n == 3) { // Right Turn from left side
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off

				if (v.xpos >= 420 - diff && xpos <= 424 - diff && green != 1) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				v.xinc = 4;// Speed of car
				// Rotating the car slowly to right side when it reaches a
				// specific point
				if (v.xpos >= 560) {
					if (v.angle < 15) {

						v.angle += .8;
						v.xinc = 2;
						v.yinc = 1;
					}
					if (v.angle < 40 && v.angle > 15) {

						v.angle += 1;
						v.xinc = 2;
						v.yinc = 1;
					}
					if (v.angle < 60 && v.angle > 40) {

						v.angle += 1;
						v.xinc = 2;
						v.yinc = 2;
					}
					if (v.angle < 90 && v.angle > 60) {

						v.angle += .7;
						v.xinc = 1;
						v.yinc = 2;
					}

					if (v.angle >= 90) {
						v.xinc = 0;
						v.yinc = 4;
						v.angle = 90;
					}

				}

			}
		}

		// Right side
		if (side == 2) {
			if (counter >= passedRight) {
				counter -= passedRight;
			}
			diff = (counter / 2) * 100;
			if (n == 1) {
				// left Turn from right side
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.xpos <= 940 + diff && v.xpos >= 936 + diff && green != 2) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				v.xinc = -4;// speed of car
				// Rotating the car slowly to left side when it reaches a
				// specific point
				if (v.xpos <= 795) {
					if (v.angle >= 90) {

						v.angle -= 1.4;
						v.xinc = -1;
						v.yinc = +1;
					}

					if (v.angle <= 90) {
						v.xinc = 0;
						v.yinc = 4;
						v.angle = 90;
					}

				}

			}

			if (n == 2) {
				// translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(v.xpos, v.ypos);
				v.xinc = -4;// Speed of car
				v.yinc = 0;
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.xpos <= 940 + diff && v.xpos >= 936 + diff && green != 2) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
			}

			if (n == 3) { // right Turn from right side
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.xpos <= 940 + diff && v.xpos >= 936 + diff && green != 2) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				v.xinc = -4;// Speed of car
				// Rotating the car slowly to right side when it reaches a
				// specific point
				if (v.xpos <= 780) {
					if (v.angle < 195) {

						v.angle += .8;
						v.xinc = -2;
						v.yinc = -1;
					}
					if (v.angle < 220 && v.angle > 195) {

						v.angle += 1;
						v.xinc = -2;
						v.yinc = -1;
					}
					if (v.angle < 240 && v.angle > 220) {

						v.angle += 1.15;
						v.xinc = -2;
						v.yinc = -2;
					}
					if (v.angle < 270 && v.angle > 240) {

						v.angle += .9;
						v.xinc = -1;
						v.yinc = -2;
					}

					if (v.angle >= 270) {
						v.xinc = 0;
						v.yinc = -4;
						v.angle = 270;
					}

				}

			}
		}

		// Top side
		if (side == 3) {
			if (counter >= passedTop) {
				counter -= passedTop;
			}
			diff = (counter / 2) * 100;
			if (n == 1) { // left Turn from top side
				v.yinc = 4;// Speed of car
				v.xinc = 0;
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.ypos >= 160 - diff && v.ypos <= 164 - diff && green != 3) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				// Rotating the car slowly to left side when it reaches a
				// specific point
				if (v.ypos >= 275) {
					if (v.angle > 0) {

						v.angle -= 1.5;
						v.xinc = 1;
						v.yinc = +1;
					}

					if (v.angle <= 0) {
						v.xinc = 4;
						v.yinc = 0;
						v.angle = 0;
					}

				}

			}

			if (n == 2) { // Straight
				// translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(v.xpos, v.ypos);
				v.yinc = 4;// Speed of car
				v.xinc = 0;
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.ypos >= 160 - diff && v.ypos <= 164 - diff && green != 3) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
			}
			if (n == 3) {
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				v.yinc = 4;// Speed of car
				v.xinc = 0;
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.ypos >= 160 - diff && v.ypos <= 164 - diff && green != 3) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				// Rotating the car slowly to right side when it reaches a
				// specific point
				if (v.ypos >= 280) {
					if (v.angle < 105) {

						v.angle += .78;
						v.xinc = -1;
						v.yinc = 2;
					}
					if (v.angle < 130 && v.angle > 105) {

						v.angle += 1.15;
						v.xinc = -2;
						v.yinc = 3;
					}
					if (v.angle < 145 && v.angle > 130) {

						v.angle += .8;
						v.xinc = -3;
						v.yinc = 2;
					}
					if (v.angle < 170 && v.angle > 145) {

						v.angle += 1;
						v.xinc = -3;
						v.yinc = 1;
					}
					if (v.angle < 180 && v.angle > 170) {

						v.angle += 1.1;
						v.xinc = -2;
						v.yinc = 1;
					}

					if (v.angle >= 180) {
						v.xinc = -4;
						v.yinc = 0;
						v.angle = 180;
					}

				}

			}

		}
		// Bottom side
		if (side == 4) {
			if (counter >= passedBottom) {
				counter -= passedBottom;
			}
			diff = (counter / 2) * 100;
			if (n == 1) { // left Turn from bottom side
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.ypos <= (630) + diff && v.ypos >= (626) + diff
						&& green != 4) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				v.yinc = -4;// Speed of car
				v.xinc = 0;
				// Rotating the car slowly to left side when it reaches a
				// specific point
				if (v.ypos <= 500) {
					if (v.angle > -180) {
						v.angle -= 1.5;
						v.xinc = -1;
						v.yinc = -1;
					}

					if (v.angle <= -180) {
						v.xinc = -4;
						v.yinc = 0;
						v.angle = -180;
					}

				}

			}

			if (n == 2) { // Straight
				// translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(v.xpos, v.ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.ypos <= 630 + diff && v.ypos >= 626 + diff && green != 4) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				v.yinc = -4;// Speed of car
				v.xinc = 0;
			}

			if (n == 3) { // right Turn from bottom side
				v.yinc = -4;// Speed of car
				v.xinc = 0;
				// Rotating car and translating through AfflineTransform
				v.at1.rotate(Math.toRadians(v.angle), xpos, ypos);
				v.at1.translate(xpos, ypos);
				if (pause) {
					return v;
				}
				// Stoping car if signal is off
				if (v.ypos <= 630 + diff && v.ypos >= 626 + diff && green != 4) {
					v.xinc = 0;
					v.yinc = 0;
					return v;
				}
				// Rotating the car slowly to right side when it reaches a
				// specific point
				if (v.ypos <= 520) {
					if (v.angle < -75) {

						v.angle += .9;
						v.xinc = 1;
						v.yinc = -3;
					}
					if (v.angle < -30 && v.angle > -50) {

						v.angle += .87;
						v.xinc = 2;
						v.yinc = -2;
					}
					if (v.angle > -75 && v.angle < -50) {

						v.angle += .9;
						v.xinc = 1;
						v.yinc = -2;
					}
					if (v.angle < -10 && v.angle > -30) {

						v.angle += .64;
						v.xinc = 2;
						v.yinc = -1;
					}
					if (v.angle < 0 && v.angle > -10) {
						v.xinc = 2;
						v.yinc = -1;
						v.angle += .82;
					}

					if (v.angle >= 0) {
						v.xinc = 4;
						v.yinc = 0;
						v.angle = 0;
					}

				}

			}
		}

		// Incrementing xpositions and ypositions
		// to make adjustable according to all resolutions
		v.xpos += v.xinc;
		v.ypos += v.yinc;
		return v;

	}

	// method to restore signals
	private void signalsRestore() {
		Left.setIcon(Red2);
		Right.setIcon(Red3);
		Top.setIcon(Red1);
		Bottom.setIcon(Red1);

	}

	// Method to detect collision between cars
	public void collision(Shape[] r, Shape[] r2) {
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r2.length; j++) {
				if (r[i] != null && r2[j] != null) {
					if (r[i].intersects(r2[j].getBounds2D())) {

						clipCrash.start();
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						frame = new JFrame();
						frame.add(new GameOver(score));
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setUndecorated(true);
						frame.setVisible(true);
						GameMode.gamePanel.clip.stop();
						GameMode.gamePanel=null;
						TrafficMania.frame.setVisible(false);
					}
				}
			}
		}

	}

	// Method to detect collision between cars of all sides
	public void collisionAll(Shape[] r1, Shape[] r2, Shape[] r3, Shape[] r4) {
		collision(r1, r2);
		collision(r1, r3);
		collision(r1, r4);
		collision(r2, r3);
		collision(r2, r4);
		collision(r3, r4);
	}

	// setting incon of anger level
	protected void angerLevelset() {
		// anger level
		if (side1.size() > 0) {
			angerLevelLeft.setIcon(anger1side);
		}
		if (side1.size() > 3) {
			angerLevelLeft.setIcon(anger2side);
		}
		if (side1.size() > 6) {
			angerLevelLeft.setIcon(anger3side);
		}
		if (side1.size() > 9) {
			angerLevelLeft.setIcon(anger4side);
		}
		if (side1.size() > 12) {
			angerLevelLeft.setIcon(anger5side);
		}

		// anger level
		if (side2.size() > 0) {
			angerLevelRight.setIcon(anger1side);
		}
		if (side2.size() > 3) {
			angerLevelRight.setIcon(anger2side);
		}
		if (side2.size() > 6) {
			angerLevelRight.setIcon(anger3side);
		}
		if (side2.size() > 9) {
			angerLevelRight.setIcon(anger4side);
		}
		if (side2.size() > 12) {
			angerLevelRight.setIcon(anger5side);
		}
		// anger level
		if (side3.size() > 0) {
			angerLevelTop.setIcon(anger1);
		}
		if (side3.size() > 3) {
			angerLevelTop.setIcon(anger2);
		}
		if (side3.size() > 6) {
			angerLevelTop.setIcon(anger3);
		}
		if (side3.size() > 9) {
			angerLevelTop.setIcon(anger4);
		}
		if (side3.size() > 12) {
			angerLevelTop.setIcon(anger5);
		}
		// anger level
		if (side4.size() > 0) {
			angerLevelBottom.setIcon(anger1);
		}
		if (side4.size() > 3) {
			angerLevelBottom.setIcon(anger2);
		}
		if (side4.size() > 6) {
			angerLevelBottom.setIcon(anger3);
		}
		if (side4.size() > 9) {
			angerLevelBottom.setIcon(anger4);
		}
		if (side4.size() > 12) {
			angerLevelBottom.setIcon(anger5);
		}

	}

}
