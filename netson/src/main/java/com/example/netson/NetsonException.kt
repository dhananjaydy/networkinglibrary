package com.example.netson

open class NetsonErrorException(val error: NetsonError) : Throwable(error.statusMessage){

    fun isTimeout() : Boolean {
        return error.statusCode == ERROR_CODE_TIMEOUT
    }

    companion object {
        const val ERROR_CODE_TIMEOUT = "504"
        const val ERROR_MESSAGE_TIMEOUT = "Couldn't connect to server"
        const val ERROR_CODE_UNKNOWN = "-500"
        const val ERROR_MESSAGE_UNKNOWN = "Something went wrong and we are sorry for that. Please try again later"


        fun unexpectedError(exception: Throwable): NetsonErrorException {
            val errorMessgae = "Something went wrong!"
            return NetsonErrorException(NetsonError(ERROR_CODE_UNKNOWN, errorMessgae))
        }

        fun unexpectedError(message: String?): NetsonErrorException {
            return NetsonErrorException(NetsonError(ERROR_CODE_UNKNOWN, message))
        }

        fun unexpectedError(): NetsonErrorException {
            return NetsonErrorException(NetsonError(ERROR_CODE_UNKNOWN, ERROR_MESSAGE_UNKNOWN))
        }
    }
}