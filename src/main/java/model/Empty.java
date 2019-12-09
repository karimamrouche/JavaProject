package model;

import java.io.FileNotFoundException;
import java.util.HashMap;

import view.PieceDrawing;

public class Empty extends Piece {
	

	public Empty(int orientation, int line_number, int column_number) {
		super(orientation, line_number, column_number);
		this.id = 0 ;
		
	}

	@Override
	public void translation(Side side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PieceDrawing createDrawing() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numberOfConnection() {
		// TODO Auto-generated method stub
		return 0;
	}
}
