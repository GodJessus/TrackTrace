package com.flux.trackTrace.domen

import com.flux.trackTrace.domen.impl.Captcha
import org.springframework.data.repository.CrudRepository

interface CaptchaRepository : CrudRepository<Captcha, Long> {
}