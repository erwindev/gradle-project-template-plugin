package com.erwin.template.util

class Interact {

    static String prompt(String message, String defaultValue = null){
        String _message = "$message " + (defaultValue ? "[$defaultValue] " : "")
        if (System.console()) {
            return System.console().readLine(_message) ?: String.valueOf(defaultValue)
        }
        println "$_message"
        return System.in.newReader().readLine() ?: String.valueOf(defaultValue)
    }
}
