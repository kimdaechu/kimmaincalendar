package com.example.maincalendar

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.kakao.sdk.user.UserApiClient

class Kakaologin2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kakaologin2)

        val kakao_logout_button = findViewById<Button>(R.id.kakao_logout_button) // 로그인 버튼

        kakao_logout_button.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Toast.makeText(this, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, Kakaologin::class.java)
                startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        val kakao_unlink_button = findViewById<Button>(R.id.kakao_unlink_button) // 로그인 버튼

        kakao_unlink_button.setOnClickListener {
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Toast.makeText(this, "회원 탈퇴 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "회원 탈퇴 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Kakaologin::class.java)
                    startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
        }
        val nickname = findViewById<TextView>(R.id.nickname) // 로그인 버튼


        UserApiClient.instance.me { user, error ->
            nickname.text = "닉네임: ${user?.kakaoAccount?.profile?.nickname}"

        }
        val next = findViewById<Button>(R.id.next) // 진행 하기

        next.setOnClickListener {
            // 캘린더로 이동하는 코드 추가
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}