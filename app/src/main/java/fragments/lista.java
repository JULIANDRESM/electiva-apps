package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jammsoft.proyectofinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class lista extends Fragment {

    private ListView listaTelefonica;


    public lista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_lista, container);
        return view;

        //return inflater.inflate(R.layout.fragment_lista, container, false);
    }

}
