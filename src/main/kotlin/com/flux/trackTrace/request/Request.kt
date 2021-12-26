package com.flux.trackTrace.request

import com.flux.trackTrace.domen.UserRepository
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileOutputStream

@Component
class Request {

    @Autowired
    private lateinit var userRepository: UserRepository

    private val url: String = "https://www.posta.md/"
    private val domen: String = "ro/tracking"

    fun getCaptcha() {
//      connect to page, get data for captcha
        val doc = getContent()

//      getting captcha
        val captcha = Jsoup.connect(
            url + doc.parse()
                .select("img[typeof=\"foaf:Image\"]")
                .first()
                ?.attr("src")
        )
            .ignoreContentType(true)
            .cookies(doc.cookies())
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36")
            .method(Connection.Method.GET)
            .execute()

        var qwe = captcha.body();

        val out = (FileOutputStream(File("captcha.png")))

        out.write(captcha.bodyAsBytes())
        out.close()


        println(doc)
        println(captcha)
    }

    private fun getContent(): Connection.Response =
        Jsoup.connect(url + domen)
            .method(Connection.Method.GET)
            .execute()
}