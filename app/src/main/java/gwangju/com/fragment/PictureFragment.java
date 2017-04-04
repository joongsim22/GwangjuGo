package gwangju.com.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import gwangju.com.R;
import gwangju.com.item.DetailItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    public PictureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_picture, null);
        ImageView picture = (ImageView) view.findViewById(R.id.picture);
        picture.setImageBitmap((Bitmap)getArguments().getParcelable("img"));
//        Log.e("데이터가 오냐안오냐아앙", getArguments().getString("title"));

//        return super.onCreateView(inflater,container, savedInstanceState);
//        return inflater.inflate(R.layout.fragment_picture, container, false);
        return view;
    }

    public static PictureFragment newInstance(DetailItem data) {
        Bundle args = new Bundle();
        args.putParcelable("img", data.getImg());

        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
