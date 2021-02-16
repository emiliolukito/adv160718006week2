package com.ubaya.adv160718006week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments!=null)
        {
            var playerName = MainFragmentArgs.fromBundle(requireArguments()).playerName

            txtTurn.text = "$playerName's turn"
        }

        var angka1 = Random.nextInt(1,11)
        var angka2 = Random.nextInt(1,11)

        txtAngka1.text = angka1.toString()
        txtAngka2.text = angka2.toString()


        var score = 0
        btnAnswer.setOnClickListener {
            var answer = Integer.parseInt(txtJawaban.text.toString())

            var operasi = angka1 + angka2

            if (operasi == answer)
            {
                score+=10
                angka1 = Random.nextInt(1,11)
                angka2 = Random.nextInt(1,11)
                txtAngka1.text = angka1.toString()
                txtAngka2.text = angka2.toString()
                txtScore.setText("Score : $score")
                txtJawaban.setText("");
                txtJawaban.requestFocus()
            }
            else
            {
                var finalScore = score.toString()
                val action = MainFragmentDirections.actionMainFragment(finalScore)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}