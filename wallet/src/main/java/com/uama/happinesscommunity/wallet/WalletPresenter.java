package com.uama.happinesscommunity.wallet;

import com.uama.happinesscommunity.common.utils.L;
import com.uama.happinesscommunity.wallet.model.Wallet;
import com.uama.happinesscommunity.wallet.model.WalletDataSource;
import com.uama.happinesscommunity.wallet.model.WalletRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Jin on 2017/10/17.
 * Description 钱包模块的P层
 */
public class WalletPresenter extends WalletContract.Presenter {
	
	/**
	 * 如果数据源单一的话，项目中可以去掉Model层
	 * 数据获取在P层实现即可
 	 */
	WalletRepository mWalletRepository;
	
	@Inject
	public WalletPresenter(WalletRepository mWalletRepository) {
		this.mWalletRepository = mWalletRepository;
	}
	
	@Override
	protected void request() {
		
		// M层请求数据，M层保证数据渠道的多样性
		mWalletRepository.getWalletList(new WalletDataSource.LoadWalletListCallback() {
			@Override
			public void onWalletListLoaded(List<Wallet> list) {
				
				if (list.size() > 0) {
					L.i("Room demo : " + list.get(0).getName());
				}
				
				// 回调V层
				getView().loadView(list);
			}

			@Override
			public void onWalletListNotAvailable() {

			}
		});
	}
}
