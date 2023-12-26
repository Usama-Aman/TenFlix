package com.sam.tenflix.common

//sealed class NetworkResult<T>(val data: T? = null, val error: String? = null, val isLoading: Boolean? = null) {
//    class Success<T>(data: T) : NetworkResult<T>(data)
//    class Error<T>(data: T? = null, error: String?) : NetworkResult<T>(data, error)
//    class Loading<T>(data: T? = null, error: String?, isLoading: Boolean) : NetworkResult<T>(data, error, isLoading)
//}
//
//sealed class ApiResult<out T> {
//    data class Success<out T>(val data: T) : ApiResult<T>()
//    data class Error(val message: String) : ApiResult<Nothing>()
//    data class Loading(val isLoading: Boolean) : ApiResult<Nothing>()
//}

// This is correct and more efficient
sealed class NetworkResource<T>(val data: T? = null, val error: String? = null) {
    class Success<T>(data: T) : NetworkResource<T>(data = data)
    class Error<T>(error: String? = null) : NetworkResource<T>(error = error)
    class Loading<T>() : NetworkResource<T>()
}