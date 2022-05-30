package com.sunayanpradhan.randomreels.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.randomreels.Adapters.ReelsAdapter
import com.sunayanpradhan.randomreels.Model.InformationModel
import com.sunayanpradhan.randomreels.Model.ReelsModel
import com.sunayanpradhan.randomreels.R
import com.sunayanpradhan.randomreels.databinding.FragmentReelsViewBinding


class ReelsViewFragment : Fragment() {

    lateinit var binding: FragmentReelsViewBinding

    lateinit var list: ArrayList<ReelsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reels_view, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentReelsViewBinding.bind(view)

        list=ArrayList()

        val adapter= ReelsAdapter(list,requireContext())


        val reelsId = requireArguments().getString("reelsId").toString()


        FirebaseDatabase.getInstance().reference.child("reels").addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                list.clear()

                for (dataSnapshot in snapshot.children){

                    var data:ReelsModel?=dataSnapshot.getValue(ReelsModel::class.java)

                    data?.reelsId=dataSnapshot.key.toString()

                    if (data?.reelsId==reelsId) {

                        list.add(data)

                    }




                }

                list.reverse()

                adapter.notifyDataSetChanged()


                binding.reelsViewViewPager.adapter=adapter


            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()

            }


        })




    }
}