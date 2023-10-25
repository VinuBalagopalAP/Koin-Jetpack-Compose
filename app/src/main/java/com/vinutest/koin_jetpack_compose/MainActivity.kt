package com.vinutest.koin_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vinutest.koin_jetpack_compose.data.DefaultData
import com.vinutest.koin_jetpack_compose.data.UserStateHolder
import com.vinutest.koin_jetpack_compose.presentation.ui.UserViewModel
import com.vinutest.koin_jetpack_compose.ui.theme.KoinJetpackComposeTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KoinJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center){
        val userName = DefaultData.DEFAULT_USER.name
        FactoryInject(userName)
        ViewModelInject(userName)
    }
}

@Composable
fun FactoryInject(userName : String, presenter: UserStateHolder = koinInject()){
    Text(text = presenter.sayHello(userName), modifier = Modifier.padding(8.dp))
}

@Composable
fun ViewModelInject(userName : String, viewModel: UserViewModel = koinViewModel()){
    Text(text = viewModel.sayHello(userName), modifier = Modifier.padding(8.dp))
}