package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class Calculator extends Activity {
	private EditText First, Second, Result, History;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);

		First = (EditText) findViewById(R.id.etFirst_Number);
		Second = (EditText) findViewById(R.id.etSecond_Number);
		Result = (EditText) findViewById(R.id.etResult);
		History = (EditText) findViewById(R.id.etHistory);
	}

	public void mOnClick(View v) {
		/*CalType operType = null;
		switch(v.getId()){
		case R.id.btnAdd:
			operType = CalType.ADD;
			break;
		case R.id.btnSub:
			operType = CalType.SUB;
			break;
		case R.id.btnMul:
			operType = CalType.MUL;
			break;
		case R.id.btnDiv:
			operType = CalType.DIV;
			break;
		}*/
		
		
		InterCalculator cal = FactoryCal.getInstance(v.getId()); //객체생성 전담
		
		ArrayList<CalcData> history = cal.getHistory();
		String outStr = "";
		for(int i=0; i<history.size(); i++){
			CalcData curData = history.get(i);
			outStr += "\n#" + i + " : " + curData.getA() + ", "
					+ curData.getB() + ", "
					+ curData.getType() + ", "
					+ curData.getResult();
		}
		History.setText(outStr);
		int arg1 = Integer.parseInt(First.getText().toString());
		int arg2 = Integer.parseInt(Second.getText().toString());
		
		int result = cal.calculate(arg1, arg2);
		Result.setText(result + "");
		
	}
}
