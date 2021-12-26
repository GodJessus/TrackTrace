package com.flux.trackTrace.domen

import com.flux.trackTrace.domen.impl.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}