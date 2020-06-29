package com.harshalbhakta.testkotlinreflectionandroid.models

class Admin(): BaseUser() {

    init {
        userType = UserType.ADMIN
    }

}