package com.mabgroup.takecare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mabgroup.takecare.feature.splash.presentation.splash.SplashScreenView
import com.mabgroup.takecare.feature.splash.presentation.util.SplashRoutingClass.SplashScreenLoadingClass
import com.mabgroup.takecare.feature.splash.presentation.util.SplashRoutingClass.GoToHome
import com.mabgroup.takecare.navigation.patientGraph
import com.mabgroup.takecare.ui.theme.TakeCareTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav = rememberNavController()
            TakeCareTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = nav, startDestination = SplashScreenLoadingClass.route) {
                        composable(SplashScreenLoadingClass.route) {
                            SplashScreenView(onLoadingDone = {
                                nav.navigate(GoToHome.route) {
                                    popUpTo(SplashScreenLoadingClass.route) {
                                        inclusive = true
                                    }
                                }
                            })
                        }
                        patientGraph(navController = nav)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TakeCareTheme {
        Greeting("Android")
    }
}