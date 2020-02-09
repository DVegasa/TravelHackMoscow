package io.github.dvegasa.travelhackmoscow.screens.sequacfore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.activity_sequ.*

class SequActivity : AppCompatActivity() {

    val f = SlideDaysFragment()
    var days = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequ)

        supportFragmentManager.beginTransaction().apply {
            replace(fl.id, f)
            commit()
        }

        btnNext.setOnClickListener {
            val intent = Intent()
            intent.putExtra("ban", etBan.text.toString())
            intent.putExtra("days", days)
            setResult(123, Intent().putExtra("ban", etBan.text.toString()))
            finish()
        }
    }

    fun nextQuestion(days: Int) {
        supportFragmentManager.beginTransaction().apply {
            remove(f)
            commit()
        }
        this.days = days

        btnNext.visibility = View.VISIBLE
        secondQuiz.visibility = View.VISIBLE
    }
}
