package com.sunayanpradhan.randomreels.Fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.randomreels.Activities.EditReelsActivity
import com.sunayanpradhan.randomreels.Activities.ViewProfileActivity
import com.sunayanpradhan.randomreels.Adapters.ReelsAdapter
import com.sunayanpradhan.randomreels.Model.InformationModel
import com.sunayanpradhan.randomreels.Model.ReelsModel
import com.sunayanpradhan.randomreels.R
import com.sunayanpradhan.randomreels.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    lateinit var list: ArrayList<ReelsModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentHomeBinding.bind(view)



        list= ArrayList()



        var adapter= ReelsAdapter(list,requireContext())




        FirebaseDatabase.getInstance().reference.child("reels").addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                list.clear()

                for (dataSnapshot in snapshot.children){

                    var data:ReelsModel?=dataSnapshot.getValue(ReelsModel::class.java)

                    data?.reelsId=dataSnapshot.key.toString()

                    list.add(data!!)




                }

                list.reverse()

                adapter.notifyDataSetChanged()


                binding.reelsViewPager.adapter=adapter


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
            }


        })


        FirebaseDatabase.getInstance().reference.child("Users").child(FirebaseAuth.getInstance().uid.toString())
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    var data:InformationModel?=snapshot.getValue(InformationModel::class.java)

                    data?.userId=snapshot.key.toString()



                    Glide.with(requireContext()).load(data?.userProfilePhoto).into(binding.homeProfile)


                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
                }


            })


        binding.homeProfileCard.setOnClickListener {

            val intent= Intent(requireContext(), ViewProfileActivity::class.java)

            intent.putExtra("userId",FirebaseAuth.getInstance().uid.toString())

            startActivity(intent)

            requireActivity().overridePendingTransition(
                R.anim.slide_in_right,0)

        }





    }

}