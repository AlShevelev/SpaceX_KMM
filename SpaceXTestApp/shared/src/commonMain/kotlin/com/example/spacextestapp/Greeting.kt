package com.example.spacextestapp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}