package com.sunayanpradhan.randomreels.Fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.randomreels.Activities.SearchActivity
import com.sunayanpradhan.randomreels.Adapters.SearchAdapter
import com.sunayanpradhan.randomreels.Model.InformationModel
import com.sunayanpradhan.randomreels.R
import com.sunayanpradhan.randomreels.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {


    lateinit var binding: FragmentSearchBinding

    lateinit var list: ArrayList<InformationModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSearchBinding.bind(view)

        list= ArrayList()

        val adapter:SearchAdapter= SearchAdapter(list,requireContext())

        val layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.searchRecyclerview.layoutManager=layoutManager

        FirebaseDatabase.getInstance().reference.child("Users").addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                list.clear()

                for (dataSnapshot in snapshot.children){

                    var data:InformationModel?=dataSnapshot.getValue(InformationModel::class.java)

                    data?.userId=dataSnapshot.key.toString()

                        list.add(data!!)


                }

                adapter.notifyDataSetChanged()

                binding.searchRecyclerview.adapter=adapter


            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()

            }


        })

        binding.searchSearch.setOnClickListener {

            var intent= Intent(requireContext(),SearchActivity::class.java)

            startActivity(intent)

            (requireContext() as Activity).overridePendingTransition(
                0,0)

        }



    }



}