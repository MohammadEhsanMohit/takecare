package com.mabgroup.takecare.feature.splash.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.cancel
import org.koin.androidx.compose.koinViewModel
import com.mabgroup.takecare.R
@Composable
fun SplashScreenView(
    onLoadingDone :(()->Unit)? = null,
    viewModel: SplashScreenViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    val progress = viewModel.progressState
    val animatedProgress = animateFloatAsState(
        targetValue = progress.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    LaunchedEffect(key1 =1) {
        viewModel.operationDone.collect {progress->
            if(progress >= 1f) {
                onLoadingDone?.invoke()
                this.cancel()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .layoutId("splash")
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(30.dp))
        CircularProgressIndicator(
            progress = animatedProgress,
            color = MaterialTheme.colorScheme.inverseOnSurface,
            strokeWidth = 5.dp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}