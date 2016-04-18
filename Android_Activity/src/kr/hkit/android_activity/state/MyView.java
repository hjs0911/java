package kr.hkit.android_activity.state;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
	private Paint paint;
	//private int x, y;

	public MyView(Context context) {
		super(context);
		paint = new Paint(paint.ANTI_ALIAS_FLAG);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setColor(Color.RED);
		canvas.drawCircle(getX(), getY(), 16, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			setX(getX() + 15);
			setY(getY() + 15);
			invalidate();
			return true;
		}
		return super.onTouchEvent(event);
	}

/*	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}*/

}
