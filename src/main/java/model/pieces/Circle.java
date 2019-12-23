package model.pieces;

import model.enumtype.Orientation;
import model.enumtype.Side;
import view.pieces.CirclePieceDrawing;
import view.pieces.PieceDrawing;

import java.io.FileNotFoundException;

public class Circle extends Piece {
	/**
	 * @param orientation   The orientation of the Circle
	 * @param line_number   The line number of the Circle
	 * @param column_number The column number of the Circle
	 * 
	 *                      initializes the attributes of the Circle
	 * 
	 */
	public Circle(int orientation, int line_number, int column_number) {
		super(orientation, line_number, column_number);
		this.id = 1;
		this.numberOfOrientations = 4;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void translation(Side side) {
		int oldOrientation = this.orientation;
		// TODO Auto-generated method stub
		if (side == Side.RIGHT) {
			if (this.orientation == 0)
				this.orientation = 3;
			else
				this.orientation--;
			this.pcs.firePropertyChange("rightTranslation", oldOrientation, this.orientation);
		} else {
			if (this.orientation == 3)
				this.orientation = 0;
			else
				this.orientation++;
			this.pcs.firePropertyChange("leftTranslation", oldOrientation, this.orientation);
		}

	}

	@Override
	public PieceDrawing createDrawing() throws FileNotFoundException {
		return new CirclePieceDrawing(this);
	}

	@Override
	public int numberOfConnection() {
		if (this.orientation == 0 && this.getOneNeighbor(Orientation.NORTH) != null)
			if (this.getOneNeighbor(Orientation.NORTH).isConnectedTo(Orientation.SOUTH))
				return 1;
		if (this.orientation == 1 && this.getOneNeighbor(Orientation.EAST) != null)
			if (this.getOneNeighbor(Orientation.EAST).isConnectedTo(Orientation.WEST))
				return 1;
		if (this.orientation == 2 && this.getOneNeighbor(Orientation.SOUTH) != null)
			if (this.getOneNeighbor(Orientation.SOUTH).isConnectedTo(Orientation.NORTH))
				return 1;
		if (this.orientation == 3 && this.getOneNeighbor(Orientation.WEST) != null)
			if (this.getOneNeighbor(Orientation.WEST).isConnectedTo(Orientation.EAST))
				return 1;
		return 0;
	}

	@Override
	public boolean isConnectedTo(Orientation orientation) {
		if (this.neighbor.containsKey(orientation)) {
			if (orientation == Orientation.NORTH && this.orientation == 0)
				return true;
			if (orientation == Orientation.EAST && this.orientation == 1)
				return true;
			if (orientation == Orientation.SOUTH && this.orientation == 2)
				return true;
			if (orientation == Orientation.WEST && this.orientation == 3)
				return true;
		}
		return false;
	}

	@Override
	public boolean connectedAll() {
		// TODO Auto-generated method stub
		return this.numberOfConnection() == this.numbeOfPossibleConnection();
	}

	public String toString() {
		String str = "";
		switch (this.orientation) {
		case 0:
			str = "\u2575";
			break;
		case 1:
			str = "\u2576";
			break;
		case 2:
			str = "\u2577";
			break;
		case 3:
			str = "\u2574";
			break;
		default:
			throw new IllegalStateException("Orientation of Circle piece " + this.orientation + "should not exist");
		}
		return str;
	}

	@Override
	public int numbeOfPossibleConnection() {
		// TODO Auto-generated method stub
		return 1;
	}

}
