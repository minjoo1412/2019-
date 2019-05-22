import java.util.*;

// offset

/**
 * SparseMatrix Class
 *
 */


// ---------- SparseMatrix class -------------
class SparseMatrix extends LinkedMatrix {

	SparseMatrix() { } // SparseMatrix constructor.


	boolean AddOneElement(final int r, final int c, final int  v) {
		MatrixNode a = new MatrixNode(r,c,v);
		MatrixNode a2 = new MatrixNode(r,c,v);
		MatrixNode b;
		MatrixNode d;
		MatrixNode b2;
		MatrixNode d2;
		MatrixNode tru = row[r];

		if(v == 0){
			return true;
		}

		if(row[r] != null){
			while(tru.next != null && tru.col != c){
				tru = tru.next;
			}
			if(tru.col == c){
				return false;
			}
		}


		if(row[r] == null){
			row[r] = a;
			a.next = null;
		}else if(row[r].col > c){
			b = row[r];
			row[r] = a;
			a.next = b;
		}else{
			b = row[r];
			d = row[r];
			while(b.next != null && b.col < c){
				d = b;
				b = b.next;
			}
			if(b.col > c){
				a.next = d.next;
				d.next = a;
			}else{
				b.next = a;
				a.next = null;
			}
		}

		if(col[c] == null){
			col[c] = a2;
			a2.down = null;
		}else if(col[c].row > r){
			b2 = col[c];
			col[c] = a2;
			a2.down = b2;
		}else{
			b2 = col[c];
			d2 = col[c];
			while(b2.down != null && b2.row < r){
				d2 = b2;
				b2 = b2.down;
			}
			if(b2.row > r){
				a2.down = d2.down;
				d2.down = a2;
			}else{
				b2.down = a2;
				a2.down = null;
			}
		}


		return true;
	}

	boolean Delete(final int r, final int c) {
		MatrixNode trow = row[r];
		MatrixNode tcol = col[c];
		MatrixNode trufal = row[r];
		MatrixNode tmpx = row[r];
		MatrixNode tmpy = col[c];


		if(trow == null || tcol == null){
			return false;
		}

		while(trufal.next != null && trufal.col != c){
			trufal = trufal.next;
		}
		if(trufal.col != c){
			return false;
		}


		if(trow.col == c){
			if(trow.next != null){
				row[r] = trow.next;
				trow = null;
			}else{
				row[r] = null;
			}
		}else if(trow != null){
			while(trow.next != null && trow.col < c){
				tmpx = trow;
				trow = trow.next;
			}
			if(trow.next == null){
				tmpx.next = null;
				trow = null;
			}else	if(trow.next != null){
				tmpx.next = (tmpx.next).next;
				trow = null;
			}
		}

		if(tcol.row == r){
			if(tcol.down != null){
				col[c] = tcol.down;
				tcol = null;
			}else{
				col[c] = null;
			}
		}else if(tcol != null){
			while(tcol.down != null && tcol.row < r){
				tmpy = tcol;
				tcol = tcol.down;
			}
			if(tcol.down == null){
				tmpy.down = null;
				tcol = null;
			}else if(tcol.down != null){
				tmpy.down = (tmpy.down).down;
				tcol = null;
			}
		}


		return true;
	}

	SparseMatrix Add(SparseMatrix b) {
		SparseMatrix c = new SparseMatrix();
		c.Init(rows, cols);

		for(int i = 1; i <= rows; i++){
			if(b.row[i] == null){
				if(row[i]== null){
					continue;
				}
				MatrixNode apo = row[i];
				while(apo != null){
					c.AddOneElement(apo.row, apo.col, apo.value);
					apo = apo.next;
				}
				continue;
			}else if(row[i] == null){
				if(b.row[i]== null){
					continue;
				}
				MatrixNode bpo = b.row[i];
				while(bpo != null){
					c.AddOneElement(bpo.row, bpo.col, bpo.value);
					bpo = bpo.next;
				}
				continue;
			}

			MatrixNode apo = row[i];
			MatrixNode bpo = b.row[i];
			while(apo != null && bpo != null){
				if(apo.col == bpo.col){
					if((apo.value + bpo.value) == 0){
						apo = apo.next;
						bpo = bpo.next;
						continue;
					}
					c.AddOneElement(apo.row, apo.col, (apo.value+bpo.value));
					apo = apo.next;
					bpo = bpo.next;
				}else if(apo.col > bpo.col){
					c.AddOneElement(bpo.row, bpo.col, bpo.value);
					bpo = bpo.next;
				}else if(apo.col < bpo.col){
					c.AddOneElement(apo.row, apo.col, apo.value);
					apo = apo.next;
				}
			}

			while(apo != null){
				c.AddOneElement(apo.row, apo.col, apo.value);
				apo = apo.next;
			}

			while(bpo != null){
				c.AddOneElement(bpo.row, bpo.col, bpo.value);
				bpo = bpo.next;
			}
		}

		return c;
	}
}
