package com.example.uts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uts.screens.AddStudentScreen
import com.example.uts.screens.DashboardScreen
import com.example.uts.screens.LoginScreen
import com.example.uts.ui.theme.UTSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainAppNavigation()
                }
            }
        }
    }
}

@Composable
fun MainAppNavigation() {
    val navController = rememberNavController()
    val studentList = StudentRepository.studentList

    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen(
                navController = navController,
                studentList = studentList
            )
        }

        composable(Screen.AddStudent.route) {
            AddStudentScreen(
                navController = navController,
                onAddStudent = { newStudent ->
                    StudentRepository.studentList.add(newStudent)
                }
            )
        }
    }
}