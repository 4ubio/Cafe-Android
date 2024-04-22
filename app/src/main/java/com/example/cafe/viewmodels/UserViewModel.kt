package com.example.cafe.viewmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.API.APIService
import com.example.cafe.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserViewModel(val context: Context) : ViewModel() {
    //Auth from db
    private var _user = User("", "", "", "")
    var errorMessage_user: String by mutableStateOf("")
    var isAuthed: Boolean by mutableStateOf(false)
    var isAuthing: Boolean by mutableStateOf(false)
    var isAuthFailed: Boolean by mutableStateOf(false)
    val user: User get() = _user

    fun authCafeUser(email: String, password: String) {
        viewModelScope.launch {
            val route = "authUser.php/"
            val apiService = APIService.getInstance(route)
            isAuthing = true
            isAuthFailed = false
            try {
                _user = apiService.authUser(email, password)
                isAuthed = true
                isAuthing = false
            } catch (e: Exception) {
                errorMessage_user = e.message.toString()
                isAuthFailed = true
                isAuthing = false
            }
        }
    }

    fun logoutCafeUser() {
        viewModelScope.launch {
            isAuthed = false
        }
    }

    //Get user status
    private var _userStatus: String by mutableStateOf("")
    var errorMessage_status: String by mutableStateOf("")
    var isStatusLoaded: Boolean by mutableStateOf(false)
    val userStatus: String get() = _userStatus

    fun getUserStatus(id_iest: String) {
        viewModelScope.launch {
            val route = "getUser.php/"
            val apiService = APIService.getInstance(route)
            isStatusLoaded = false
            try {
                _userStatus = apiService.getUser(id_iest).estado
                isStatusLoaded = true
            } catch (e: Exception) {
                errorMessage_status = e.message.toString()
                isStatusLoaded = false
            }
        }
    }

    //Save Login Data
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "UserData")
        val ISLOGGED = booleanPreferencesKey("is_logged")
        val IDIEST = stringPreferencesKey("id_iest")
        val NAME = stringPreferencesKey("name")
        val EMAIL = stringPreferencesKey("email")
        val STATUS = stringPreferencesKey("status")
    }

    //Getters
    val is_logged: Flow<Boolean> = context.dataStore.data.map { preferences -> preferences[ISLOGGED] ?: false }
    val id_iest: Flow<String> = context.dataStore.data.map { preferences -> preferences[IDIEST] ?: "" }
    val name: Flow<String> = context.dataStore.data.map { preferences -> preferences[NAME] ?: "" }
    val email: Flow<String> = context.dataStore.data.map { preferences -> preferences[EMAIL] ?: "" }
    val status: Flow<String> = context.dataStore.data.map { preferences -> preferences[STATUS] ?: "" }

    //Setter
    suspend fun setData(is_logged: Boolean, id_iest: String, name: String, email: String, status: String) {
        context.dataStore.edit { UserData ->
            UserData[ISLOGGED] = is_logged
            UserData[IDIEST] = id_iest
            UserData[NAME] = name
            UserData[EMAIL] = email
            UserData[STATUS] = status
        }
    }
}