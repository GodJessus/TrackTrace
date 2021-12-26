package com.flux.trackTrace.domen.impl

import javax.persistence.*

@Entity
@Table(name = "user", schema = "user_data")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Long,

    @Column(name = "chat_id")
    var chatId: Long,

    @OneToMany
    @Column(name = "captcha_id")
    var captchaId: List<Captcha>
)
