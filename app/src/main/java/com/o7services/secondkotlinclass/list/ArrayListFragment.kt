package com.o7services.secondkotlinclass.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.o7services.secondkotlinclass.R
import com.o7services.secondkotlinclass.databinding.FragmentArrayListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArrayListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArrayListFragment : ListFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentArrayListBinding
     var arrayList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArrayListBinding.inflate(layoutInflater)
        var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)
        arrayList.add("qwerty")
        arrayList.add("qwerty 1")
        arrayList.add("qwerty 2")
        arrayList.add("qwerty 3")

        binding.list.adapter = adapter
        //use this when the Fragment is implemented
        binding.list.setOnItemClickListener { adapterView, view, i, l ->

            System.out.println("item clicked ${arrayList[i]}")

        }

        return binding.root
    }

    //use this when the ListFragment is implemented
//    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
//        super.onListItemClick(l, v, position, id)
//        System.out.println("item clicked $position")
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArrayListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArrayListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}