package kr.hkit.android_activity.state;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

class Vertex implements Serializable {
	private float x, y;
	private boolean isDraw;

	public Vertex(float x, float y, boolean isDraw) {
		super();
		this.x = x;
		this.y = y;
		this.isDraw = isDraw;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}

}

class FreeLine extends View {
	private Paint paint;
	private ArrayList<Vertex> arVertex;

	public ArrayList<Vertex> getArVertex() {
		return arVertex;
	}

	public void setArVertex(ArrayList<Vertex> arVertex) {
		this.arVertex = arVertex;
	}

	public FreeLine(Context context) {
		super(context);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(3);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(0xffe0e0e0);

		super.onDraw(canvas);
		for (int i = 0; i < arVertex.size(); i++) {
			if (arVertex.get(i).isDraw()) {
				canvas.drawLine(arVertex.get(i - 1).getX(), arVertex.get(i - 1).getY(), arVertex.get(i).getX(),
						arVertex.get(i).getY(), paint);
			}

		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			arVertex.add(new Vertex(event.getX(), event.getY(), false));
			return true;
		}
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			arVertex.add(new Vertex(event.getX(), event.getY(), true));
			invalidate();
			return true;
		}
		return super.onTouchEvent(event);
	}
}
	public class SaveCurve extends Activity {
		private FreeLine fLine;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			fLine = new FreeLine(this);

			if (savedInstanceState == null) {
				fLine.setArVertex(new ArrayList<Vertex>());
			} else {
				fLine.setArVertex((ArrayList<Vertex>) savedInstanceState.getSerializable("Curve"));
			}
			setContentView(fLine);
		}

		@Override
		protected void onSaveInstanceState(Bundle outState) {
			super.onSaveInstanceState(outState);
			outState.putSerializable("Curve", fLine.getArVertex());
		}
	}

