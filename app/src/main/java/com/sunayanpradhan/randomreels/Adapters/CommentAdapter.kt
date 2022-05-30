package com.sunayanpradhan.randomreels.Adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.*
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.randomreels.Model.CommentModel
import com.sunayanpradhan.randomreels.Model.InformationModel
import com.sunayanpradhan.randomreels.R
import java.util.*
import kotlin.collections.ArrayList

class CommentAdapter(var CommentItem:List<CommentModel>, var context: Context):RecyclerView.Adapter<CommentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.comment_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=CommentItem[position]
        val timeAgo=TimeAgo.using(currentItem.commentAt)
        holder.time.text=timeAgo

        FirebaseDatabase.getInstance().reference
            .child("Users")
            .child(currentItem.commentBy).addListenerForSingleValueEvent(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    var user: InformationModel?=snapshot.getValue(InformationModel::class.java)

                         Glide.with(context)
                        .load(user?.userProfilePhoto)
                        .into(holder.commentProfile)

                    holder.comment.text= Html.fromHtml("<b>"+user?.userName+"</b>" +"    " + currentItem.commentBody)
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

        holder.commentProfile.setOnClickListener {
//            var intent= Intent(context, ViewProfileActivity::class.java)
//            intent.putExtra("postBy",currentItem.commentBy)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            context.startActivity(intent)

        }

        holder.itemView.setOnLongClickListener{

            if (currentItem.commentBy==FirebaseAuth.getInstance().uid){

                holder.commentDelete.visibility=View.VISIBLE

            }

            else{

                holder.commentDelete.visibility=View.GONE

            }



            return@setOnLongClickListener true


        }

        holder.commentDelete.setOnClickListener {

            FirebaseDatabase.getInstance().reference
                .child("reels")
                .child(currentItem.commentPostId)
                .child("comments")
                .child(currentItem.commentId).removeValue().addOnSuccessListener {



                }



        }


        holder.commentProfile.setOnClickListener {
//            var intent=Intent(context, ViewProfileActivity::class.java)
//            intent.putExtra("postBy",currentItem.commentBy)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return CommentItem.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val comment:TextView=itemView.findViewById(R.id.comment)
        val time:TextView=itemView.findViewById(R.id.time)
        val commentProfile:ImageView=itemView.findViewById(R.id.comment_profile)
        val commentDelete:ImageView=itemView.findViewById(R.id.comment_delete)



    }

}