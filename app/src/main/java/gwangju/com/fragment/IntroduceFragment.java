package gwangju.com.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gwangju.com.R;
import gwangju.com.item.DetailItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceFragment extends Fragment {


    public IntroduceFragment() {
        // Required empty public constructor
    }

    // 프래그먼트 생성될 때 기능들 설정
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduce, null);

        TextView time = (TextView) view.findViewById(R.id.time_text);
        TextView fee = (TextView) view.findViewById(R.id.fee_text);
        TextView address = (TextView) view.findViewById(R.id.address_text);
        TextView call = (TextView) view.findViewById(R.id.call_text);
        TextView introduce = (TextView) view.findViewById(R.id.introduce_text);

        time.setText(getArguments().getString("time"));
        fee.setText(getArguments().getString("fee"));
        address.setText(getArguments().getString("address"));
        call.setText(getArguments().getString("call"));
        introduce.setText(getArguments().getString("introduce"));

        return view;
    }

    // 프래그먼트를 생성해서 액티비티에 뿌리는 메소드
    public static IntroduceFragment newInstance(DetailItem data) {
        Bundle args = new Bundle();
        args.putString("time", data.getTime());
        args.putString("fee", data.getFee());
        args.putString("address", data.getAddress());
        args.putString("call", data.getCall());
        args.putString("introduce", data.getIntroduce());

        IntroduceFragment fragment = new IntroduceFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
