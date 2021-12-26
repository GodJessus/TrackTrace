package com.flux.trackTrace.domen.impl

import javax.persistence.*

@Entity
@Table(name = "captcha", schema = "user_data")
data class Captcha(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Long,

    @Column(name = "sid")
    var sid: String?,

    @Column(name = "ts")
    var ts: String?,

    @Lob
    @Column(name = "captcha_img")
    var captchaImg: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Captcha

        if (id != other.id) return false
        if (sid != other.sid) return false
        if (ts != other.ts) return false
        if (captchaImg != null) {
            if (other.captchaImg == null) return false
            if (!captchaImg.contentEquals(other.captchaImg)) return false
        } else if (other.captchaImg != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (sid?.hashCode() ?: 0)
        result = 31 * result + (ts?.hashCode() ?: 0)
        result = 31 * result + (captchaImg?.contentHashCode() ?: 0)
        return result
    }
}