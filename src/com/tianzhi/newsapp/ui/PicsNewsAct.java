package com.tianzhi.newsapp.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.adapter.PicsNewsAdapter;
import com.tianzhi.newsapp.beans.NewsPicContent;
import com.tianzhi.newsapp.beans.Photo;
import com.tianzhi.newsapp.util.Constant;

/**
 * 图片新闻样式界面
 * @author xxf
 *
 */
public class PicsNewsAct extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pics_news);
		final String urls[] = {Constant.imageUrls[21],Constant.imageUrls[22],Constant.imageUrls[23],Constant.imageUrls[24],Constant.imageUrls[25]};
		
		final String contents[] = {
				"这城管白天是执法者，到了晚上自己又成了被执法的对象，和城管队员打游击，这多少有些讽刺意味的猫和老鼠角色颠倒，在一开始博得了不少人的同情。大家纷纷猜测，是不是这位城管家庭比较困难，所以晚上出来摆地摊补贴下家用呢？",
				"不过更让人惊讶的事儿还在后头，昨天上午，武汉市城市综合管理委员会召开新闻通气会，官方回应解释为现实版的《无间道》。武汉市洪山区城管局党委书记李运祥说，城管摆摊不为赚钱，其实是作为卧底，换位思考，来体验小摊贩儿的生活。",
				"李运祥：他站在摆摊者的角度，怎么去看待我们的执法，我们也想通过他们的感受，来纠正我们在执法过程当中一些不合理的现象，包括一些不文明不人性化的这些行为，这是我们的初衷。",
				"武汉市城管委介绍说，他们向洪山区城管局了解了情况，决定要公布一下事情的真相，原来摆地摊的两名城管工作者分别是武汉市洪山区城管局执法大队直属七中队执法人员桂文静和局办公室工作人员杨希，他们从今年5月份开始在武昌徐东新世界百货附近摆摊卖小饰品和水杯等。",
				"桂文静：说实话，我没有想到，今天这个事情，会引起这么大的关注。我们当时的初衷，只是为了了解这个群体的一些生存状况，我们只是把我们收集的资料，送给我们的领导作为参考，也许对我们以后的执法工作有一定的借鉴。" };

		
		ListView listView = (ListView) this.findViewById(R.id.single_list);

		NewsPicContent content = new NewsPicContent();
		ArrayList<Photo> photos = new ArrayList<Photo>();
		for (int i = 0; i < urls.length; i++) {
			Photo bean = new Photo();
			bean.setPicUrl(urls[i]);
			if (i < contents.length - 1) {
				bean.setDescription(contents[i]);
			}
			
			photos.add(bean);
		}

		content.setGallery(photos);
		final PicsNewsAdapter adapter = new PicsNewsAdapter(content.getGallery(), this);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(PicsNewsAct.this,GroupPicsAct.class);
				intent.putExtra("urls", urls);
				intent.putExtra("index", arg2);
				intent.putExtra("contents", contents);
				intent.putExtra("title", getIntent().getStringExtra("title"));
				startActivity(intent);
				
			}
		});

		listView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == SCROLL_STATE_FLING) {
					adapter.setFling(true);
				} else {
					adapter.setFling(false);
					adapter.notifyDataSetChanged();
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

			}
		});

	}
}
