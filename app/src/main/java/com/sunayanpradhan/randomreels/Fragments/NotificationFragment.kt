package com.sunayanpradhan.randomreels.Fragments

import android.app.Instrumentation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.randomreels.Adapters.NotificationAdapter
import com.sunayanpradhan.randomreels.Model.NotificationModel
import com.sunayanpradhan.randomreels.R
import com.sunayanpradhan.randomreels.databinding.FragmentNotificationBinding


class NotificationFragment : Fragment() {

    lateinit var binding:FragmentNotificationBinding

    lateinit var list: ArrayList<NotificationModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding= FragmentNotificationBinding.bind(view)


        binding.ntFollowersLayout.setOnClickListener {

//            var ntFollowersFragment:Fragment=NtFollowersFragment()
//
//            val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            ft.replace(R.id.notification_fragment_container, ntFollowersFragment)
//
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//
//            ft.addToBackStack(null)
//
//            ft.commit()

            Navigation.findNavController(view).navigate(R.id.action_notificationFragment_to_ntFollowersFragment)

        }

        binding.ntLikesLayout.setOnClickListener {

//            var ntLikesFragment:Fragment=NtLikesFragment()
//
//            val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            ft.replace(R.id.notification_fragment_container, ntLikesFragment)
//
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//
//            ft.addToBackStack(null)
//
//            ft.commit()

            Navigation.findNavController(view).navigate(R.id.action_notificationFragment_to_ntLikesFragment)


        }

        binding.ntCommentsLayout.setOnClickListener {

//            var ntCommentsFragment:Fragment=NtCommentsFragment()
//
//            val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            ft.replace(R.id.notification_fragment_container, ntCommentsFragment)
//
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//
//            ft.addToBackStack(null)
//
//            ft.commit()


            Navigation.findNavController(view).navigate(R.id.action_notificationFragment_to_ntCommentsFragment)


        }


        list= ArrayList()

        var adapter: NotificationAdapter = NotificationAdapter(list,requireContext())
        var layoutManager: LinearLayoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,true)
        binding.ntRecyclerview.layoutManager=layoutManager


//        FirebaseDatabase.getInstance().reference
//            .child("notification")
//            .child(FirebaseAuth.getInstance().uid.toString())
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    list.clear()
//                    for (dataSnapshot in snapshot.children) {
//                        val notification: NotificationModel? = dataSnapshot.getValue(
//                            NotificationModel::class.java
//                        )
//                        notification?.notificationId = dataSnapshot.key.toString()
//
//
//                        list.add(notification!!)
//                    }
//
//
//                    adapter.notifyDataSetChanged()
//
//                    binding.ntRecyclerview.adapter=adapter
//
//
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//
//
//
//            })









    }

}