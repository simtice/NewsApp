package com.tianzhi.newsapp.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.util.Preferences;

/**
 * 更多Fragment
 * @author xxf
 *
 */
public class MoreFragment extends Fragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.more, container, false);
		CheckBox cb = (CheckBox) view.findViewById(R.id.ck_setting_picmode);
		cb.setChecked(Preferences.getPicMode(getActivity()));

		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				Preferences.setPicMode(getActivity(), isChecked);
			}
		});
		LinearLayout ll = (LinearLayout) view
				.findViewById(R.id.ll_setting_textsize);

		final TextView tv = (TextView) view
				.findViewById(R.id.tv_setting_textsize);
		updateText(tv, "", Preferences.getTextSize(getActivity()));

		ll.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder dialog = new AlertDialog.Builder(
						getActivity());
				String[] arrays = getActivity().getResources().getStringArray(R.array.text_size);
				dialog.setSingleChoiceItems(arrays,
						Preferences.getTextSize(getActivity()),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Preferences.setTextSize(getActivity(), which);
								updateText(tv, "", which);
								dialog.dismiss();
							}
						});

				dialog.create().show();
			}
		});

		return view;
	}

	private void updateText(TextView textview, String text, int flag) {
		switch (flag) {
		case 0:
			text = "大";
			break;

		case 1:
			text = "中";
			break;
		case 2:
			text = "小";
			break;
		}
		textview.setText(text);
	}

}
