package com.sunayanpradhan.randomreels.Fragments

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Shader.TileMode
import android.opengl.ETC1.getHeight
import android.os.Bundle
import android.text.TextPaint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sunayanpradhan.randomreels.R
import com.sunayanpradhan.randomreels.databinding.FragmentGoogleLogInBinding


class GoogleLogInFragment : Fragment() {

    lateinit var binding: FragmentGoogleLogInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_google_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentGoogleLogInBinding.bind(view)

        binding.goToManualLogIn.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_googleLogInFragment_to_manualLogInFragment)

        }

        val paint: TextPaint = binding.logoTxt.paint
        val width = paint.measureText(getString(R.string.app_name))


        val textShader: Shader = LinearGradient(
            0f, 0f, width, binding.logoTxt.textSize, intArrayOf(
                Color.parseColor("#feda75"),
                Color.parseColor("#962fbf"),
                Color.parseColor("#d62976")
            ), null, TileMode.CLAMP
        )
        binding.logoTxt.paint.shader = textShader



    }

}