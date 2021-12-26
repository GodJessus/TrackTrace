package com.flux.trackTrace

import com.flux.trackTrace.domen.impl.User
import com.flux.trackTrace.request.Request
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrackTraceApplication

fun main(args: Array<String>) {
	runApplication<TrackTraceApplication>(*args)
	val r = Request();
	println(r.getCaptcha());

//	val p = User()
}
