package model;

import view.LPieceDrawing;
import view.PieceDrawing;

import java.io.FileNotFoundException;

public class L extends Piece {

	public L(int orientation, int line_number, int column_number) {
		super(orientation, line_number, column_number);
		this.id = 5;
		// TODO Auto-generated constructor stub
	}
	
	  

	@Override
	public void translation(Side side) {
		// TODO Auto-generated method stub
		if (side == Side.RIGHT)
			if (this.orientation == 0)
				this.orientation = 3;
			else
				this.orientation--;
		else if (this.orientation == 3)
			this.orientation = 0;
		else
			this.orientation++;

	}

	@Override
	public PieceDrawing createDrawing() throws FileNotFoundException {
		return new LPieceDrawing(this);
	}



	@Override
	public int numberOfConnection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String str = "";
		switch(this.orientation) {
			case 0:
				str = "\u2514";
				break;
			case 1:
				str = "\u250C";
				break;
			case 2:
				str = "\u2510";
				break;
			case 3:
				str = "\u2518";
				break;
			default:
				throw new IllegalStateException("Orientation of L piece " + this.orientation + "should not exist");
		}
		return str;
	}
}
