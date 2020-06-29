package com.harshalbhakta.testkotlinreflectionandroid.models

class Student(): BaseUser() {

    init {
        userType = UserType.STUDENT
    }

}