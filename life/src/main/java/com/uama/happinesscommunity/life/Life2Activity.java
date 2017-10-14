package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jin
 */
@Route(path = "/life/Life2Activity")
public class Life2Activity extends AppCompatActivity {
	
	@Autowired
	LifeBean bean;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.life2_layout);
		ButterKnife.bind(this);
		ARouter.getInstance().inject(this);
		
		Toast.makeText(this, bean.getHa(), Toast.LENGTH_SHORT).show();
	}
	
	@OnClick(R2.id.layout)
	public void click() {
		Log.i("msg", "LifeActivity");
		ARouter.getInstance().build("/wallet/WalletActivity").navigation();
	}
}