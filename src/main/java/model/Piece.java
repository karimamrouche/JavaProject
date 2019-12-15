package model;

import view.PieceDrawing;

import java.io.FileNotFoundException;
import java.util.HashMap;

public abstract class Piece {
	protected HashMap<Orientation, Piece> neighbor;
	protected int id;
	protected int orientation;
	protected int line_number;
	protected int column_number;

	public Piece getOneNeighbor(Orientation orientation) { // rajouter une exception ? pour le cas ou le voisin n'existe
															// pas ? ou bien on suppose que le jeu est parfaitement créé
		if (this.getNeighbor().containsKey(orientation)) // avant de commencer à verifier
			return this.neighbor.get(orientation);
		else
			return null;
	}

	public HashMap<Orientation, Piece> getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(HashMap<Orientation, Piece> neighbor) {
		this.neighbor = neighbor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getLine_number() {
		return line_number;
	}

	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}

	public int getColumn_number() {
		return column_number;
	}

	public void setColumn_number(int column_number) {
		this.column_number = column_number;
	}

	/**
	 * @param orientation   The orientation of the Piece
	 * @param line_number   The line number of the Piece
	 * @param column_number The column number of the Piece
	 * 
	 *                      initializes the attributes of the Piece
	 * 
	 */
	public Piece(int orientation, int line_number, int column_number) {
		this.orientation = orientation;
		this.line_number = line_number;
		this.column_number = column_number;
		this.neighbor = new HashMap<Orientation, Piece>();
	}

	public Piece() {

	}

	public HashMap<Orientation, Piece> init_neighbors() {// � travailler

		return neighbor;
	}

	public void addNeighbor(Piece piece, Orientation orientation) {
		this.neighbor.put(orientation, piece);
	}

	/**
	 * @return a boolean that indicates if the current Piece is connected to all his neighbors
	 */
	public abstract boolean connectedAll();

	/**
	 * @param side Direction of the translation
	 * 
	 *             Changes the orientation of the Piece
	 */
	public abstract void translation(Side side);

	public abstract PieceDrawing createDrawing() throws FileNotFoundException;

	/**
	 * @return the number of Pieces that are linked to the current Piece
	 */
	public abstract int numberOfConnection();

	/**
	 * @param orientation The direction of the piece which will be checked if the
	 *                    current piece is connected to it
	 * @return a boolean which indicates if the current piece is connected to the
	 *         piece whose orientation is indicated in parameter
	 */
	public abstract boolean isConnectedTo(Orientation orientation);
}
