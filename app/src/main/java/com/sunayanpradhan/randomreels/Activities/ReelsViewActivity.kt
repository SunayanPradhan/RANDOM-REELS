package com.sunayanpradhan.randomreels.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.randomreels.Adapters.ReelsAdapter
import com.sunayanpradhan.randomreels.Model.ReelsModel
import com.sunayanpradhan.randomreels.R
import com.sunayanpradhan.randomreels.databinding.ActivityReelsViewBinding
import com.sunayanpradhan.randomreels.databinding.FragmentReelsViewBinding

class ReelsViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityReelsViewBinding

    lateinit var list: ArrayList<ReelsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reels_view)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_reels_view)

        supportActionBar?.hide()

        this.theme?.applyStyle(R.style.FullScreen,false)
        this.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        list=ArrayList()

        val adapter= ReelsAdapter(list,this)

        var intent=intent

        val reelsId = intent.getStringExtra("reelsId").toString()


        FirebaseDatabase.getInstance().reference.child("reels").addListenerForSingleValueEvent(object :
            ValueEventListener {
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

                Toast.makeText(this@ReelsViewActivity, error.message, Toast.LENGTH_SHORT).show()

            }


        })





    }
}