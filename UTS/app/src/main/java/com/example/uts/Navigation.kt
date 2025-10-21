package com.example.uts

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Dashboard : Screen("dashboard_screen")
    object AddStudent : Screen("add_student_screen")
}